package com.hogentessentials1.essentials.data.model.network


class EssentialsRemoteDataSource(val apiService: EssentialsApiService.RoadMapItemsEndpointInterface) : BaseDataSource() {

    suspend fun getRoadMapItem(id: Int) = getResult { apiService.getRoadMapItemById(id)}
}