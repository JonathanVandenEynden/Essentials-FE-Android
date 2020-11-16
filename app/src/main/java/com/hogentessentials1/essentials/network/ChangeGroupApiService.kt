package com.hogentessentials1.essentials.network

import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Author Simon De Wilde
 *
 * service for getting change groups from the essentials api
 *
 */

private const val BASE_URL = "https://localhost:5001/api/ChangeGroups/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ChangeGroupApiService {

    @GET("GetChangeGroupForUser/{userId}")
    suspend fun getChangeGroupsForUser(@Path("userId") userId: Number): List<ChangeGroup>
}

object ChangeGroupApi {
    val changeGroupApiService: ChangeGroupApiService by lazy { retrofit.create(ChangeGroupApiService::class.java) }
}
