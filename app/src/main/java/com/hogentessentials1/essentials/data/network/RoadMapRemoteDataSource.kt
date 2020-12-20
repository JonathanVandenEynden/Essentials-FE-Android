package com.hogentessentials1.essentials.data.network

/**
 * The remote data source for road map items
 * @author Kilian Hoefman
 * @property rmiApiService
 */
class RoadMapRemoteDataSource(private val rmiApiService: RoadMapItemsEndpointInterface) : BaseDataSource() {

    /**
     * gets a road map item with a given id
     *
     * @param id
     */
    suspend fun getRoadMapItemById(id: Int) = getResult { rmiApiService.getRoadMapItemById(id) }

    /**
     * get the full road map of a change with a given id
     *
     * @param id
     */
    suspend fun getRoadMapItemsForChangeInitatitveWithId(id: Int) = getResult { rmiApiService.getRoadMapItemsForChangeInitatitveWithId(id) }
}
