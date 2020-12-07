package com.hogentessentials.essentials.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Kilian Hoefman
 */

@Parcelize
data class OrganizationPartType(val enum: InnerEnum) : Parcelable {
    enum class InnerEnum {
        COUNTRY, DEPARTMENT, FACTORY, OFFICE, TEAM
    }
}
