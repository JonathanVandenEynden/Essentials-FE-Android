package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * joining table class between employees and organization parts
 *
 * @author Kilian Hoefman
 *
 * @property employeeId
 * @property employee
 * @property organizationPartId
 * @property organizationParts
 * @property type
 */

@Entity(tableName = "employeeOrganizationPart")
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
