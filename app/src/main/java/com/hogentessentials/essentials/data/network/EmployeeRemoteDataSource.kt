package com.hogentessentials.essentials.data.network

class EmployeeRemoteDataSource(val employeeApiService: EmployeeEndpointInterface) : BaseDataSource() {

    suspend fun getEmployee(employeeId: Int) = getResult { employeeApiService.getEmployee(employeeId) }

    suspend fun getAllEmployeesFromOrganization(organizationId: Int) = getResult { employeeApiService.getAllEmployeesFromOrganization(organizationId) }

    suspend fun getEmployeeByEmail(email: String) = getResult { employeeApiService.getEmployeeByEmail(email) }
}
