package com.hogentessentials1.essentials.data.model

/**
 * @author Kilian Hoefman
 */

data class Assessment(
    val id: Int,
    val questions: ArrayList<Question>,
    val feedback: Feedback,
    val amountSubmitted: Int
) {

}
