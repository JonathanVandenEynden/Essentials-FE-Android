package com.hogentessentials1.essentials.data.model.network.local

import com.hogentessentials1.essentials.data.model.DAOs.RoadMapDao
import com.hogentessentials1.essentials.data.model.Employee
import com.hogentessentials1.essentials.data.model.RoadMapItem

class RoadMapLocalDataSource(val roadMapDao: RoadMapDao) {
    fun getRoadMaps() = roadMapDao.getRoadMaps()

    fun saveRoadMaps(list: List<RoadMapItem>) = roadMapDao.insertAll(list)
}