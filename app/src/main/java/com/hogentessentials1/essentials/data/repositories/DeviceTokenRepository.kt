package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.network.DeviceTokenRemoteDataSource
import javax.inject.Singleton

/**
 * Repository for device tokens
 * @author Marbod Naassens
 * @property remoteDataSource
 */
@Singleton
class DeviceTokenRepository(val remoteDataSource: DeviceTokenRemoteDataSource) {
    /**
     * post a device token of the last signed in user
     *
     * @param userid
     * @param token
     */
    suspend fun postDeviceToken(userid: Int, token: String) {
        return remoteDataSource.postDeviceToken(userid, token)
    }
}
