package com.hogentessentials.essentials.data.repositories

import com.hogentessentials.essentials.data.model.RoadMapItem
import com.hogentessentials.essentials.data.network.RoadMapRemoteDataSource
import com.hogentessentials.essentials.util.Resource
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class RoadMapRepository(val remoteDataSource: RoadMapRemoteDataSource) {

    suspend fun getRoadMapItemById(id: Int): Resource<RoadMapItem> {
        return remoteDataSource.getRoadMapItemById(id)
    }

    suspend fun getRoadMaps(id: Int): Resource<List<RoadMapItem>> {
        return remoteDataSource.getRoadMapItemsForChangeInitatitveWithId(id)
    }
}
