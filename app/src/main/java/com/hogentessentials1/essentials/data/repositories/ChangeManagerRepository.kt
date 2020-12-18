package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.model.ChangeManager
import com.hogentessentials1.essentials.data.network.ChangeManagerRemoteDataSource
import com.hogentessentials1.essentials.util.Resource

/**
 * Repository for change managers
 * @author Kilian Hoefman
 *
 * @property remoteDataSource
 */
class ChangeManagerRepository(val remoteDataSource: ChangeManagerRemoteDataSource) {

    /**
     * get change manager by id
     * @param changeManagerId
     * @return resource with change manager
     */
    suspend fun getChangeManagerById(changeManagerId: Int): Resource<ChangeManager> {
        return remoteDataSource.getChangeManagerById(changeManagerId)
    }

    /**
     * get all change managers by organizationId
     * @param organizationId
     * @return Resource with list of change managers
     */
    suspend fun getChangeManagersFromOrganizationWithId(organizationId: Int): Resource<List<ChangeManager>> {
        return remoteDataSource.getChangeManagersFromOrganizationWithId(organizationId)
    }

    /**
     * get change manager by email
     * @return resource with change manager
     * @param email
     */
    suspend fun getChangeManagerByEmail(email: String): Resource<ChangeManager> {
        return remoteDataSource.getChangeManagerByEmail(email)
    }
}
