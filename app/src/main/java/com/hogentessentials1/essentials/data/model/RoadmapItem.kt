package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
 */

@Entity(tableName = "roadMapItem")
@Parcelize
data class RoadMapItem(
    @PrimaryKey @ColumnInfo(name = "roadmap_item_id")
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
//TODO Dates casten naar echte datums, formattering tussen JSON en android is verschillend
) : Parcelable {
    // TODO
}
