package com.hogentessentials1.essentials.data.model.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hogentessentials1.essentials.data.model.Organization
import com.hogentessentials1.essentials.data.model.OrganizationPart

/**
 * @author Kilian Hoefman
 * @author Simon De Wilde
 */

data class OrganizationWithOrganizationParts(
    @Embedded val organization: Organization,
    @Relation(
        parentColumn = "id",
        entityColumn = "organization_id"
    )
    val organizationParts: List<OrganizationPart>
)
