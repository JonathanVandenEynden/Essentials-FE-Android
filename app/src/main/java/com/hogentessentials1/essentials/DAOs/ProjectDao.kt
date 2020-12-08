package com.hogentessentials1.essentials.DAOs

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogentessentials1.essentials.data.model.Project

/**
 * Dao for the project-entity
 */
@Dao
interface ProjectDao {
    /**
     * @return list of all project ordered by Id
     */
    @Query("SELECT * FROM project ORDER BY project_id")
    fun getProjects(): LiveData<List<Project>>

    /**
     * @return list of all project ordered by Id
     */
    @Query("SELECT * FROM project WHERE project_id = :id")
    fun getProject(id: Int): LiveData<Project>

    /**
     * inserts a list of projects to the database
     * @param projects: list of project
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(projects: List<Project>)
}
