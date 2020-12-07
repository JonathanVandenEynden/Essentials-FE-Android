package com.hogentessentials.essentials.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hogentessentials.essentials.data.model.ChangeGroup
import com.hogentessentials.essentials.data.model.ChangeInitiative

/**
 * @author Kilian Hoefman
 */
data class ChangeInitiativeWithChangeGroup(
    @Embedded val changeInitiative: ChangeInitiative,
    @Relation(
        parentColumn = "id",
        entityColumn = "change_group_id"
    )
    val changeGroup: ChangeGroup
)
