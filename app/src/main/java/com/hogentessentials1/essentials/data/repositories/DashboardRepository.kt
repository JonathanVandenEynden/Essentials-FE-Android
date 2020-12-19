package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.network.DashboardRemoteDataSource
import com.hogentessentials1.essentials.util.Resource
import javax.inject.Singleton

/**
 * Repository for dashboard
 * @author Marbod Naassens
 * @property remoteDataSource
 */
@Singleton
class DashboardRepository(val remoteDataSource: DashboardRemoteDataSource) {

    /**
     * gets all filled in surveys from a change initiative with a given id
     *
     * @param changeInitiativeId
     * @return a resource
     */
    suspend fun getFilledInSurveys(changeInitiativeId: Int): Resource<Double> {
        return remoteDataSource.getFilledInSurveys(changeInitiativeId)
    }

    /**
     * gets the mood for a change initiative with a given id
     *
     * @param changeInitiativeId
     * @return the mood in dictionary format
     */
    suspend fun getMood(changeInitiativeId: Int): Resource<Map<Int, Int>> {
        return remoteDataSource.getMood(changeInitiativeId)
    }
}
