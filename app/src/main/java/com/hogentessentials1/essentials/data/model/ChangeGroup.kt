package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * a change group for a change initiative
 *
 * @author Kilian Hoefman: start of Dataclass

 * @property id the id of the change group
 * @property name
 * @property employeeChangeGroups a list of joiningtables between change groups and employees
 */

@Entity(tableName = "changeGroup")
@Parcelize
data class ChangeGroup(
    @PrimaryKey @ColumnInfo(name = "change_group_id")
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "employeeChangeGroups")
    val employeeChangeGroups: Array<EmployeeChangeGroup>?
) : Parcelable
