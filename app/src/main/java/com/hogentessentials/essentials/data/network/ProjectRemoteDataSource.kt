package com.hogentessentials.essentials.data.network

class ProjectRemoteDataSource(val projectApiService: ProjectsEndpointInterface) : BaseDataSource() {

    suspend fun getProjectById(projectId: Int) = getResult { projectApiService.getProjectById(projectId) }

    suspend fun getProjectsFromOrganization(organizationId: Int) = getResult { projectApiService.getProjectsFromOrganization(organizationId) }
}
