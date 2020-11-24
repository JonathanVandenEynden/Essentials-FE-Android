package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
 */

// @Entity(tableName = "assessment")
@Parcelize
data class Assessment(
    @Json(name = "id")
    val id: String, // TODO Primary key toevoegen
    @Json(name = "questions")
    val questions: List<Question>,
    @Json(name = "feedback")
    val feedback: Question?,
    @Json(name = "roadMapItemId")
    val roadMapItemId: String
) : Parcelable
