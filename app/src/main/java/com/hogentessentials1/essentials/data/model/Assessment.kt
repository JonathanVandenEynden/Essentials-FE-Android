package com.hogentessentials1.essentials.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Kilian Hoefman
 */

@Entity(tableName = "assessment")
data class Assessment(
    @PrimaryKey val id: Int,
    val questions: ArrayList<Question>,
    val feedback: Question,
    val amountSubmitted: Int
)
