package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * A question in a survey
 *
 * @author Kilian Hoefman
 *
 * @property id
 * @property possibleAnswers a dictionary with a possible answer as key and the amount chosen as value
 * @property questionString
 * @property type the type of question --> Yes/No, Open, Ranged, Multiple Chose
 * @property questionRegistered a dictionary with employees as key and the time they answered the question as value
 */

@Entity(tableName = "questions")
@Parcelize
data class Question(
    @Json(name = "id")
    val id: String,
    @Json(name = "possibleAnswers")
    val possibleAnswers: Map<String, Int>,
    @Json(name = "questionString")
    val questionString: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "questionRegistered")
    val questionRegistered: Map<String, String>?
) : Parcelable
