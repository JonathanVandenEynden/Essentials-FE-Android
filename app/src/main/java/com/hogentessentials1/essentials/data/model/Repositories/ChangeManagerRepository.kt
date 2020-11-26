package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.ChangeManager
import com.hogentessentials1.essentials.data.model.network.ChangeManagerRemoteDataSource
import com.hogentessentials1.essentials.data.model.util.Resource

class ChangeManagerRepository(val remoteDataSource: ChangeManagerRemoteDataSource) {

    suspend fun getChangeManagerById(changeManagerId: Int) : Resource<ChangeManager> {
        return remoteDataSource.getChangeManagerById(changeManagerId)
    }

    suspend fun getChangeManagersFromOrganizationWithId(organizationId: Int) : Resource<List<ChangeManager>> {
        return remoteDataSource.getChangeManagersFromOrganizationWithId(organizationId)
    }

    suspend fun getChangeManagerByEmail(email: String) : Resource<ChangeManager> {
        return remoteDataSource.getChangeManagerByEmail(email)
    }
}