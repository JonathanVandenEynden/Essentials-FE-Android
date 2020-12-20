package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * a type of change --> economical, organizational, technological, personal
 *
 * @author Kilian Hoefman
 *
 * @property id
 */

@Entity(tableName = "changeType")
@Parcelize
data class ChangeType(
    @PrimaryKey @ColumnInfo(name = "changeType_id")
    @Json(name = "id")
    val id: Int
) : Parcelable
