package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
 */

//@Entity(tableName = "changeType")
@Parcelize
data class ChangeType(
    @PrimaryKey @ColumnInfo(name = "changeType_id") val id: Int
) : Parcelable
