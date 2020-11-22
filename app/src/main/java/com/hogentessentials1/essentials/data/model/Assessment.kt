package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
 */

// @Entity(tableName = "assessment")
@Parcelize
data class Assessment(
    val id: Int, // TODO Primary key toevoegen
    val questions: ArrayList<Question>,
    val feedback: Question,
    val amountSubmitted: Int
) : Parcelable
