package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * joining table class between employees and change groups
 *
 * @author Simon De Wilde
 *
 * @property employeeId
 * @property employee
 * @property changeGroupId
 * @property changeGroup
 */
@Parcelize
data class EmployeeChangeGroup(
    val employeeId: Int,
    val employee: Employee? = null,
    val changeGroupId: Int,
    val changeGroup: ChangeGroup? = null
) : Parcelable
