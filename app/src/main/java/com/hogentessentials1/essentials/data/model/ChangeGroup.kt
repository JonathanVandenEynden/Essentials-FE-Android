package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * @author Simon De Wilde
 *
 * Dataclass for a change group
 *
 */
@Parcelize
data class ChangeGroup(
    val id: Int,
    val name: String,
    val users: List<Employee> // TODO echte employees van maken
) : Parcelable

@Parcelize
data class Employee(val firstName: String, val lastName: String) : Parcelable
