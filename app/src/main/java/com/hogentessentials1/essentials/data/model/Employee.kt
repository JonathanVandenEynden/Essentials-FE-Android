package com.hogentessentials1.essentials.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Kilian Hoefman: start of dataclass
 */

@Entity(tableName = "employee")
data class Employee(
    @PrimaryKey @ColumnInfo(name = "employee_id") val id: Int,
    @ColumnInfo(name = "organization_id") val organizationId: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val employeeOrganizationParts: ArrayList<EmployeeOrganizationPart>,
    val type: Int
) {
    // TODO
}
