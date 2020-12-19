package com.hogentessentials1.essentials.data.network

/**
 * The remote data source for change manager
 *
 * @author Kilian Hoefman
 *
 * @property cmApiService
 */
class ChangeManagerRemoteDataSource(val cmApiService: ChangeManagersEndpointInterface) : BaseDataSource() {

    /**
     * get a change manager with a given id
     *
     * @param changeManagerId
     */
    suspend fun getChangeManagerById(changeManagerId: Int) = getResult { cmApiService.getChangeManagerById(changeManagerId) }

    /**
     * gets all change managers from an organization with a given id
     *
     * @param organizationId
     */
    suspend fun getChangeManagersFromOrganizationWithId(organizationId: Int) = getResult { cmApiService.getChangeManagersFromOrganizationWithId(organizationId) }

    /**
     * get a change manager with a given email
     *
     * @param email
     */
    suspend fun getChangeManagerByEmail(email: String) = getResult { cmApiService.getChangeManagerByEmail(email) }
}
