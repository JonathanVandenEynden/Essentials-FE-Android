package com.hogentessentials1.essentials.data.model.network.local

import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.DAOs.EmployeeDao
import com.hogentessentials1.essentials.data.model.Employee


class EmployeeLocalDataSource(val employeeDao : EmployeeDao) {
    fun getEmployees() = employeeDao.getEmployees()

    fun saveEmployees(list: List<Employee>) = employeeDao.insertAll(list)
}