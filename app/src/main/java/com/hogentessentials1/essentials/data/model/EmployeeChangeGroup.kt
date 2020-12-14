package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Simon De Wilde
 * joiningtable class between employees and changegroups
 */
@Parcelize
data class EmployeeChangeGroup(
    val employeeId: Int,
    val employee: Employee? = null,
    val changeGroupId: Int,
    val changeGroup: ChangeGroup? = null
) : Parcelable
