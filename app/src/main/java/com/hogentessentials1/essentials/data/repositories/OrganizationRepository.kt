package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.model.Organization
import com.hogentessentials1.essentials.data.network.BaseDataSource
import com.hogentessentials1.essentials.data.network.OrganizationRemoteDataSource
import com.hogentessentials1.essentials.util.Resource
import javax.inject.Singleton

/**
 * Repository for organizations
 *
 * @property remoteDataSource
 */
@Singleton
class OrganizationRepository(val remoteDataSource: OrganizationRemoteDataSource) : BaseDataSource() {

    /**
     * get organization by id
     * @param organizationId
     * @return Resource with organization
     */
    suspend fun getOrganizationById(organizationId: Int): Resource<Organization> {
        return remoteDataSource.getOrganizationById(organizationId)
    }
}
