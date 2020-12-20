package com.hogentessentials1.essentials.data.network

/**
 * The remote data source for change groups
 *
 * @author Kilian Hoefman
 * @author Simon De Wilde
 *
 *
 * @property cgApiService
 */
class ChangeGroupRemoteDataSource(private val cgApiService: ChangeGroupEndpointInterface) : BaseDataSource() {

    /**
     * gets all change groups for the logged in user
     *
     */
    suspend fun getChangeGroupsForUser() = getResult { cgApiService.getChangeGroupsForUser() }
}
