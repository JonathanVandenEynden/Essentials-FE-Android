package com.hogentessentials.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials.essentials.data.model.ChangeInitiative

@Dao
interface ChangeInitiativeDao {
    @Query("SELECT * FROM changeInitiative ORDER BY change_initiative_id")
    fun getChangeInitatives(): LiveData<List<ChangeInitiative>>

    @Query("SELECT * FROM changeInitiative WHERE change_initiative_id = :changeInitiativeId")
    fun getChangeInitative(changeInitiativeId: Int): LiveData<ChangeInitiative>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(changeInitiatives: List<ChangeInitiative>)
}
