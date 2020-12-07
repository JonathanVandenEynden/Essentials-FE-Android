package com.hogentessentials.essentials.data.repositories

import com.hogentessentials.essentials.data.model.Organization
import com.hogentessentials.essentials.data.network.BaseDataSource
import com.hogentessentials.essentials.data.network.OrganizationRemoteDataSource
import com.hogentessentials.essentials.util.Resource

class OrganizationRepository(val remoteDataSource: OrganizationRemoteDataSource) : BaseDataSource() {

    suspend fun getOrganizationById(organizationId: Int): Resource<Organization> {
        return remoteDataSource.getOrganizationById(organizationId)
    }
}
