package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman: start of Dataclass
 *
 */

@Entity(tableName = "changeGroup")
@Parcelize
data class ChangeGroup(
    @PrimaryKey @ColumnInfo(name = "change_group_id")
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "users")
    val users: Array<Employee>?
) : Parcelable {
    // TODO
}
