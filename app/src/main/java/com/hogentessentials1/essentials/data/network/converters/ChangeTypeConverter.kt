package com.hogentessentials1.essentials.data.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.ChangeType

/**
 *  Type converter for ChangeType to string and vice versa
 */
class ChangeTypeConverter {
    /**
     * Converts a string to a ChangeType
     * @param value the json-string
     */
    @TypeConverter
    fun stringToChangeType(value: String): ChangeType {
        return Gson().fromJson(value, ChangeType::class.java)
    }

    /**
     * Converts a ChangeType to a json-string
     * @param changeType
     */
    @TypeConverter
    fun changeTypeToString(changeType: ChangeType): String {
        return Gson().toJson(changeType)
    }
}
