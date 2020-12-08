package com.hogentessentials1.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.OrganizationPart

/**
 * @author Kilian Hoefman
 * Dao for the organizationPart-entity
 */

@Dao
interface OrganizationPartDao {
    /**
     * @return list of all organizationPart ordered by Id
     */
    @Query("SELECT * FROM organizationPart ORDER BY id")
    fun getOrganizationParts(): LiveData<List<OrganizationPart>>

    /**
     * @return list of all organizationPart ordered by Id
     */
    @Query("SELECT * FROM organizationPart WHERE id = :organizationPartId")
    fun getOrganizationPart(organizationPartId: Int): LiveData<OrganizationPart>

    /**
     * inserts a list of organizationParts to the database
     * @param organizationParts: list of organizationPart
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(organizationParts: List<OrganizationPart>)
}
