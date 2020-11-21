package com.hogentessentials1.essentials.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman: start of dataclass
 */

//@Entity(tableName = "employee")
@Parcelize
data class Employee(
    @PrimaryKey @ColumnInfo(name = "employee_id") val id: Int,
    @ColumnInfo(name = "organization_id") val organizationId: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val employeeOrganizationParts: ArrayList<EmployeeOrganizationPart>
) : Parcelable {
    //TODO invullen met logische gegevens
}
