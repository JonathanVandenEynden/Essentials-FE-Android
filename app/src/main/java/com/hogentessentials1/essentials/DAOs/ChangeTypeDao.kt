package com.hogentessentials1.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.ChangeType

/**
 * Dao for the changeType-entity
 * @author Kilian Hoefman
 */

@Dao
interface ChangeTypeDao {
    /**
     * @return list of all changeType ordered by Id
     */
    @Query("SELECT * FROM changeType ORDER BY changeType_id")
    fun getChangeTypes(): LiveData<List<ChangeType>>

    /**
     * @return changeType with specific id
     * @param changeTypeId
     */
    @Query("SELECT * FROM changeType WHERE changeType_id = :changeTypeId")
    fun getChangeType(changeTypeId: Int): LiveData<ChangeType>

    /**
     * inserts a list of changeTypes to the database
     * @param changeTypes: list of changeType
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(changeTypes: List<ChangeType>)
}
