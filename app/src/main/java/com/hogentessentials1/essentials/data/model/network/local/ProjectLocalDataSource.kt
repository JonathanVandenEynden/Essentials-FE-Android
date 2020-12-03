package com.hogentessentials1.essentials.data.model.network.local

import com.hogentessentials1.essentials.data.model.DAOs.ProjectDao
import com.hogentessentials1.essentials.data.model.Employee
import com.hogentessentials1.essentials.data.model.Project

class ProjectLocalDataSource(val projectDao: ProjectDao) {
    fun getProjects() = projectDao.getProjects()

    fun saveProjects(list: List<Project>) = projectDao.insertAll(list)
}