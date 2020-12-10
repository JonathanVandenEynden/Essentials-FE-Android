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
 */

@Dao
interface EmployeeOrganizationPartDao {
    @Query("SELECT * FROM employeeOrganizationPart")
    fun getEmployeeOrganizationParts(): LiveData<List<EmployeeOrganizationPart>>

    @Query("SELECT * FROM employeeOrganizationPart WHERE employeeId = :employeeId AND organizationPartId = :organizationPartId")
    fun getEmployeeOrganizationPart(employeeId: Int, organizationPartId: Int): LiveData<EmployeeOrganizationPart>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(employeeOrganizationParts: List<OrganizationPart>)
}
