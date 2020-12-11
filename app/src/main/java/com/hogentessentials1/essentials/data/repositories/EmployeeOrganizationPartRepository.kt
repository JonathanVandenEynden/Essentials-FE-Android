package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.DAOs.EmployeeOrganizationPartDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 *
 * Repository for answers
 */

@Singleton
class EmployeeOrganizationPartRepository
@Inject constructor(private val employeeOrganizationPartDao: EmployeeOrganizationPartDao) {

    /**
     * get all employee organization parts
     * @return liveData with list of employee organization parts
     */
    fun getEmployeeOrganizationParts() = employeeOrganizationPartDao.getEmployeeOrganizationParts()

    /**
     * get employee organization parts by employeeId
     * @param employeeId
     * @return LiveData with employee organization part
     */
    fun getEmployeeOrganizationPart(employeeId: Int, organizationPartId: Int) =
        employeeOrganizationPartDao.getEmployeeOrganizationPart(employeeId, organizationPartId)
}
