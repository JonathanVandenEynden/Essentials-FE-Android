package com.hogentessentials1.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.EmployeeOrganizationPart
import com.hogentessentials1.essentials.data.model.OrganizationPart

/**
 * @author Kilian Hoefman
 * Dao for the employeeOrganizationPart-entity
 */

@Dao
interface EmployeeOrganizationPartDao {
    /**
     * @return list of all employeeOrganizationPart ordered by Id
     */
    @Query("SELECT * FROM employeeOrganizationPart")
    fun getEmployeeOrganizationParts(): LiveData<List<EmployeeOrganizationPart>>

    /**
     * @return list of all employeeOrganizationPart ordered by Id
     */
    @Query("SELECT * FROM employeeOrganizationPart WHERE employeeId = :employeeId AND organizationPartId = :organizationPartId")
    fun getEmployeeOrganizationPart(employeeId: Int, organizationPartId: Int): LiveData<EmployeeOrganizationPart>

    /**
     * inserts a list of employeeOrganizationParts to the database
     * @param employeeOrganizationParts: list of employeeOrganizationPart
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(employeeOrganizationParts: List<OrganizationPart>)
}
