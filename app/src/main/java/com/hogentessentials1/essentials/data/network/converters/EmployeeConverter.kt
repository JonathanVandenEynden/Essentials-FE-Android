package com.hogentessentials1.essentials.data.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.Employee

/**
 *  Type converter for Employee to string and vice versa
 */
class EmployeeConverter {
    /**
     * Converts a string to an employee
     * @param value the json-string
     */
    @TypeConverter
    fun stringToEmployee(value: String): Employee {
        return Gson().fromJson(value, Employee::class.java)
    }

    /**
     * Converts an employee to a json-string
     * @param employee
     */
    @TypeConverter
    fun EmployeeToString(employee: Employee): String {
        return Gson().toJson(employee)
    }
}
