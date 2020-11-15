package com.hogentessentials1.essentials.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Kilian Hoefman
 */
@Entity(tableName = "project")
data class Project (
    @PrimaryKey @ColumnInfo(name= "project_id") val Id: Int,
    val name: String,
    val changeInitiatives: ArrayList<ChangeInitiative>
    ){
}