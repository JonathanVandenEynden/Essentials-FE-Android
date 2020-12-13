package com.hogentessentials1.essentials.data.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.RoadMapItem

class RoadMapItemConverter {
    @TypeConverter
    fun stringToRoadmapItem(value: String): Array<RoadMapItem> {
        return Gson().fromJson(value, Array<RoadMapItem>::class.java)
    }

    @TypeConverter
    fun roadMapItemToString(fields: Array<RoadMapItem>): String {
        return Gson().toJson(fields)
    }
}
