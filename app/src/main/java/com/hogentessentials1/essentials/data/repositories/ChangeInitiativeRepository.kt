package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.network.ChangeInitiativeRemoteDataSource
import com.hogentessentials1.essentials.data.network.local.ChangeInitiativeLocalDataSource
import com.hogentessentials1.essentials.util.Resource
import com.hogentessentials1.essentials.util.performGetOperation
import javax.inject.Singleton

/**
 * TODORepository for change initiatives
 * @author Kilian Hoefman
 * @author Simon De Wilde
 *
 * @property remoteDataSource
 * @property localDataSource
 */
@Singleton
class ChangeInitiativeRepository(
    val remoteDataSource: ChangeInitiativeRemoteDataSource,
    val localDataSource: ChangeInitiativeLocalDataSource
) {
    /**
     * gets a change initiative with a given id from the db
     *
     * @param changeInitiativeId
     * @return a resource with a change initiative
     */
    suspend fun getChangeInitiativeById(changeInitiativeId: Int): Resource<ChangeInitiative> {
        return remoteDataSource.getChangeInitiativeById(changeInitiativeId)
    }

    /**
     * get all change initiatives for the logged in user, caching the api call in the process
     * @return LiveData with a resource
     */
    fun getChangeInitiativesForEmployee() = performGetOperation(
        databaseQuery = { localDataSource.getChangeInitiatives() },
        networkCall = { remoteDataSource.getChangeInitiativesForEmployee() },
        saveCallResult = { localDataSource.saveChangeInitiatives(it) }
    )

    /**
     * get all created change initiatives for the logged in user (change manager), caching the api call in the process
     * @return LiveData with a resource
     */
    fun getChangeInitiativesForChangeManager() = performGetOperation(
        databaseQuery = { localDataSource.getChangeInitiatives() },
        networkCall = { remoteDataSource.getChangeInitiativesForChangeManager() },
        saveCallResult = { localDataSource.saveChangeInitiatives(it) }
    )
}
