package com.hogentessentials1.essentials.data.model

/**
 * @author Kilian Hoefman
 */

data class OrganizationPartType(val enum: InnerEnum) {
    enum class InnerEnum {
        COUNTRY, DEPARTMENT, FACTORY, OFFICE, TEAM
    }
}
