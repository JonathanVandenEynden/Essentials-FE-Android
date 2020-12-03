package com.hogentessentials1.essentials.data.model.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.ChangeType
import com.hogentessentials1.essentials.data.model.Employee

class ChangeTypeConverter {
    @TypeConverter
    fun stringToChangeType(value: String): ChangeType {
        return Gson().fromJson(value, ChangeType::class.java)
    }

    @TypeConverter
    fun changeTypeToString(fields: ChangeType): String {
        return Gson().toJson(fields)
    }
}