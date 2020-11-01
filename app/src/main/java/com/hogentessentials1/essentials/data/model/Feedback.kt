package com.hogentessentials1.essentials.data.model

/**
 * @author Kilian Hoefman
 */

data class Feedback(
    val id: Int,
    val questionString: String,
    val possibleAnswers: ArrayList<Answer>,
    val maxAmount: Int
) {

}
