package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.network.ChangeInitiativeRemoteDataSource
import com.hogentessentials1.essentials.data.network.local.ChangeInitiativeLocalDataSource
import com.hogentessentials1.essentials.util.Resource
import com.hogentessentials1.essentials.util.performGetOperation
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 * @author Simon De Wilde
 *
 * Repository for change initiatives
 */
// TODO meer documentatie (moet nog mergen met develop)
@Singleton
class ChangeInitiativeRepository(
    val remoteDataSource: ChangeInitiativeRemoteDataSource,
    val localDataSource: ChangeInitiativeLocalDataSource
) {

    suspend fun getChangeInitiativeById(changeInitiativeId: Int): Resource<ChangeInitiative> {
        return remoteDataSource.getChangeInitiativeById(changeInitiativeId)
    }

//    suspend fun getChangeInitiativesForEmployee(): Resource<List<ChangeInitiative>> {
//        return remoteDataSource.getChangeInitiativesForEmployee()
//    }

//    suspend fun getChangeInitiativesForChangeManager(): Resource<List<ChangeInitiative>> {
//        return remoteDataSource.getChangeInitiativesForChangeManager()
//    }

    fun getChangeInitiativesForEmployee() = performGetOperation(
        databaseQuery = { localDataSource.getChangeInitiatives() },
        networkCall = { remoteDataSource.getChangeInitiativesForEmployee() },
        saveCallResult = { localDataSource.saveChangeInitiatives(it) }
    )

    fun getChangeInitiativesForChangeManager() = performGetOperation(
        databaseQuery = { localDataSource.getChangeInitiatives() },
        networkCall = { remoteDataSource.getChangeInitiativesForChangeManager() },
        saveCallResult = { localDataSource.saveChangeInitiatives(it) }
    )
}
