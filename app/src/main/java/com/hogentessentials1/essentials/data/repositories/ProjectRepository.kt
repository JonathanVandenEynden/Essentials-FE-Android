package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.model.Project
import com.hogentessentials1.essentials.data.network.ProjectRemoteDataSource
import com.hogentessentials1.essentials.util.Resource
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
