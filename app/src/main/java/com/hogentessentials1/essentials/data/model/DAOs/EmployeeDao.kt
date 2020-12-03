package com.hogentessentials1.essentials.data.model.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.Employee

/**
 * @author Kilian Hoefman
 */

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM employee ORDER BY employee_id")
    fun getEmployees(): LiveData<List<Employee>>

    @Query("SELECT * FROM employee WHERE employee_id = :employeeId")
    fun getEmployee(employeeId: Int): LiveData<Employee>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(employees: List<Employee>)
}
