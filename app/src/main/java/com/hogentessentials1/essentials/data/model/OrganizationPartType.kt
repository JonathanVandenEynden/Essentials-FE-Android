package com.hogentessentials1.essentials.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * enum for different types of organization parts
 *
 * @author Kilian Hoefman
 *
 * @property enum
 */

@Parcelize
data class OrganizationPartType(val enum: InnerEnum) : Parcelable {
    enum class InnerEnum {
        COUNTRY, DEPARTMENT, FACTORY, OFFICE, TEAM
    }
}
