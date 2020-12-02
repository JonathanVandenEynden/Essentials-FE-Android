package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * @author Kilian Hoefman
 */

// @Entity(tableName = "roadMapItem")
@Parcelize
data class RoadMapItem(
    @Json(name = "id")
    val id: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "assessment")
    val assessment: Assessment?,
    @Json(name = "done")
    val done: Boolean,
    @Json(name = "startDate")
    val startDate: String,
    @Json(name = "endDate")
    val endDate: String
// TODO Dates casten naar echte datums, formattering tussen JSON en android is verschillend
) : Parcelable {
    // TODO
}
