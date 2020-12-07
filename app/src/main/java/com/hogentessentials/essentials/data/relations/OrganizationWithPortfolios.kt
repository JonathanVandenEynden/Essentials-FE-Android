package com.hogentessentials.essentials.data.model.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hogentessentials.essentials.data.model.Organization
import com.hogentessentials.essentials.data.model.Portfolio

/**
 * @author Kilian Hoefman
 */

data class OrganizationWithPortfolios(
    @Embedded val organization: Organization,
    @Relation(
        parentColumn = "portfolio_id",
        entityColumn = "organization_id"
    )
    val portfolios: List<Portfolio>
)
