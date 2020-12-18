package com.hogentessentials1.essentials.data.network.local

import com.hogentessentials1.essentials.DAOs.ProjectDao
import com.hogentessentials1.essentials.data.model.Project

/**
 * The local data source for projects
 *
 * @property projectDao
 */
class ProjectLocalDataSource(val projectDao: ProjectDao) {
    /**
     * gets all projects from the db
     *
     */
    fun getProjects() = projectDao.getProjects()

    /**
     * saves a list of projects to the db
     *
     * @param list
     */
    suspend fun saveProjects(list: List<Project>) = projectDao.insertAll(list)
}
