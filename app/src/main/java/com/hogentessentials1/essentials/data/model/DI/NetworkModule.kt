package com.hogentessentials1.essentials.data.model.DI

import com.hogentessentials1.essentials.BuildConfig
import com.hogentessentials1.essentials.data.model.network.EssentialsApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Provided a OkHttpClient. In debug version, an interceptor is added
 * as to log the network information which has been received.
 */
private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
} else OkHttpClient
    .Builder()
    .build()

/**
 * Provide the retrofit instance
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

/*
 * Provide the API Service
 */

private fun provideApiService(retrofit: Retrofit): EssentialsApiService =
    retrofit.create(EssentialsApiService::class.java)
