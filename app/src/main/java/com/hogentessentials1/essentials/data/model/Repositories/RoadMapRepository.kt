package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.DAOs.RoadMapDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class RoadMapRepository @Inject constructor(private val roadMapDao: RoadMapDao){

    fun getRoadMaps() = roadMapDao.getRoadMaps()

    fun getRoadMap(roadMapId: Int) = roadMapDao.getRoadMap(roadMapId)
}