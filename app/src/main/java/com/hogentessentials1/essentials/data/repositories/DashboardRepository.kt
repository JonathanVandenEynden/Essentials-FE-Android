package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.network.DashboardRemoteDataSource
import com.hogentessentials1.essentials.util.Resource

/**
 *  // TODO author
 *  Repository for dashboard
 */
class DashboardRepository(val remoteDataSource: DashboardRemoteDataSource) {

    /**
     * TODO documentatie
     */
    suspend fun getFilledInSurveys(changeInitiativeId: Int): Resource<Double> {
        return remoteDataSource.getFilledInSurveys(changeInitiativeId)
    }

    /**
     * TODO documentatie
     */
    suspend fun getMood(changeInitiativeId: Int): Resource<Map<Int, Int>> {
        return remoteDataSource.getMood(changeInitiativeId)
    }
}
