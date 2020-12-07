package com.hogentessentials.essentials.data.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials.essentials.data.model.Employee

class EmployeeConverter {
    @TypeConverter
    fun stringToEmployee(value: String): Employee {
        return Gson().fromJson(value, Employee::class.java)
    }

    @TypeConverter
    fun EmployeeToString(fields: Employee): String {
        return Gson().toJson(fields)
    }
}
