package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.model.Employee
import com.hogentessentials1.essentials.data.network.EmployeeRemoteDataSource
import com.hogentessentials1.essentials.util.Resource
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 *
 * Repository for employees
 */

@Singleton
class EmployeeRepository(val remoteDataSource: EmployeeRemoteDataSource) {

    /**
     * get employee by id
     * @param employeeId
     * @return resource with employee
     */
    suspend fun getEmployee(employeeId: Int): Resource<Employee> {
        return remoteDataSource.getEmployee(employeeId)
    }

    /**
     * get all employees by organizationId
     * @param organizationId
     * @return Resource with list of employees
     */
    suspend fun getAllEmployeesFromOrganization(organizationId: Int): Resource<List<Employee>> {
        return remoteDataSource.getAllEmployeesFromOrganization(organizationId)
    }

    /**
     * get employee by email
     * @return resource with employee
     * @param email
     */
    suspend fun getEmployeeByEmail(email: String): Resource<Employee> {
        return remoteDataSource.getEmployeeByEmail(email)
    }
}
