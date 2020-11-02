package com.hogentessentials1.essentials.data.model

/**
 * @author Kilian Hoefman
 */

data class EmployeeOrganizationPart(
    val employeeId: Int,
    val employee: Employee,
    val organizationPartId: Int,
    val organizationParts: OrganizationPart,
    val type: OrganizationPartType
) {

}
