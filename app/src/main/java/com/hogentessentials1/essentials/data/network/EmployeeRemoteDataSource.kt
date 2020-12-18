package com.hogentessentials1.essentials.data.network

/**
 * The remote data source for employees
 *
 * @property employeeApiService
 */
class EmployeeRemoteDataSource(val employeeApiService: EmployeeEndpointInterface) : BaseDataSource() {

    /**
     * gets an employee with a given id
     *
     * @param employeeId
     */
    suspend fun getEmployee(employeeId: Int) = getResult { employeeApiService.getEmployee(employeeId) }

    /**
     * gets all employees form an organization with a given id
     *
     * @param organizationId
     */
    suspend fun getAllEmployeesFromOrganization(organizationId: Int) = getResult { employeeApiService.getAllEmployeesFromOrganization(organizationId) }

    /**
     * gets an employee with a given email
     *
     * @param email
     */
    suspend fun getEmployeeByEmail(email: String) = getResult { employeeApiService.getEmployeeByEmail(email) }
}
