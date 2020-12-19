package com.hogentessentials1.essentials.data.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.ChangeType

class ChangeTypeConverter {
    @TypeConverter
    fun stringToChangeType(value: String?): ChangeType? {
        return Gson().fromJson(value, ChangeType::class.java)
    }

    @TypeConverter
    fun changeTypeToString(fields: ChangeType?): String? {
        return Gson().toJson(fields)
    }
}
