package com.hogentessentials1.essentials.data.model.network

class EssentialsRemoteDataSource(val rmiApiService: RoadMapItemsEndpointInterface) : BaseDataSource() {

    suspend fun getRoadMapItemById(id: Int) = getResult { rmiApiService.getRoadMapItemById(id) }

    suspend fun getRoadMapItemsForChangeInitatitveWithId(id: Int) = getResult { rmiApiService.getRoadMapItemsForChangeInitatitveWithId(id) }
}
