package com.hogentessentials1.essentials.data.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.ChangeInitiative

/**
 *  Type converter for ChangeInitiative to string and vice versa
 */
class ChangeInitiativeConverter {
    /**
     * Converts a string to a ChangeInitiative
     * @param value the json-string
     */
    @TypeConverter
    fun stringToChangeInitiative(value: String): Array<ChangeInitiative> {
        return Gson().fromJson(value, Array<ChangeInitiative>::class.java)
    }

    /**
     * Converts a ChangeInitiative to a json-string
     * @param changeInitiative
     */
    @TypeConverter
    fun changeInitiativeToString(changeInitiative: Array<ChangeInitiative>): String {
        return Gson().toJson(changeInitiative)
    }
}
