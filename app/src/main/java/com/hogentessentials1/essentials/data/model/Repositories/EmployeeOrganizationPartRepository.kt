package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.DAOs.EmployeeOrganizationPartDao
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
