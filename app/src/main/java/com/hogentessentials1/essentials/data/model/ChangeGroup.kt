package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman: start of Dataclass
 *
 */

// @Entity(tableName = "changeGroup")
// @PrimaryKey @ColumnInfo(name = "change_group_id")
@Parcelize
data class ChangeGroup(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "users")
    val users: List<Employee>?
) : Parcelable {
    // TODO
}
