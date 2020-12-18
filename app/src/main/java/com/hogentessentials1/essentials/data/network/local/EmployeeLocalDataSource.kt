package com.hogentessentials1.essentials.data.network.local

import com.hogentessentials1.essentials.DAOs.EmployeeDao
import com.hogentessentials1.essentials.data.model.Employee

/**
 * The local data source for employees
 *
 * @property employeeDao
 */
class EmployeeLocalDataSource(val employeeDao: EmployeeDao) {
    /**
     * gets all employees from the db
     *
     */
    fun getEmployees() = employeeDao.getEmployees()

    /**
     * saves a list of employees in the db
     *
     * @param list
     */
    suspend fun saveEmployees(list: List<Employee>) = employeeDao.insertAll(list)
}
