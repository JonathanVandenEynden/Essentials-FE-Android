package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

//@Entity
@Parcelize
data class ChangeManager(
    @Json(name = "id")
    val id: Int,
    @Json(name = "firstName")
    val firstName: String,
    @Json(name = "lastName")
    val lastName: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "employeeOrganizationParts")
    val employeeOrganizationParts: String?,
    @Json(name = "createdChangeInitiatives")
    val createdChangeInitiatives: List<ChangeInitiative>?
) : Parcelable
