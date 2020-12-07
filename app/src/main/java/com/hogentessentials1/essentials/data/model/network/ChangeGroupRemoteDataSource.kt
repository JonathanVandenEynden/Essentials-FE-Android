package com.hogentessentials1.essentials.data.model.network

class ChangeGroupRemoteDataSource(val cgApiService: ChangeGroupEndpointInterface) : BaseDataSource() {

    suspend fun getChangeGroupsForUser() = getResult { cgApiService.getChangeGroupsForUser() }
}
