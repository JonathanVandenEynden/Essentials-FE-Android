package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.ChangeManager
import com.hogentessentials1.essentials.data.model.network.DashboardRemoteDataSource
import com.hogentessentials1.essentials.data.model.util.Resource
import javax.inject.Inject

class DashboardRepository(val remoteDataSource: DashboardRemoteDataSource){

    suspend fun getFilledInSurveys(changeInitiativeId: Int) : Resource<Double> {
        return remoteDataSource.getFilledInSurveys(changeInitiativeId)
    }

    suspend fun getMood(changeInitiativeId: Int) : Resource<Map<Int, Int>> {
        return remoteDataSource.getMood(changeInitiativeId)
    }
}