package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * An organization in the application
 *
 * @property id
 * @property name
 * @property employees
 * @property changeManagers
 * @property portfolio
 */
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
