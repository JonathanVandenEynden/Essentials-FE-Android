package com.hogentessentials1.essentials.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * @author Kilian Hoefman: start of Dataclass
 *
 */

@Entity(tableName = "changeGroup")
data class ChangeGroup(
    @PrimaryKey @ColumnInfo(name="change_group_id") val id: Int,
    val name: String,
    val users: ArrayList<Employee>
) {
 //TODO
}
