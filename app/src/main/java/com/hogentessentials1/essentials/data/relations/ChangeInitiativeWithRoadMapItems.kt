package com.hogentessentials1.essentials.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.RoadMapItem

/**
 * POJO class for relationship between changeinitiative and roadmapitem (1-to-many)
 * @author Kilian Hoefman
 */
data class ChangeInitiativeWithRoadMapItems(
    @Embedded val changeInitiative: ChangeInitiative,
    @Relation(
        parentColumn = "id",
        entityColumn = "changeInitiative_id"
    )
    val roadMapItems: List<RoadMapItem>
)
