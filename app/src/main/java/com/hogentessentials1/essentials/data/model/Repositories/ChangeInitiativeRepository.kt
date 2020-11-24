package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.network.ChangeInitiativeRemoteDataSource
import com.hogentessentials1.essentials.data.model.network.RoadMapRemoteDataSource
import com.hogentessentials1.essentials.data.model.util.Resource
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class ChangeInitiativeRepository(val remoteDataSource: ChangeInitiativeRemoteDataSource) {

    suspend fun getChangeInitiativeById(changeInitiativeId: Int) : Resource<ChangeInitiative>{
      return remoteDataSource.getChangeInitiativeById(changeInitiativeId)
    }

    suspend fun getChangeInitiativesForEmployee(employeeId: Int): Resource<List<ChangeInitiative>>{
        return remoteDataSource.getChangeInitiativesForEmployee(employeeId)
    }

    suspend fun getChangeInitiativesForChangeManager(changeManagerId: Int) : Resource<List<ChangeInitiative>>{
        return remoteDataSource.getChangeInitiativesForChangeManager(changeManagerId)
    }
}
