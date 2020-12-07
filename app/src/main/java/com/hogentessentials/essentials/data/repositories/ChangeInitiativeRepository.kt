package com.hogentessentials.essentials.data.repositories

import com.hogentessentials.essentials.data.model.ChangeInitiative
import com.hogentessentials.essentials.data.network.ChangeInitiativeRemoteDataSource
import com.hogentessentials.essentials.data.network.local.ChangeInitiativeLocalDataSource
import com.hogentessentials.essentials.util.Resource
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

    suspend fun getChangeInitiativesForEmployee(): Resource<List<ChangeInitiative>> {
        return remoteDataSource.getChangeInitiativesForEmployee()
    }

    suspend fun getChangeInitiativesForChangeManager(): Resource<List<ChangeInitiative>> {
        return remoteDataSource.getChangeInitiativesForChangeManager()
    }

//    fun getPharmacies() = performGetOperation(
//        databaseQuery = { localDataSource.getChangeInitiatives() },
//        networkCall = { remoteDataSource.getChangeInitiativesForEmployee() },
//        saveCallResult = { localDataSource.saveChangeInitiatives(it) }
//    )
}
