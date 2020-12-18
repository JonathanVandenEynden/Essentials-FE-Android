package com.hogentessentials1.essentials.data.network

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray

class DeviceTokenRemoteDataSource(val deviceTokenApiService: DeviceTokenEndpointInterface): BaseDataSource() {
    suspend fun postDeviceToken (userid: Int, token: String) {
        val requestBody = token.toRequestBody("application/json".toMediaTypeOrNull())
        deviceTokenApiService.postDeviceToken(userid, requestBody)
    }
}