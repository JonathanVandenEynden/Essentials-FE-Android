package com.hogentessentials1.essentials.data.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.ChangeGroup

/**
 *  Type converter for ChangeGroup to string and vice versa
 */
class ChangeGroupConverter {
    /**
     * Converts a string to a ChangeGroup
     * @param value the json-string
     */
    @TypeConverter
    fun stringToChangeGroup(value: String): ChangeGroup {
        return Gson().fromJson(value, ChangeGroup::class.java)
    }

    /**
     * Converts a ChangeGroup to a json-string
     * @param changeGroup
     */
    @TypeConverter
    fun changeGroupToString(changeGroup: ChangeGroup): String {
        return Gson().toJson(changeGroup)
    }
}
