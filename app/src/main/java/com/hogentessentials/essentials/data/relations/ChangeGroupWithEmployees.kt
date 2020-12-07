package com.hogentessentials.essentials.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hogentessentials.essentials.data.model.ChangeGroup
import com.hogentessentials.essentials.data.model.Employee

/**
 * @author Kilian Hoefman
 */
data class ChangeGroupWithEmployees(
    @Embedded val changeGroup: ChangeGroup,
    @Relation(
        parentColumn = "id",
        entityColumn = "employee_id"
    )
    val employees: List<Employee>
)
