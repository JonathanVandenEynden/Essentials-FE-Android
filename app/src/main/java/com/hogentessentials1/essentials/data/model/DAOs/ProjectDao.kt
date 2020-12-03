package com.hogentessentials1.essentials.data.model.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.Project

@Dao
interface ProjectDao {
    @Query("SELECT * FROM project ORDER BY project_id")
    fun getProjects(): LiveData<List<Project>>

    @Query("SELECT * FROM project WHERE project_id = :id")
    fun getProject(id: Int): LiveData<Project>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(projects: List<Project>)
}
