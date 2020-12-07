package com.hogentessentials.essentials.DI

import com.hogentessentials.essentials.BuildConfig
import com.hogentessentials.essentials.data.network.AccountEndpointInterface
import com.hogentessentials.essentials.data.network.ChangeGroupEndpointInterface
import com.hogentessentials.essentials.data.network.ChangeGroupRemoteDataSource
import com.hogentessentials.essentials.data.network.ChangeInitiativeRemoteDataSource
import com.hogentessentials.essentials.data.network.ChangeInitiativesEndpointInterface
import com.hogentessentials.essentials.data.network.ChangeManagerRemoteDataSource
import com.hogentessentials.essentials.data.network.ChangeManagersEndpointInterface
import com.hogentessentials.essentials.data.network.DashboardEndpointInterface
import com.hogentessentials.essentials.data.network.DashboardRemoteDataSource
import com.hogentessentials.essentials.data.network.EmployeeEndpointInterface
import com.hogentessentials.essentials.data.network.EmployeeRemoteDataSource
import com.hogentessentials.essentials.data.network.EssentialsDatabase
import com.hogentessentials.essentials.data.network.OrganizationRemoteDataSource
import com.hogentessentials.essentials.data.network.OrganizationsEndpointInterface
import com.hogentessentials.essentials.data.network.ProjectRemoteDataSource
import com.hogentessentials.essentials.data.network.ProjectsEndpointInterface
import com.hogentessentials.essentials.data.network.QuestionRemoteDataSource
import com.hogentessentials.essentials.data.network.QuestionsEndpointInterface
import com.hogentessentials.essentials.data.network.RoadMapItemsEndpointInterface
import com.hogentessentials.essentials.data.network.RoadMapRemoteDataSource
import com.hogentessentials.essentials.data.network.SurveyEndpointInterface
import com.hogentessentials.essentials.data.network.SurveyRemoteDataSource
import com.hogentessentials.essentials.data.network.local.ChangeGroupLocalDataSource
import com.hogentessentials.essentials.data.network.local.ChangeInitiativeLocalDataSource
import com.hogentessentials.essentials.data.repositories.ChangeGroupRepository
import com.hogentessentials.essentials.data.repositories.ChangeInitiativeRepository
import com.hogentessentials.essentials.data.repositories.ChangeManagerRepository
import com.hogentessentials.essentials.data.repositories.DashboardRepository
import com.hogentessentials.essentials.data.repositories.EmployeeRepository
import com.hogentessentials.essentials.data.repositories.OrganizationRepository
import com.hogentessentials.essentials.data.repositories.ProjectRepository
import com.hogentessentials.essentials.data.repositories.QuestionRepository
import com.hogentessentials.essentials.data.repositories.RoadMapRepository
import com.hogentessentials.essentials.data.repositories.SurveyRepository
import com.hogentessentials.essentials.ui.login.data.LoginDataSource
import com.hogentessentials.essentials.ui.login.data.LoginRepository
import com.hogentessentials.essentials.util.Globals
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    // retrofit and interfaces
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), Globals.BASE_URL) }
    single { provideRmiEndpointInterface(get()) }
    single { provideChangeInitiativeEndpointInterface(get()) }
    single { provideChangeGroupEndpointInterface(get()) }
    single { provideProjectEndpointInterface(get()) }
    single { provideQuestionEndpointInterface(get()) }
    single { provideOrganizationEndpointInterface(get()) }
    single { provideEmployeeEndpointInterface(get()) }
    single { provideChangeManagerEndpointInterface(get()) }
    single { provideSurveyEndpointInterface(get()) }
    single { provideAccountEndpointInterface(get()) }
    single { provideDashboardEndpointInterface(get()) }

    // remote datasources
    single { RoadMapRemoteDataSource(get()) }
    single { ChangeInitiativeRemoteDataSource(get()) }
    single { ChangeGroupRemoteDataSource(get()) }
    single { ProjectRemoteDataSource(get()) }
    single { QuestionRemoteDataSource(get()) }
    single { OrganizationRemoteDataSource(get()) }
    single { EmployeeRemoteDataSource(get()) }
    single { ChangeManagerRemoteDataSource(get()) }
    single { SurveyRemoteDataSource(get()) }
    single { LoginDataSource(get()) }
    single { DashboardRemoteDataSource(get()) }

    // local datasources
    single { ChangeInitiativeLocalDataSource(get()) }
    single { ChangeGroupLocalDataSource(get()) }

    // Daos
    single { EssentialsDatabase.getInstance(androidApplication()).ChangeInitiativeDao() }
    single { EssentialsDatabase.getInstance(androidApplication()).ChangeGroupDao() }

    // repos
    single { RoadMapRepository(get()) }
    single { ChangeInitiativeRepository(get(), get()) }
    single { ChangeGroupRepository(get(), get()) }
    single { ProjectRepository(get()) }
    single { QuestionRepository(get()) }
    single { OrganizationRepository(get()) }
    single { EmployeeRepository(get()) }
    single { ChangeManagerRepository(get()) }
    single { SurveyRepository(get()) }
    single { LoginRepository(get()) }
    single { DashboardRepository(get()) }
}

/**
 * Provided a OkHttpClient. In debug version, an interceptor is added
 * as to log the network information which has been received.
 */
private fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        // Interceptor to add header to each request
        .addInterceptor(
            Interceptor {
                val original: Request = it.request()
                val newRequest: Request = original.newBuilder()
                    .header("Authorization", "Bearer ${Globals.bearerToken}")
                    .build()

                return@Interceptor it.proceed(newRequest)
            }
        )
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

private fun provideRmiEndpointInterface(retrofit: Retrofit): RoadMapItemsEndpointInterface =
    retrofit.create(RoadMapItemsEndpointInterface::class.java)

private fun provideChangeInitiativeEndpointInterface(retrofit: Retrofit): ChangeInitiativesEndpointInterface =
    retrofit.create(ChangeInitiativesEndpointInterface::class.java)

private fun provideChangeGroupEndpointInterface(retrofit: Retrofit): ChangeGroupEndpointInterface =
    retrofit.create(ChangeGroupEndpointInterface::class.java)

private fun provideProjectEndpointInterface(retrofit: Retrofit): ProjectsEndpointInterface =
    retrofit.create(ProjectsEndpointInterface::class.java)

private fun provideQuestionEndpointInterface(retrofit: Retrofit): QuestionsEndpointInterface =
    retrofit.create(QuestionsEndpointInterface::class.java)

private fun provideOrganizationEndpointInterface(retrofit: Retrofit): OrganizationsEndpointInterface =
    retrofit.create(OrganizationsEndpointInterface::class.java)

private fun provideEmployeeEndpointInterface(retrofit: Retrofit): EmployeeEndpointInterface =
    retrofit.create(EmployeeEndpointInterface::class.java)

private fun provideChangeManagerEndpointInterface(retrofit: Retrofit): ChangeManagersEndpointInterface =
    retrofit.create(ChangeManagersEndpointInterface::class.java)

private fun provideSurveyEndpointInterface(retrofit: Retrofit): SurveyEndpointInterface =
    retrofit.create(SurveyEndpointInterface::class.java)

private fun provideAccountEndpointInterface(retrofit: Retrofit): AccountEndpointInterface =
    retrofit.create(AccountEndpointInterface::class.java)

private fun provideDashboardEndpointInterface(retrofit: Retrofit): DashboardEndpointInterface =
    retrofit.create(DashboardEndpointInterface::class.java)
