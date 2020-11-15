package com.hogentessentials1.essentials.data.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hogentessentials1.essentials.data.model.DAOs.*

@Database(entities = [Project::class, Employee::class, ChangeInitiative::class, RoadMapItem::class, ChangeGroup::class], version = 1, exportSchema = false)
abstract class EssentialsDatabase : RoomDatabase() {
    abstract fun EmployeeDao(): EmployeeDao
    abstract fun ChangeInitiativeDao(): ChangeInitiativeDao
    abstract fun ChangeGroupDao(): ChangeGroupDao
    abstract fun ProjectDao(): ProjectDao
    abstract fun RoadMapDao(): RoadMapDao


}