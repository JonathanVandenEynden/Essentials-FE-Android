package com.hogentessentials.essentials.data.network

class ChangeGroupRemoteDataSource(val cgApiService: ChangeGroupEndpointInterface) : BaseDataSource() {

    suspend fun getChangeGroupsForUser() = getResult { cgApiService.getChangeGroupsForUser() }
}
