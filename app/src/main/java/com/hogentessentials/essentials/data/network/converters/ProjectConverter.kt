package com.hogentessentials.essentials.data.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials.essentials.data.model.Project

class ProjectConverter {
    @TypeConverter
    fun stringToProject(value: String): Project {
        return Gson().fromJson(value, Project::class.java)
    }

    @TypeConverter
    fun projectToString(fields: Project): String {
        return Gson().toJson(fields)
    }
}
