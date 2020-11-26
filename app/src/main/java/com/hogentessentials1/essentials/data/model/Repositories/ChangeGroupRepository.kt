package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.data.model.DAOs.ChangeGroupDao
import com.hogentessentials1.essentials.data.model.network.ChangeGroupRemoteDataSource
import com.hogentessentials1.essentials.data.model.network.EmployeeRemoteDataSource
import com.hogentessentials1.essentials.data.model.util.Resource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class ChangeGroupRepository(val remoteDataSource: ChangeGroupRemoteDataSource) {

    suspend fun getChangeGroupsForUser(userId: Int): Resource<List<ChangeGroup>> = remoteDataSource.getChangeGroupsForUser(userId)
}
