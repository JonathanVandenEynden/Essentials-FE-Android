package com.hogentessentials1.essentials.data.model.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hogentessentials1.essentials.data.model.Portfolio
import com.hogentessentials1.essentials.data.model.Project

/**
 * @author Kilian Hoefman
 */

data class PortfolioWithProjects (
    @Embedded val portfolio: Portfolio,
    @Relation(
        parentColumn = "portfolio_id",
        entityColumn = "project_id"
    )
    val projects: List<Project>
){

}