package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
 */

//@Entity(tableName = "assessment")
@Parcelize
data class Assessment(
    val id: Int, //TODO Primary key toevoegen
    val questions: ArrayList<Question>,
    val feedback: Question,
    val amountSubmitted: Int
) : Parcelable
