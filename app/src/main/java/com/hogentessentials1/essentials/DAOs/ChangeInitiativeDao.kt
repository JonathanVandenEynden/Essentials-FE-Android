package com.hogentessentials1.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.ChangeInitiative

/**
 * Dao for the changeInitiative-entity
 */
@Dao
interface ChangeInitiativeDao {
    /**
     * @return list of all changeInitiative ordered by Id
     */
    @Query("SELECT * FROM changeInitiative ORDER BY change_initiative_id")
    fun getChangeInitatives(): LiveData<List<ChangeInitiative>>

    /**
     * @return changeInitiative with specific id
     * @param changeInitiativeId
     */
    @Query("SELECT * FROM changeInitiative WHERE change_initiative_id = :changeInitiativeId")
    fun getChangeInitative(changeInitiativeId: Int): LiveData<ChangeInitiative>

    /**
     * inserts a list of changeInitiatives to the database
     * @param changeInitiatives: list of changeInitiative
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(changeInitiatives: List<ChangeInitiative>)

    @Query("DELETE FROM changeInitiative")
    suspend fun deleteAll()
}
