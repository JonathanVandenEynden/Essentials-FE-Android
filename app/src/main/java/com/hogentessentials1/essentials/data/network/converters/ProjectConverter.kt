package com.hogentessentials1.essentials.data.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.Project

/**
 *  Type converter for Project to string and vice versa
 *
 *  @author Simon De Wilde
 */
class ProjectConverter {
    /**
     * Converts a string to a Project
     * @param value the json-string
     */
    @TypeConverter
    fun stringToProject(value: String): Project {
        return Gson().fromJson(value, Project::class.java)
    }

    /**
     * Converts a project to a json-string
     * @param project
     */
    @TypeConverter
    fun projectToString(project: Project): String {
        return Gson().toJson(project)
    }
}
