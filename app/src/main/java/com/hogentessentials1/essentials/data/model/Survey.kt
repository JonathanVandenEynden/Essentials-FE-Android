package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * a survey of a road map item
 *
 * @author Ziggy Moens: Start data class & made Parcelable
 * @author Simon De Wilde : replaced parcalable implementation with annotation
 *
 * @property id
 * @property questions a list of questions
 * @property feedback one last question (default)
 * @property roadMapItemId
 * @property roadMapItem
 */

@Parcelize
data class Survey(
    @Json(name = "id")
    val id: Int,
    @Json(name = "questions")
    val questions: List<Question>,
    @Json(name = "feedback")
    val feedback: Question,
    @Json(name = "roadMapItemId")
    val roadMapItemId: Int,
    @Json(name = "roadMapItem")
    val roadMapItem: RoadMapItem?
) : Parcelable
