package com.hogentessentials1.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.ChangeGroup

/**
 * @author Kilian Hoefman
 *
 * Dao for the ChangeGroup-entity
 */

@Dao
interface ChangeGroupDao {
    /**
     * @return list of all changeGroup ordered by Id
     */
    @Query("SELECT * FROM changeGroup ORDER BY change_group_id")
    fun getChangeGroups(): LiveData<List<ChangeGroup>>

    /**
     * @return changeGroup with specific id
     * @param changeGroupId
     */
    @Query("SELECT * FROM changeGroup WHERE change_group_id = :changeGroupId")
    fun getChangeGroup(changeGroupId: Int): LiveData<ChangeGroup>

    /**
     * inserts a list of changegroups to the database
     * @param changeGroups: list of changeGroup
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(changeGroups: List<ChangeGroup>)
}
