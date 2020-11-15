package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.DAOs.ProjectDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProjectRepository @Inject constructor(private val projectDao: ProjectDao) {

    fun getProjects() = projectDao.getProjects()

    fun getProject(id: Int) = projectDao.getProject(id)
}
