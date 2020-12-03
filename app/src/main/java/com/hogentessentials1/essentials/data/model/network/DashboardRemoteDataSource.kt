package com.hogentessentials1.essentials.data.model.network

class DashboardRemoteDataSource(val dashboardApiService: DashboardEndpointInterface) :
    BaseDataSource() {
    suspend fun getFilledInSurveys(changeInitiativeId: Int) =
        getResult { dashboardApiService.getFilledInSurveys(changeInitiativeId) }

    suspend fun getMood(changeInitiativeId: Int) =
        getResult { dashboardApiService.getMood(changeInitiativeId) }
}
