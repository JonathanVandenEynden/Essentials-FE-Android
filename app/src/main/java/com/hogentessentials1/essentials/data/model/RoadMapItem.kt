package com.hogentessentials1.essentials.data.model

import androidx.room.Entity
import java.util.*

/**
 * @author Kilian Hoefman
 */

@Entity(tableName = "roadMapItem")
data class RoadMapItem(
    val id: Int,
    val title: String,
    val assessment: Assessment,
    val done: Boolean,
    val startDate: Date,
    val endDate: Date
) {
    // TODO
}
