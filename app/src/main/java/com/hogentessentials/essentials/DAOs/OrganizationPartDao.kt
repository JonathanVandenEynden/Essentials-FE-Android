package com.hogentessentials.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials.essentials.data.model.OrganizationPart

/**
 * @author Kilian Hoefman
 */

@Dao
interface OrganizationPartDao {
    @Query("SELECT * FROM organizationPart ORDER BY id")
    fun getOrganizationParts(): LiveData<List<OrganizationPart>>

    @Query("SELECT * FROM organizationPart WHERE id = :organizationPartId")
    fun getOrganizationPart(organizationPartId: Int): LiveData<OrganizationPart>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(organizationParts: List<OrganizationPart>)
}
