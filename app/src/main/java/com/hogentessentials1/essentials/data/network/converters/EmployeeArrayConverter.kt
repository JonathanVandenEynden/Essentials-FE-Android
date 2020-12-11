package com.hogentessentials1.essentials.data.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.Employee

/**
 *  Type converter for Array of Employees to string and vice versa
 */
class EmployeeArrayConverter {
    /**
     * Converts a string to an array of employees
     * @param value the json-string
     */
    @TypeConverter
    fun stringToEmployee(value: String): Array<Employee> {
        return Gson().fromJson(value, Array<Employee>::class.java)
    }

    /**
     * Converts an array of employees to a json-string
     * @param list
     */
    @TypeConverter
    fun EmployeeToString(list: Array<Employee>): String {
        return Gson().toJson(list)
    }
}
