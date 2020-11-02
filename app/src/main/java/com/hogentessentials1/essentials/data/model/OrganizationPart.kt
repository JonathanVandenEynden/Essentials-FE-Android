package com.hogentessentials1.essentials.data.model

import androidx.room.Entity

/**
 * @author Kilian Hoefman
 */

@Entity(tableName = "organizationPart")
data class OrganizationPart(
    val id: Int,
    val name: String,
    val employeeOrganizationParts: ArrayList<EmployeeOrganizationPart>
) {

}
