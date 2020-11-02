package com.hogentessentials1.essentials.data.model

/**
 * @author Kilian Hoefman: start of dataclass
 */

data class Employee(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val employeeOrganizationParts: ArrayList<EmployeeOrganizationPart>,
    val type: Int
) {
    //TODO
}
