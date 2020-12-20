package com.hogentessentials1.essentials.data.network.local

import com.hogentessentials1.essentials.DAOs.RoadMapDao
import com.hogentessentials1.essentials.data.model.RoadMapItem

/**
 * The local data source for road map items
 *
 * @author Marbod Naassens
 * @author Simon De Wilde
 *
 * @property roadMapDao
 */
class RoadMapLocalDataSource(private val roadMapDao: RoadMapDao) {
    /**
     * gets all road map items from the db
     *
     */
    fun getRoadMaps() = roadMapDao.getRoadMaps()

    /**
     * saves a list of road map items in the db
     *
     * @param list
     */
    suspend fun saveRoadMaps(list: List<RoadMapItem>) = roadMapDao.insertAll(list)
}
