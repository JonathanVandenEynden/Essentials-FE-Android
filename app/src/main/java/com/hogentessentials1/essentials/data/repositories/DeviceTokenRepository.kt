package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.network.DeviceTokenRemoteDataSource

class DeviceTokenRepository(val remoteDataSource: DeviceTokenRemoteDataSource) {
    suspend fun postDeviceToken(userid: Int, token: String) {
        return remoteDataSource.postDeviceToken(userid, token)
    }
}
