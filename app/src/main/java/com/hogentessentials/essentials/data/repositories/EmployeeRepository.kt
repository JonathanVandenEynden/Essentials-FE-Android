package com.hogentessentials.essentials.data.repositories

import com.hogentessentials.essentials.data.model.Employee
import com.hogentessentials.essentials.data.network.EmployeeRemoteDataSource
import com.hogentessentials.essentials.util.Resource
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class EmployeeRepository(val remoteDataSource: EmployeeRemoteDataSource) {

    suspend fun getEmployee(employeeId: Int): Resource<Employee> {
        return remoteDataSource.getEmployee(employeeId)
    }

    suspend fun getAllEmployeesFromOrganization(organizationId: Int): Resource<List<Employee>> {
        return remoteDataSource.getAllEmployeesFromOrganization(organizationId)
    }

    suspend fun getEmployeeByEmail(email: String): Resource<Employee> {
        return remoteDataSource.getEmployeeByEmail(email)
    }
}
