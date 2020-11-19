package com.hogentessentials1.essentials.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Kilian Hoefman: start of dataclass
 */

@Entity(tableName = "employee")

data class Employee(
    @PrimaryKey @ColumnInfo(name = "employee_id") val id: Int,
    @ColumnInfo(name = "organization_id") val organizationId: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val employeeOrganizationParts: ArrayList<EmployeeOrganizationPart>
) : Parcelable {
    // TODO
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        TODO("employeeOrganizationParts")
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeInt(organizationId)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Employee> {
        override fun createFromParcel(parcel: Parcel): Employee {
            return Employee(parcel)
        }

        override fun newArray(size: Int): Array<Employee?> {
            return arrayOfNulls(size)
        }
    }
}
