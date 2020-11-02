package com.hogentessentials1.essentials.data.model.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.RoadMap

/**
 * @author Kilian Hoefman
 */

@Dao
interface RoadMapDao {
    @Query("SELECT * FROM roadMap ORDER BY id")
    fun getRoadMaps(): LiveData<List<RoadMap>>

    @Query("SELECT * from roadMap WHERE id = :roadMapId")
    fun getRoadMap(roadMapId: Int): LiveData<RoadMap>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(roadMaps: List<RoadMap>)
}