package com.hogentessentials1.essentials.data.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.ChangeInitiative

class ChangeInitiativeConverter {
    @TypeConverter
    fun stringToChangeInitiative(value: String): Array<ChangeInitiative> {
        return Gson().fromJson(value, Array<ChangeInitiative>::class.java)
    }

    @TypeConverter
    fun changeInitiativeToString(fields: Array<ChangeInitiative>): String {
        return Gson().toJson(fields)
    }
}
