package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * describes a change in an organization
 *
 * @author Ziggy Moens: made Parcelable
 * @author Kilian Hoefman: start of Dataclass
 * @author Marbod Naassens
 *
 * @property id
 * @property title
 * @property description what is the change about
 * @property startDate a date in string-format
 * @property endDate a date in string-format
 * @property progress the progress (percentage) in string
 * @property changeGroup which change group is affected by this change
 * @property changeSponsor who is the sponsor for this change
 * @property roadMap a list of road map items
 */

@Entity(tableName = "changeInitiative")
@Parcelize
data class ChangeInitiative(
    @PrimaryKey @ColumnInfo(name = "change_initiative_id")
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val title: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "startDate")
    val startDate: String,
    @Json(name = "endDate")
    val endDate: String,
    @Json(name = "changeGroup")
    val changeGroup: ChangeGroup?,
    @Json(name = "changeSponsor")
    val changeSponsor: Employee?,
    @Json(name = "roadMap")
    val roadMap: Array<RoadMapItem>,
    @Json(name = "progress")
    val progress: String

) : Parcelable
