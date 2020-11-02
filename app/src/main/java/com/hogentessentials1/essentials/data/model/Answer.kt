package com.hogentessentials1.essentials.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Kilian Hoefman
 */

@Entity(tableName = "answer")
data class Answer(
    @PrimaryKey val id: Int,
    val answerString: String,
    val amountChosen: Int
) {

}
