package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.DAOs.EmployeeDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class EmployeeRepository @Inject constructor(private val employeeDao: EmployeeDao){

    fun getEmployees() = employeeDao.getEmployees()

    fun getEmployee(employeeId: Int) = employeeDao.getEmployee(employeeId)

}