package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
 */

// @Entity(tableName = "organizationPart")
// @ColumnInfo(name = "organization_id")
@Parcelize
data class OrganizationPart(
    @Json(name = "name")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "employeeOrganizationParts")
    val employeeOrganizationParts: String,
    @Json(name = "type")
    val type: String
) : Parcelable
