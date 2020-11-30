package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
 */

// @Entity(tableName = "questions")
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
    val questionRegistered: Map<String, Int>?
) : Parcelable
