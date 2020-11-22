package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * @author Kilian Hoefman
 */

// @Entity(tableName = "roadMapItem")
@Parcelize
data class RoadMapItem(
    val id: Int,
    val title: String,
    val assessment: Assessment,
    val done: Boolean,
    val startDate: Date,
    val endDate: Date
) : Parcelable {
    // TODO
}
