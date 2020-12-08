package com.hogentessentials1.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.ChangeGroup

/**
 * @author Kilian Hoefman
 */

@Dao
interface ChangeGroupDao {
    @Query("SELECT * FROM changeGroup ORDER BY change_group_id")
    fun getChangeGroups(): LiveData<List<ChangeGroup>>

    @Query("SELECT * FROM changeGroup WHERE change_group_id = :changeGroupId")
    fun getChangeGroup(changeGroupId: Int): LiveData<ChangeGroup>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(changeGroups: List<ChangeGroup>)
}
