package com.hogentessentials1.essentials.network

import com.hogentessentials1.essentials.BuildConfig
import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.security.cert.CertificateException
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/**
 * Author Simon De Wilde
 *
 * service for getting change groups from the essentials api
 *
 */

private const val BASE_URL = "https://10.0.2.2:5001/api/ChangeGroups/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// private val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
//    .baseUrl(BASE_URL)
//    .build()
private val retrofit = provideRetrofit(provideOkHttpClient(), BASE_URL)

private fun provideOkHttpClient(): OkHttpClient {
    // !!Enkel als de applicatie in debug draait, mogen alle certificaten aanvaard worden!!
    // https://gist.github.com/maiconhellmann/c61a533eca6d41880fd2b3f8459c07f7
    if (BuildConfig.DEBUG) {
        try {
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                @Throws(CertificateException::class)
                override fun checkClientTrusted(
                    chain: Array<java.security.cert.X509Certificate>,
                    authType: String
                ) {
                }
                @Throws(CertificateException::class)
                override fun checkServerTrusted(
                    chain: Array<java.security.cert.X509Certificate>,
                    authType: String
                ) {
                }
                override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
                    return arrayOf()
                }
            })

            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, java.security.SecureRandom())
            val sslSocketFactory = sslContext.socketFactory

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            return OkHttpClient.Builder()
                .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
                .hostnameVerifier(hostnameVerifier = HostnameVerifier { _, _ -> true })
                .addInterceptor(loggingInterceptor)
                .build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    } else {
        return OkHttpClient.Builder().build()
    }
}

/**
 * Provide the retrofti instance
 */
private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    BASE_URL: String
): Retrofit =
    Retrofit.Builder()
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(
                    KotlinJsonAdapterFactory()
                ).build()
            )
        )
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

interface ChangeGroupApiService {

    @GET("GetChangeGroupForUser/{userId}")
    suspend fun getChangeGroupsForUser(@Path("userId") userId: Int): List<ChangeGroup>
}

object ChangeGroupApi {
    val changeGroupApiService: ChangeGroupApiService by lazy { retrofit.create(ChangeGroupApiService::class.java) }
}
