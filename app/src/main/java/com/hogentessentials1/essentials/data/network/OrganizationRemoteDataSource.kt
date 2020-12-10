package com.hogentessentials1.essentials.data.network

class OrganizationRemoteDataSource(val cgApiService: OrganizationsEndpointInterface) : BaseDataSource() {

    suspend fun getOrganizationById(organizationId: Int) = getResult { cgApiService.getOrganizationById(organizationId) }
}
