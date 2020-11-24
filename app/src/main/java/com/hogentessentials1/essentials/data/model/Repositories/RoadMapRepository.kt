package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.data.model.network.EssentialsRemoteDataSource
import com.hogentessentials1.essentials.data.model.util.Resource
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class RoadMapRepository(val remoteDataSource: EssentialsRemoteDataSource){

    suspend fun getRoadMapItemById(id: Int): Resource<RoadMapItem> {
        return remoteDataSource.getRoadMapItemById(id)
    }
    suspend fun getRoadMaps(id: Int): Resource<List<RoadMapItem>>{
        return remoteDataSource.getRoadMapItemsForChangeInitatitveWithId(id)
    }
}
