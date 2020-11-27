package com.hogentessentials1.essentials.data.model.network;

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

class DashboardRemoteDataSource(val dashboardApiService: DashboardEndpointInterface): BaseDataSource()  {
    suspend fun getFilledInSurveys(changeInitiativeId: Int) = getResult { dashboardApiService.getFilledInSurveys(changeInitiativeId) }
    suspend fun getMood(changeInitiativeId: Int) = getResult { dashboardApiService.getMood(changeInitiativeId) }
}
