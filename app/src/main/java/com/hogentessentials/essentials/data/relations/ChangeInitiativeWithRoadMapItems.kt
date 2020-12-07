package com.hogentessentials.essentials.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hogentessentials.essentials.data.model.ChangeInitiative
import com.hogentessentials.essentials.data.model.RoadMapItem

/**
 * @author Kilian Hoefman
 */
data class ChangeInitiativeWithRoadMapItems(
    @Embedded val changeInitiative: ChangeInitiative,
    @Relation(
        parentColumn = "id",
        entityColumn = "roadmap_id"
    )
    val roadMapItems: List<RoadMapItem>
)
