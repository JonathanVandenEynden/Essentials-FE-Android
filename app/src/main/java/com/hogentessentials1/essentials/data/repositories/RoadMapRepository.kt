package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.data.network.RoadMapRemoteDataSource
import com.hogentessentials1.essentials.util.Resource
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 *
 * Repository for road map items
 */

@Singleton
class RoadMapRepository(val remoteDataSource: RoadMapRemoteDataSource) {

    /**
     * get road map item by id
     * @param roadMapItemId
     * @return Resource with road map item
     */
    suspend fun getRoadMapItemById(roadMapItemId: Int): Resource<RoadMapItem> {
        return remoteDataSource.getRoadMapItemById(roadMapItemId)
    }

    /**
     * get all road map items for a change initiative
     * @param changeInitiativeId
     * @return Resource with list of road map items
     */
    suspend fun getRoadMaps(changeInitiativeId: Int): Resource<List<RoadMapItem>> {
        return remoteDataSource.getRoadMapItemsForChangeInitatitveWithId(changeInitiativeId)
    }
}
