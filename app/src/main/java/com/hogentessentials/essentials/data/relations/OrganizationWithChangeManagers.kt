package com.hogentessentials.essentials.data.model.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hogentessentials.essentials.data.model.ChangeManager
import com.hogentessentials.essentials.data.model.Organization

/**
 * @author Kilian Hoefman
 * @author Simon De Wilde
 */

data class OrganizationWithChangeManagers(
    @Embedded val organization: Organization,
    @Relation(
        parentColumn = "id",
        entityColumn = "organization_id"
    )
    val changeManagers: List<ChangeManager>
)
