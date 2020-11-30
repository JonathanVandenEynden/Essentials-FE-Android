package com.hogentessentials1.essentials.data.model.network

class ChangeInitiativeRemoteDataSource(val ciApiService: ChangeInitiativesEndpointInterface) : BaseDataSource() {

    suspend fun getChangeInitiativeById(id: Int) =
        getResult { ciApiService.getChangeInitiativeById(id) }

    suspend fun getChangeInitiativesForEmployee(employeeId: Int) =
        getResult { ciApiService.getChangeInitiativesForEmployee(employeeId) }

    suspend fun getChangeInitiativesForChangeManager(changeManagerId: Int) =
        getResult { ciApiService.getChangeInitiativesForChangeManager(changeManagerId) }
}
