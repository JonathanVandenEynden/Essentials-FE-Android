package com.hogentessentials1.essentials.data.model.network.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.hogentessentials1.essentials.data.model.Assessment

class AssessmentConverter {
    @TypeConverter
    fun stringToAssessment(value: String): Assessment {
        return Gson().fromJson(value, Assessment::class.java)
    }

    @TypeConverter
    fun assessmentToString(fields: Assessment): String {
        return Gson().toJson(fields)
    }
}
