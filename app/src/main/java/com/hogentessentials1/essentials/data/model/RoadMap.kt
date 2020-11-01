package com.hogentessentials1.essentials.data.model

import java.util.*

/**
 * @author Kilian Hoefman
 */

data class RoadMap(
    val id: Int,
    val title: String,
    val assessment: Assessment,
    val feedback: Feedback,
    val done: Boolean,
    val startDate: Date,
    val endDate: Date
) {
    //TODO

}
