package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.data.network.ChangeGroupRemoteDataSource
import com.hogentessentials1.essentials.data.network.local.ChangeGroupLocalDataSource
import com.hogentessentials1.essentials.util.Resource
import com.hogentessentials1.essentials.util.performGetOperation
import javax.inject.Singleton

/**
 * Repository for change groups
 * @author Kilian Hoefman
 * @author Simon De Wilde
 *
 * @property remoteDataSource
 * @property localDataSource
 */

@Singleton
class ChangeGroupRepository(
    val remoteDataSource: ChangeGroupRemoteDataSource,
    private val localDataSource: ChangeGroupLocalDataSource
) {

    /**
     * get all change groups for the logged in user
     * @return resource with list of answers
     */
    suspend fun getChangeGroupsForUser(): Resource<List<ChangeGroup>> =
        remoteDataSource.getChangeGroupsForUser()

    /**
     * get all change groups for the logged in user, caching the apicall in the process
     * @return LiveData with a resource
     */
    fun getChangeGroups() = performGetOperation(
        databaseQuery = { localDataSource.getChangeGroups() },
        networkCall = { remoteDataSource.getChangeGroupsForUser() },
        saveCallResult = { localDataSource.saveChangeGroups(it) }
    )
}
