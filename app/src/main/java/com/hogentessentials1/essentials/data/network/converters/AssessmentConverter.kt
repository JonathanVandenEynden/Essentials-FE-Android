package com.hogentessentials1.essentials.data.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.Assessment

/**
 *  Type converter for Assessment to string and vice versa
 */
class AssessmentConverter {
    /**
     * Converts a string to an assessment
     * @param value the json-string
     */
    @TypeConverter
    fun stringToAssessment(value: String): Assessment {
        return Gson().fromJson(value, Assessment::class.java)
    }

    /**
     * Converts an assessment to a json-string
     * @param assessment
     */
    @TypeConverter
    fun assessmentToString(assessment: Assessment): String {
        return Gson().toJson(assessment)
    }
}
