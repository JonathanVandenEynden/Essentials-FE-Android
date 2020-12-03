package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.*
import com.hogentessentials1.essentials.data.model.network.converters.ChangeInitiativeConverter
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
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
