package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.model.Project
import com.hogentessentials1.essentials.data.network.ProjectRemoteDataSource
import com.hogentessentials1.essentials.data.network.local.ProjectLocalDataSource
import com.hogentessentials1.essentials.util.Resource
import com.hogentessentials1.essentials.util.performGetOperation
import javax.inject.Singleton

/**
 * Repository for projects
 * @author Kilian Hoefman
 * @author Marbod Naassens
 *
 * @property remoteDataSource
 * @property localDataSource
 */
@Singleton
class ProjectRepository(val remoteDataSource: ProjectRemoteDataSource, private val localDataSource: ProjectLocalDataSource) {

    /**
     * get project by id
     * @param projectId
     * @return Resource with project
     */
    suspend fun getProjectById(projectId: Int): Resource<Project> {
        return remoteDataSource.getProjectById(projectId)
    }

    /**
     * get all projects
     * @param organizationId
     * @return Resource with list of projects
     */
    fun getProjectsFromOrganization(organizationId: Int) = performGetOperation(
        databaseQuery = { localDataSource.getProjects() },
        networkCall = { remoteDataSource.getProjectsFromOrganization(organizationId) },
        saveCallResult = { localDataSource.saveProjects(it) }
    )
}
