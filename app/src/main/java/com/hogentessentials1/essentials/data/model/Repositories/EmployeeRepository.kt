package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.Employee
import com.hogentessentials1.essentials.data.model.network.EmployeeRemoteDataSource
import com.hogentessentials1.essentials.data.model.util.Resource
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
