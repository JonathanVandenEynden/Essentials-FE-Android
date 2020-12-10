package com.hogentessentials1.essentials.data.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.ChangeGroup

class ChangeGroupConverter {
    @TypeConverter
    fun stringToChangeGroup(value: String): ChangeGroup {
        return Gson().fromJson(value, ChangeGroup::class.java)
    }

    @TypeConverter
    fun changeGroupToString(fields: ChangeGroup): String {
        return Gson().toJson(fields)
    }
}
