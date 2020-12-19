package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.model.Project
import com.hogentessentials1.essentials.data.network.ProjectRemoteDataSource
import com.hogentessentials1.essentials.data.network.local.ProjectLocalDataSource
import com.hogentessentials1.essentials.util.Resource
import javax.inject.Singleton

/**
 * Repository for projects
 *
 * @property remoteDataSource
 * @property localDataSource
 */
@Singleton
class ProjectRepository(val remoteDataSource: ProjectRemoteDataSource, val localDataSource: ProjectLocalDataSource) {

    /**
     * get all projects
     * @return Resource with list of projects
     */
    suspend fun getProjectsFromOrganization(organizationId: Int): Resource<List<Project>> {
        return remoteDataSource.getProjectsFromOrganization(organizationId)
    }

    /**
     * get project by id
     * @param projectId
     * @return Resource with project
     */
    suspend fun getProjectById(projectId: Int): Resource<Project> {
        return remoteDataSource.getProjectById(projectId)
    }
}
