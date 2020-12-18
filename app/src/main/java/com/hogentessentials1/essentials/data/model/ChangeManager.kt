package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * The change manager of an organization who can start changes
 *
 * @property id
 * @property firstName
 * @property lastName
 * @property email
 * @property createdChangeInitiatives a list of changes this change manager has started
 */
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
//    @Json(name = "employeeOrganizationParts")
//    val employeeOrganizationParts: String?,
    @Json(name = "createdChangeInitiatives")
    val createdChangeInitiatives: List<ChangeInitiative>?
) : Parcelable
