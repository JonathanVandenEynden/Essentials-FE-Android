package com.hogentessentials1.essentials.data.model

/**
 * @author Kilian Hoefman: start of dataclass
 */

data class Employee(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    //TODO Tussentabel mappen
    val employeeOrganizationParts: String,
    val type: Int
) {
    //TODO
}
