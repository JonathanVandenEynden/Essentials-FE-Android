package com.hogentessentials1.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.Employee

/**
 * @author Kilian Hoefman
 * Dao for the employee-entity
 */

@Dao
interface EmployeeDao {
    /**
     * @return list of all employee ordered by Id
     */
    @Query("SELECT * FROM employee ORDER BY employee_id")
    fun getEmployees(): LiveData<List<Employee>>

    /**
     * @return list of all employee ordered by Id
     */
    @Query("SELECT * FROM employee WHERE employee_id = :employeeId")
    fun getEmployee(employeeId: Int): LiveData<Employee>

    /**
     * inserts a list of employees to the database
     * @param employees: list of employee
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(employees: List<Employee>)

    @Query("DELETE FROM employee")
    suspend fun deleteAll()
}
