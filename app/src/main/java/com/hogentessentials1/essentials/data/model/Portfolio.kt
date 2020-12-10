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

@Entity(tableName = "portfolio")
@Parcelize
data class Portfolio(
    @PrimaryKey @ColumnInfo(name = "portfolio_id")
    @Json(name = "id")
    val id: Int,
    @Json(name = "projects")
    val projects: List<Project>
) : Parcelable
