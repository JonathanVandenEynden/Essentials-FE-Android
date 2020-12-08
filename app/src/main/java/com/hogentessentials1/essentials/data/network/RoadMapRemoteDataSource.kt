package com.hogentessentials1.essentials.data.network

class RoadMapRemoteDataSource(val rmiApiService: RoadMapItemsEndpointInterface) : BaseDataSource() {

    suspend fun getRoadMapItemById(id: Int) = getResult { rmiApiService.getRoadMapItemById(id) }

    suspend fun getRoadMapItemsForChangeInitatitveWithId(id: Int) = getResult { rmiApiService.getRoadMapItemsForChangeInitatitveWithId(id) }
}
