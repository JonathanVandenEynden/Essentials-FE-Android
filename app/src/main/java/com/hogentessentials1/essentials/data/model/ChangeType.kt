package com.hogentessentials1.essentials.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * @author Kilian Hoefman
 */

@Entity(tableName = "changeType")
data class ChangeType(
    @PrimaryKey val id: Int
) {

}
