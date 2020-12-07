package com.hogentessentials.essentials.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hogentessentials.essentials.data.model.ChangeInitiative
import com.hogentessentials.essentials.data.model.Project

/**
 * @author Kilian Hoefman
 */

data class ProjectWithChangeInitiatives(
    @Embedded val project: Project,
    @Relation(
        parentColumn = "project_id",
        entityColumn = "id"
    )
    val changeInitiatives: List<ChangeInitiative>
)
