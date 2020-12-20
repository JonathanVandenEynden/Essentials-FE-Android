package com.hogentessentials1.essentials.data.network

/**
 * The remote data source for device tokens
 *
 * @author Marbod Naassens
 *
 * @property deviceTokenApiService
 */
class DeviceTokenRemoteDataSource(private val deviceTokenApiService: DeviceTokenEndpointInterface) : BaseDataSource() {
    /**
     * post the devicetoken for the user's device with the given userId and the token
     *
     * @param userid
     * @param token
     */
    suspend fun postDeviceToken(userid: Int, token: String) {
        deviceTokenApiService.postDeviceToken(userid.toString(), token)
    }
}
