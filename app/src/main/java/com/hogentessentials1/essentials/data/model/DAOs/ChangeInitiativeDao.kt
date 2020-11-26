package com.hogentessentials1.essentials.data.model.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.ChangeInitiative

@Dao
interface ChangeInitiativeDao {
    @Query("SELECT * FROM changeInitiative ORDER BY id")
    fun getChangeInitatives(): LiveData<List<ChangeInitiative>>

    @Query("SELECT * FROM changeInitiative WHERE id = :changeInitiativeId")
    fun getChangeInitative(changeInitiativeId: Int): LiveData<ChangeInitiative>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(changeInitiatives: List<ChangeInitiative>)
}
