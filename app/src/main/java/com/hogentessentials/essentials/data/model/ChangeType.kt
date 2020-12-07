package com.hogentessentials.essentials.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
 */

// @Entity(tableName = "changeType")
@Parcelize
data class ChangeType(
    @Json(name = "id")
    val id: Int
) : Parcelable
