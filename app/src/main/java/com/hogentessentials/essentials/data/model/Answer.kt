package com.hogentessentials.essentials.data.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
 */

// @Entity(tableName = "answer")
@Parcelize
data class Answer(
    @PrimaryKey val id: Int,
    val answerString: String,
    val amountChosen: Int
) : Parcelable
