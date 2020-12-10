package com.hogentessentials1.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.RoadMapItem

/**
 * @author Kilian Hoefman
 */

@Dao
interface RoadMapDao {
    @Query("SELECT * FROM roadMapItem ORDER BY roadmap_item_id")
    fun getRoadMaps(): LiveData<List<RoadMapItem>>

    @Query("SELECT * FROM roadMapItem WHERE roadmap_item_id = :roadMapId")
    fun getRoadMap(roadMapId: Int): LiveData<RoadMapItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(roadMapItems: List<RoadMapItem>)

    @Query("DELETE FROM roadMapItem")
    suspend fun deleteAll()
}
