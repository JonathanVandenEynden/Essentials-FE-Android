package com.hogentessentials.essentials.data.repositories

import com.hogentessentials.essentials.data.network.DashboardRemoteDataSource
import com.hogentessentials.essentials.util.Resource

class DashboardRepository(val remoteDataSource: DashboardRemoteDataSource) {

    suspend fun getFilledInSurveys(changeInitiativeId: Int): Resource<Double> {
        return remoteDataSource.getFilledInSurveys(changeInitiativeId)
    }

    suspend fun getMood(changeInitiativeId: Int): Resource<Map<Int, Int>> {
        return remoteDataSource.getMood(changeInitiativeId)
    }
}
