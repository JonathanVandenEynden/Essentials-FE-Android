package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.data.model.network.EssentialsRemoteDataSource
import com.hogentessentials1.essentials.data.model.util.Resource

class TestRepository(val remoteDataSource: EssentialsRemoteDataSource){

    suspend fun getRMI(id: Int): Resource<RoadMapItem>{
        return remoteDataSource.getRoadMapItem(id)
    }
}