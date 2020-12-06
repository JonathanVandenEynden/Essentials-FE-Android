package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.Organization
import com.hogentessentials1.essentials.data.model.network.BaseDataSource
import com.hogentessentials1.essentials.data.model.network.OrganizationRemoteDataSource
import com.hogentessentials1.essentials.data.model.util.Resource

class OrganizationRepository(val remoteDataSource: OrganizationRemoteDataSource) : BaseDataSource() {

    suspend fun getOrganizationById(organizationId: Int): Resource<Organization> {
        return remoteDataSource.getOrganizationById(organizationId)
    }
}
