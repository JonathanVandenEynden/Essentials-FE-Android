package com.hogentessentials.essentials.data.repositories

import com.hogentessentials.essentials.data.model.ChangeGroup
import com.hogentessentials.essentials.data.network.ChangeGroupRemoteDataSource
import com.hogentessentials.essentials.data.network.local.ChangeGroupLocalDataSource
import com.hogentessentials.essentials.util.Resource
import com.hogentessentials.essentials.util.performGetOperation
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class ChangeGroupRepository(
    val remoteDataSource: ChangeGroupRemoteDataSource,
    val localDataSource: ChangeGroupLocalDataSource
) {

    suspend fun getChangeGroupsForUser(): Resource<List<ChangeGroup>> =
        remoteDataSource.getChangeGroupsForUser()

    fun getChangeGroups() = performGetOperation(
        databaseQuery = { localDataSource.getChangeGroups() },
        networkCall = { remoteDataSource.getChangeGroupsForUser() },
        saveCallResult = { localDataSource.saveChangeGroups(it) }
    )
}
