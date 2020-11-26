package com.hogentessentials1.essentials.data.model.network

class ProjectRemoteDataSource(val projectApiService: ProjectsEndpointInterface) : BaseDataSource() {

    suspend fun getProjectById(projectId: Int) = getResult { projectApiService.getProjectById(projectId) }

    suspend fun getProjectsFromOrganization(organizationId: Int) = getResult { projectApiService.getProjectsFromOrganization(organizationId) }
}