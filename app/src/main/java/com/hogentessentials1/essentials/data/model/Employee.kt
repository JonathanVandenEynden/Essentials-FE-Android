package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * An employee in an organization
 *
 * @author Kilian Hoefman: start of dataclass
 *
 * @property id
 * @property firstName
 * @property lastName
 * @property email
 * @property employeeChangeGroups the list of joining tables between employees and change groups
 */
@Entity(tableName = "employee")
@Parcelize
data class Employee(
    @PrimaryKey @ColumnInfo(name = "employee_id")
    @Json(name = "id")
    val id: Int,
    @Json(name = "firstName")
    val firstName: String,
    @Json(name = "lastName")
    val lastName: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "employeeChangeGroups")
    val employeeChangeGroups: Array<EmployeeChangeGroup>?
) : Parcelable
