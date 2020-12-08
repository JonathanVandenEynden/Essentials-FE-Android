package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.model.ChangeManager
import com.hogentessentials1.essentials.data.network.ChangeManagerRemoteDataSource
import com.hogentessentials1.essentials.util.Resource

class ChangeManagerRepository(val remoteDataSource: ChangeManagerRemoteDataSource) {

    suspend fun getChangeManagerById(changeManagerId: Int): Resource<ChangeManager> {
        return remoteDataSource.getChangeManagerById(changeManagerId)
    }

    suspend fun getChangeManagersFromOrganizationWithId(organizationId: Int): Resource<List<ChangeManager>> {
        return remoteDataSource.getChangeManagersFromOrganizationWithId(organizationId)
    }

    suspend fun getChangeManagerByEmail(email: String): Resource<ChangeManager> {
        return remoteDataSource.getChangeManagerByEmail(email)
    }
}
