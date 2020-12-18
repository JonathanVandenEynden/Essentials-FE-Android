package com.hogentessentials1.essentials.data.network

/**
 * The remote data source for change groups
 *
 * @property cgApiService
 */
class ChangeGroupRemoteDataSource(val cgApiService: ChangeGroupEndpointInterface) : BaseDataSource() {

    /**
     * gets all change groups for the logged in user
     *
     */
    suspend fun getChangeGroupsForUser() = getResult { cgApiService.getChangeGroupsForUser() }
}
