package com.hogentessentials1.essentials.data.model.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.ChangeType

/**
 * @author Kilian Hoefman
 */
data class ChangeInitiativesWithChangeType(
    @Embedded val changeInitiative: ChangeInitiative,
    @Relation(
        parentColumn = "id",
        entityColumn = "changeType_id"
    )
    val changeType: ChangeType
) {
}