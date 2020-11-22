package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
 */

// @Entity(tableName = "employeeOrganizationPart")
@Parcelize
data class EmployeeOrganizationPart(
    @PrimaryKey val employeeId: Int,
    val employee: Employee,
    val organizationPartId: Int,
    val organizationParts: OrganizationPart,
    val type: OrganizationPartType
) : Parcelable
