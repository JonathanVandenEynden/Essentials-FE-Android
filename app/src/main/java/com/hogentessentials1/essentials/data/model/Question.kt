package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
 */

// @Entity(tableName = "questions")
@Parcelize
data class Question(
    @PrimaryKey val id: Int,
    val questionString: String
) : Parcelable
