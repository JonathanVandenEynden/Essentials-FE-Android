package com.hogentessentials1.essentials.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Kilian Hoefman
 */

@Entity(tableName = "questions")
data class Question(
    @PrimaryKey val id: Int,
    val questionString: String
) {
}
