package com.hogentessentials.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials.essentials.data.model.ChangeType

/**
 * @author Kilian Hoefman
 */

@Dao
interface ChangeTypeDao {
    @Query("SELECT * FROM changeType ORDER BY changeType_id")
    fun getChangeTypes(): LiveData<List<ChangeType>>

    @Query("SELECT * FROM changeType WHERE changeType_id = :changeTypeId")
    fun getChangeType(changeTypeId: Int): LiveData<ChangeType>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(changeTypes: List<ChangeType>)
}
