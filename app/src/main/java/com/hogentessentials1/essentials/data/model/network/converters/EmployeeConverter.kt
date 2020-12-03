package com.hogentessentials1.essentials.data.model.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.Employee

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