package com.hogentessentials1.essentials.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.Project

/**
 * @author Kilian Hoefman
 */

data class ProjectWithChangeInitiatives(
    @Embedded val project: Project,
    @Relation(
        parentColumn = "id",
        entityColumn = "project_id"
    )
    val changeInitiatives: List<ChangeInitiative>
)
