package com.hogentessentials1.essentials.data.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.EmployeeChangeGroup

/**
 *  Type converter for Array of EmployeesChangeGroups to string and vice versa
 *
 *  @author Simon De Wilde
 */
class EmployeeChangeGroupArrayConverter {
    /**
     * Converts a string to an array of employeeChangeGroups
     * @param value the json-string
     */
    @TypeConverter
    fun stringToEmployeeChangeGroup(value: String): Array<EmployeeChangeGroup>? {
        return Gson().fromJson(value, Array<EmployeeChangeGroup>::class.java)
    }

    /**
     * Converts an array of employeeChangeGroups to a json-string
     * @param list
     */
    @TypeConverter
    fun employeeChangeGroupToString(list: Array<EmployeeChangeGroup>?): String {
        return Gson().toJson(list)
    }
}
