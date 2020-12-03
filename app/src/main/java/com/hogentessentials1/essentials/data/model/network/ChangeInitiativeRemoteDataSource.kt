package com.hogentessentials1.essentials.data.model.network

class ChangeInitiativeRemoteDataSource(val ciApiService: ChangeInitiativesEndpointInterface) : BaseDataSource() {

    suspend fun getChangeInitiativeById(id: Int) =
        getResult { ciApiService.getChangeInitiativeById(id) }

    suspend fun getChangeInitiatives() = getResult { ciApiService.getChangeInitiatives()}

    suspend fun getChangeInitiativesForChangeManager() =
        getResult { ciApiService.getChangeInitiativesForChangeManager() }
}
