package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
 */

//@Entity(tableName = "organizationPart")
@Parcelize
data class OrganizationPart(
    val id: Int,
    @ColumnInfo(name = "organization_id") val organizationId: Int,
    val name: String,
    val employeeOrganizationParts: ArrayList<EmployeeOrganizationPart>
) : Parcelable
