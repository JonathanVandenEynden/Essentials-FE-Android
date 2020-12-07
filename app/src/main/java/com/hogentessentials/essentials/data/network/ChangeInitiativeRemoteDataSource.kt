package com.hogentessentials.essentials.data.network

class ChangeInitiativeRemoteDataSource(val ciApiService: ChangeInitiativesEndpointInterface) : BaseDataSource() {

    suspend fun getChangeInitiativeById(id: Int) =
        getResult { ciApiService.getChangeInitiativeById(id) }

    suspend fun getChangeInitiativesForEmployee() =
        getResult { ciApiService.getChangeInitiativesForEmployee() }

    suspend fun getChangeInitiativesForChangeManager() =
        getResult { ciApiService.getChangeInitiativesForChangeManager() }
}
