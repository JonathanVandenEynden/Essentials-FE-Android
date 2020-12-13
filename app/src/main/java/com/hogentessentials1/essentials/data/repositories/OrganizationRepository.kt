package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.model.Organization
import com.hogentessentials1.essentials.data.network.BaseDataSource
import com.hogentessentials1.essentials.data.network.OrganizationRemoteDataSource
import com.hogentessentials1.essentials.util.Resource

class OrganizationRepository(val remoteDataSource: OrganizationRemoteDataSource) : BaseDataSource() {

    suspend fun getOrganizationById(organizationId: Int): Resource<Organization> {
        return remoteDataSource.getOrganizationById(organizationId)
    }
}
