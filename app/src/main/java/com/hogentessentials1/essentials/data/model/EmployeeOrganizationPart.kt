package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
 */

// @Entity(tableName = "employeeOrganizationPart")
@Parcelize
data class EmployeeOrganizationPart(
    @Json(name = "employeeId")
    val employeeId: Int,
    @Json(name = "employee")
    val employee: Employee,
    val organizationPartId: Int,
    val organizationParts: OrganizationPart,
    val type: String
) : Parcelable
