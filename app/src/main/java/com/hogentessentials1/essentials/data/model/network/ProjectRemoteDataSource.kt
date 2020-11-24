package com.hogentessentials1.essentials.data.model.network

class ProjectRemoteDataSource(val rmiApiService: ProjectsEndpointInterface) : BaseDataSource() {

    suspend fun getProjectById(projectId: Int) = getResult { rmiApiService.getProjectById(projectId) }

    suspend fun getProjectsFromOrganization(organizationId: Int) = getResult { rmiApiService.getProjectsFromOrganization(organizationId) }
}