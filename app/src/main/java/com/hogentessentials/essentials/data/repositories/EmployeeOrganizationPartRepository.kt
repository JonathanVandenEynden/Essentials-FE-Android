package com.hogentessentials.essentials.data.repositories

import com.hogentessentials.essentials.DAOs.EmployeeOrganizationPartDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class EmployeeOrganizationPartRepository
@Inject constructor(private val employeeOrganizationPartDao: EmployeeOrganizationPartDao) {

    fun getEmployeeOrganizationParts() = employeeOrganizationPartDao.getEmployeeOrganizationParts()

    fun getEmployeeOrganizationPart(employeeId: Int, organizationPartId: Int) =
        employeeOrganizationPartDao.getEmployeeOrganizationPart(employeeId, organizationPartId)
}
