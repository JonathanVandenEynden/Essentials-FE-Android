package com.hogentessentials1.essentials.data.model.Relations

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
        parentColumn = "project_id",
        entityColumn = "id"
    )
    val changeInitiatives: List<ChangeInitiative>
){

}