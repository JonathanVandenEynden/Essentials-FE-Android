package com.hogentessentials1.essentials.data.network

/**
 * The remote data source for device tokens
 *
 * @author Marbod Naassens
 *
 * @property deviceTokenApiService
 */
class DeviceTokenRemoteDataSource(val deviceTokenApiService: DeviceTokenEndpointInterface) : BaseDataSource() {
    suspend fun postDeviceToken(userid: Int, token: String) {
        deviceTokenApiService.postDeviceToken(userid.toString(), token)
    }
}
