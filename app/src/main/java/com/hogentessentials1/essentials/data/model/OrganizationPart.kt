package com.hogentessentials1.essentials.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 * @author Kilian Hoefman
 */

@Entity(tableName = "organizationParts")
data class OrganizationPart(
    val id: Int,
    @ColumnInfo(name= "organization_id") val organizationId: Int,
    val name: String,
    val employeeOrganizationParts: ArrayList<EmployeeOrganizationPart>
) {

}
