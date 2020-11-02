package com.hogentessentials1.essentials.data.model

/**
 * @author Kilian Hoefman
 */

data class OrganizationPart(
    val id: Int,
    val name: String,
    val employeeOrganizationParts: ArrayList<EmployeeOrganizationPart>
) {

}
