package com.hogentessentials1.essentials.data.network

class DeviceTokenRemoteDataSource(val deviceTokenApiService: DeviceTokenEndpointInterface) : BaseDataSource() {
    suspend fun postDeviceToken(userid: Int, token: String) {
        deviceTokenApiService.postDeviceToken(userid.toString(), token)
    }
}
