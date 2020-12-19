package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * An item in the road map of a change
 *
 * @author Kilian Hoefman
 *
 * @property id
 * @property title
 * @property assessment each road map item can have one survey
 * @property done
 * @property startDate
 * @property endDate
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
) : Parcelable
