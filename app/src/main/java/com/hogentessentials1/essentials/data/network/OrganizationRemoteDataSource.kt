package com.hogentessentials1.essentials.data.network

/**
 * The remote data source for organizations
 * @author Kilian Hoefman
 * @property cgApiService
 */
class OrganizationRemoteDataSource(private val cgApiService: OrganizationsEndpointInterface) : BaseDataSource() {

    /**
     * gets an organization with a given id
     *
     * @param organizationId
     */
    suspend fun getOrganizationById(organizationId: Int) = getResult { cgApiService.getOrganizationById(organizationId) }
}
