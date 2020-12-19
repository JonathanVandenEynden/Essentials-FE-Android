package com.hogentessentials1.essentials.data.model.network.local

import com.hogentessentials1.essentials.DAOs.RoadMapDao
import com.hogentessentials1.essentials.data.model.RoadMapItem

class RoadMapLocalDataSource(val roadMapDao: RoadMapDao) {
    fun getRoadMaps() = roadMapDao.getRoadMaps()

    suspend fun saveRoadMaps(list: List<RoadMapItem>) = roadMapDao.insertAll(list)
}
