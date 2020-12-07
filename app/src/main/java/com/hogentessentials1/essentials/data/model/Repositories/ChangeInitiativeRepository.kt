package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.network.ChangeInitiativeRemoteDataSource
import com.hogentessentials1.essentials.data.model.network.local.ChangeInitiativeLocalDataSource
import com.hogentessentials1.essentials.data.model.util.Resource
import com.hogentessentials1.essentials.data.model.util.performGetOperation
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class ChangeInitiativeRepository(
    val remoteDataSource: ChangeInitiativeRemoteDataSource,
    val localDataSource: ChangeInitiativeLocalDataSource
) {

    suspend fun getChangeInitiativeById(changeInitiativeId: Int): Resource<ChangeInitiative> {
        return remoteDataSource.getChangeInitiativeById(changeInitiativeId)
    }

    suspend fun getChangeInitiatives(): Resource<List<ChangeInitiative>> {
        return remoteDataSource.getChangeInitiatives()
    }

    fun getPharmacies() = performGetOperation(
        databaseQuery = { localDataSource.getChangeInitiatives() },
        networkCall = { remoteDataSource.getChangeInitiatives() },
        saveCallResult = { localDataSource.saveChangeInitiatives(it) }
    )
}
