package com.hogentessentials1.essentials.data.model.network

class ChangeInitiativeRemoteDataSource(val rmiApiService: ChangeInitiativesEndpointInterface) : BaseDataSource() {

    suspend fun getChangeInitiativeById(id: Int) = getResult { rmiApiService.getChangeInitiativeById(id) }

    suspend fun getChangeInitiativesForEmployee(employeeId: Int) = getResult { rmiApiService.getChangeInitiativesForEmployee(employeeId)}

    suspend fun getChangeInitiativesForChangeManager(changeManagerId: Int) = getResult { rmiApiService.getChangeInitiativesForChangeManager(changeManagerId) }
}
