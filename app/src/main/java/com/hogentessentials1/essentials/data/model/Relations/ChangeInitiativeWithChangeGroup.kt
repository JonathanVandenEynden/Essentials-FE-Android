package com.hogentessentials1.essentials.data.model.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.data.model.ChangeInitiative

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
