package com.hogentessentials1.essentials.data.network

/**
 * The remote data source for change initiatives
 * @author Kilian Hoefman
 * @property ciApiService
 */
class ChangeInitiativeRemoteDataSource(private val ciApiService: ChangeInitiativesEndpointInterface) : BaseDataSource() {

    /**
     * gets a change initiative with a specific id
     *
     * @param id
     */
    suspend fun getChangeInitiativeById(id: Int) =
        getResult { ciApiService.getChangeInitiativeById(id) }

    /**
     * gets all change initiatives from the logged in user
     *
     */
    suspend fun getChangeInitiativesForEmployee() =
        getResult { ciApiService.getChangeInitiativesForEmployee() }

    /**
     * gets all change initiatives the logged in user (change manager) has created
     *
     */
    suspend fun getChangeInitiativesForChangeManager() =
        getResult { ciApiService.getChangeInitiativesForChangeManager() }
}
