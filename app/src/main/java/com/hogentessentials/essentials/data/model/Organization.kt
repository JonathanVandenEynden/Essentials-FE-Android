package com.hogentessentials.essentials.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

// @Entity(tableName = "organization")
@Parcelize
data class Organization(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "employees")
    val employees: Array<Employee>?,
    @Json(name = "changeManagers")
    val changeManagers: Array<ChangeManager>,
    // No organizationParts needed in android application
    @Json(name = "portfolio")
    val portfolio: Portfolio?
) : Parcelable
