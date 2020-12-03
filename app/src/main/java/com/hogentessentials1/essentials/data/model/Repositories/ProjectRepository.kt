package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.DAOs.ProjectDao
import com.hogentessentials1.essentials.data.model.Project
import com.hogentessentials1.essentials.data.model.network.ChangeInitiativeRemoteDataSource
import com.hogentessentials1.essentials.data.model.network.ProjectRemoteDataSource
import com.hogentessentials1.essentials.data.model.network.local.ProjectLocalDataSource
import com.hogentessentials1.essentials.data.model.util.Resource
import com.hogentessentials1.essentials.data.model.util.performGetOperation
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProjectRepository(val remoteDataSource: ProjectRemoteDataSource, val localDataSource: ProjectLocalDataSource){

    suspend fun getProjectsFromOrganization(organizationId: Int) : Resource<List<Project>> {
        return remoteDataSource.getProjectsFromOrganization(organizationId)
    }

    suspend fun getProjectById(projectId: Int) : Resource<Project> {
        return remoteDataSource.getProjectById(projectId)
    }

    fun getProjects() = performGetOperation(
        databaseQuery = { localDataSource.getProjects() },
        networkCall = { remoteDataSource.getProjectsFromOrganization(1) },
        saveCallResult = { localDataSource.saveProjects(it) }
    )
}
