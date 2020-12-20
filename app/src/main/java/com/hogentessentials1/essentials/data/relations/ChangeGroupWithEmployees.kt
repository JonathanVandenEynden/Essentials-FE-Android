package com.hogentessentials1.essentials.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.data.model.Employee

/**
 * POJO class for relationship between changegroup and employee (1-to-many)
 * @author Kilian Hoefman
 */
data class ChangeGroupWithEmployees(
    @Embedded
    val changeGroup: ChangeGroup,

    @Relation(
        parentColumn = "id",
        entityColumn = "changeGroup_id"
    )
    val employees: List<Employee>
)
