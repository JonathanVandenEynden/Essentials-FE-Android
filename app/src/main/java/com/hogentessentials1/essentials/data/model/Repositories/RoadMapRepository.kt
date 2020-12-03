package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.data.model.network.RoadMapRemoteDataSource
import com.hogentessentials1.essentials.data.model.network.local.RoadMapLocalDataSource
import com.hogentessentials1.essentials.data.model.util.Resource
import com.hogentessentials1.essentials.data.model.util.performGetOperation
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class RoadMapRepository(val remoteDataSource: RoadMapRemoteDataSource, val localDataSource: RoadMapLocalDataSource){

    suspend fun getRoadMapItemById(id: Int): Resource<RoadMapItem> {
        return remoteDataSource.getRoadMapItemById(id)
    }
    suspend fun getRoadMaps(id: Int): Resource<List<RoadMapItem>>{
        return remoteDataSource.getRoadMapItemsForChangeInitatitveWithId(id)
    }

    fun getRoadMapItems() = performGetOperation(
        databaseQuery = { localDataSource.getRoadMaps() },
        networkCall = { remoteDataSource.getRoadMapItemsForChangeInitatitveWithId(1) },
        saveCallResult = { localDataSource.saveRoadMaps(it) }
    )
}
