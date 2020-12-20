package com.hogentessentials1.essentials.data.network

/**
 * The remote data source for projects
 * @author Kilian Hoefman
 * @property projectApiService
 */
class ProjectRemoteDataSource(private val projectApiService: ProjectsEndpointInterface) : BaseDataSource() {

    /**
     * gets a project with a given id
     *
     * @param projectId
     */
    suspend fun getProjectById(projectId: Int) = getResult { projectApiService.getProjectById(projectId) }

    /**
     * gets all projects from an organization with a given id
     *
     * @param organizationId
     */
    suspend fun getProjectsFromOrganization(organizationId: Int) = getResult { projectApiService.getProjectsFromOrganization(organizationId) }
}
