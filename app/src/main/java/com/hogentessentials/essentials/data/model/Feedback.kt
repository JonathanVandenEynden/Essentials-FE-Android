package com.hogentessentials.essentials.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Kilian Hoefman
 */

@Entity(tableName = "feedback")
data class Feedback(
    @PrimaryKey val id: Int,
    val questionString: String,
    val possibleAnswers: ArrayList<Answer>,
    val maxAmount: Int
)
