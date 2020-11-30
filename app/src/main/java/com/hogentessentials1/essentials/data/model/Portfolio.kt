package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
 */

// @Entity(tableName = "portfolio")
// @PrimaryKey @ColumnInfo(name = "portfolio_id")
@Parcelize
data class Portfolio(
    @Json(name = "id")
    val id: Int,
    @Json(name = "projects")
    val projects: List<Project>
) : Parcelable
