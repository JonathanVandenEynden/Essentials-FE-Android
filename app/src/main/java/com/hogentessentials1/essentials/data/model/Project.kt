package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * A project where multiple changes are happening
 *
 * @author Kilian Hoefman
 *
 * @property Id
 * @property name
 * @property changeInitiatives a list of all changes of the project
 */
@Entity(tableName = "project")
@Parcelize
data class Project(
    @PrimaryKey @ColumnInfo(name = "project_id")
    @Json(name = "id")
    val Id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "changeInitiatives")
    val changeInitiatives: Array<ChangeInitiative>
) : Parcelable
