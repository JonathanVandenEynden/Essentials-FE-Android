package com.hogentessentials1.essentials.data.model.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.Employee

class EmployeeArrayConverter {
    @TypeConverter
    fun stringToEmployee(value: String): Array<Employee> {
        return Gson().fromJson(value, Array<Employee>::class.java)
    }

    @TypeConverter
    fun EmployeeToString(fields: Array<Employee>): String {
        return Gson().toJson(fields)
    }
}