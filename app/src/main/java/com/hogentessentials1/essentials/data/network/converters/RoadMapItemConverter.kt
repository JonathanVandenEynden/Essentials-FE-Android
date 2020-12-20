package com.hogentessentials1.essentials.data.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.RoadMapItem

/**
 *  Type converter for RoadMapItem to string and vice versa
 *
 *  @author Simon De Wilde
 */
class RoadMapItemConverter {
    /**
     * Converts a string to a Road map item
     * @param value the json-string
     */
    @TypeConverter
    fun stringToRoadmapItem(value: String): Array<RoadMapItem> {
        return Gson().fromJson(value, Array<RoadMapItem>::class.java)
    }

    /**
     * Converts a road map item to a json-string
     * @param rmi
     */
    @TypeConverter
    fun roadMapItemToString(rmi: Array<RoadMapItem>): String {
        return Gson().toJson(rmi)
    }
}
