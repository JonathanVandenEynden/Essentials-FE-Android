package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.data.network.RoadMapRemoteDataSource
import com.hogentessentials1.essentials.data.network.local.RoadMapLocalDataSource
import com.hogentessentials1.essentials.util.Resource
import com.hogentessentials1.essentials.util.performGetOperation
import javax.inject.Singleton

/**
 * Repository for road map items
 * @author Kilian Hoefman
 * @author Simon De Wilde
 * @author Marbod Naassens
 *
 * @property remoteDataSource
 * @property localDataSource
 */

@Singleton
class RoadMapRepository(val remoteDataSource: RoadMapRemoteDataSource, val localDataSource: RoadMapLocalDataSource) {

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
     * @param id
     * @return Resource with list of road map items
     */
    fun getRoadMaps(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getRoadMaps() },
        networkCall = { remoteDataSource.getRoadMapItemsForChangeInitatitveWithId(id) },
        saveCallResult = { localDataSource.saveRoadMaps(it) }
    )
}
