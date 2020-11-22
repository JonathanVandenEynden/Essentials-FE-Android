package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman: start of Dataclass
 *
 */

// @Entity(tableName = "changeGroup")
@Parcelize
data class ChangeGroup(
    @PrimaryKey @ColumnInfo(name = "change_group_id") val id: Int,
    val name: String,
    val users: ArrayList<Employee>
) : Parcelable {
    // TODO
}
