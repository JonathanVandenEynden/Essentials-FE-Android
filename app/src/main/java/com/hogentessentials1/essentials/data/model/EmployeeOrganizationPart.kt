package com.hogentessentials1.essentials.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Kilian Hoefman
 */

@Entity(tableName = "employeeOrganizationPart")
data class EmployeeOrganizationPart(
    @PrimaryKey val employeeId: Int,
    val employee: Employee,
    val organizationPartId: Int,
    val organizationParts: OrganizationPart,
    val type: OrganizationPartType
) {

}
