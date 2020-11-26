package com.hogentessentials1.essentials.data.model.network

class ChangeGroupRemoteDataSource(val cgApiService: ChangeGroupApiService) : BaseDataSource() {

    suspend fun getChangeGroupsForUser(userId: Int) = getResult { cgApiService.getChangeGroupsForUser(userId) }
}