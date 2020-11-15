package com.hogentessentials1.essentials.data.model.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.ChangeType
import com.hogentessentials1.essentials.data.model.Employee

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
) {
}