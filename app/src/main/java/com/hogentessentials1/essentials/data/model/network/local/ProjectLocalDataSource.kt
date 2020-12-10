package com.hogentessentials1.essentials.data.model.network.local

import com.hogentessentials1.essentials.DAOs.ProjectDao
import com.hogentessentials1.essentials.data.model.Project

class ProjectLocalDataSource(val projectDao: ProjectDao) {
    fun getProjects() = projectDao.getProjects()

    suspend fun saveProjects(list: List<Project>) = projectDao.insertAll(list)
}
