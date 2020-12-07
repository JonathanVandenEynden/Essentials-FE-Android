package com.hogentessentials.essentials.data.repositories

import com.hogentessentials.essentials.data.model.Project
import com.hogentessentials.essentials.data.network.ProjectRemoteDataSource
import com.hogentessentials.essentials.util.Resource
import javax.inject.Singleton

@Singleton
class ProjectRepository(val remoteDataSource: ProjectRemoteDataSource) {

    suspend fun getProjectsFromOrganization(organizationId: Int): Resource<List<Project>> {
        return remoteDataSource.getProjectsFromOrganization(organizationId)
    }

    suspend fun getProjectById(projectId: Int): Resource<Project> {
        return remoteDataSource.getProjectById(projectId)
    }
}
