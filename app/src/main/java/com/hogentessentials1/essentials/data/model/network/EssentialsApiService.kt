package com.hogentessentials1.essentials.data.model.network

import com.hogentessentials1.essentials.data.model.*
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

/**
 * @author Kilian Hoefman
 * @author Jonathan Vanden Eynden
 * @author Simon De Wilde
 */

//private const val BASE_URL = "https://essentialsapi.azurewebsites.net/api/"

//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()
//
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(ScalarsConverterFactory.create())
//    .baseUrl(BASE_URL)
//    .build()

interface EmployeeEndpointInterface {

    @GET("Employees/{id}")
    suspend fun getEmployee(@Path("id") id: Int): Response<Employee>

    @GET("Employees/GetAllEmployeesFromOrganization/{organizationId}")
    suspend fun getAllEmployeesFromOrganization(@Path("organizationId") organizationId: Int): Response<List<Employee>>

    @GET("Employees/GetEmployeeByEmail/{email}")
    suspend fun getEmployeeByEmail(@Path("email") email: String) : Response<Employee>
}

interface ChangeInitiativesEndpointInterface {

    @GET("ChangeInitiatives/{id}")
    suspend fun getChangeInitiativeById(@Path("id") id: Int): Response<ChangeInitiative>

    @GET("ChangeInitiatives/GetChangeInitiatives/")
    suspend fun getChangeInitiatives(): Response<List<ChangeInitiative>>

//    @GET("ChangeInitiatives/GetChangeInitiativesForChangeManager/{changeManagerId}")
//    suspend fun getChangeInitiativesForChangeManager(@Path("changeManagerId") changeManagerId: Int): Response<List<ChangeInitiative>>
}

interface ChangeGroupEndpointInterface {
    // TODO remove userID --> bearertoken is added with interceptor
    @GET("ChangeGroups/GetChangeGroupForUser/4")
    suspend fun getChangeGroupsForUser(): Response<List<ChangeGroup>>

}

interface ChangeManagersEndpointInterface {

    @GET("ChangeManagers/GetChangeManagersFromOrganization/{organizationId}")
    suspend fun getChangeManagersFromOrganizationWithId(@Path("organizationId") organizationId: Int): Response<List<ChangeManager>>

    @GET("ChangeManagers/{changeManagerId}")
    suspend fun getChangeManagerById(@Path("changeManagerId") changeManagerId: Int): Response<ChangeManager>

    @GET("ChangeManagers/GetChangeManagerByEmail/{email}")
    suspend fun getChangeManagerByEmail(@Path("email") email: String) : Response<ChangeManager>
}

interface OrganizationsEndpointInterface {

    @GET("Organizations/{organizationId}")
    suspend fun getOrganizationById(@Path("organizationId") organizationId: Int): Response<Organization>
}

interface ProjectsEndpointInterface {

    @GET("Projects/GetProjectsForOrganization/{organizationId}")
    suspend fun getProjectsFromOrganization(@Path("organizationId") organizationId: Int): Response<List<Project>>

    @GET("Projects/{projectId}")
    suspend fun getProjectById(@Path("projectId") projectId: Int): Response<Project>
}

interface QuestionsEndpointInterface {

    @GET("Questions/{surveyId}")
    suspend fun getAllQuestionsFromSurveyById(@Path("surveyId") surveyId: Int): Response<List<Question>>

    @POST("Questions/PostAnswerToQuestion/{questionId}")
    suspend fun postAnswerToQuestion(
        @Path("questionId") questionId: Int,
        @Body requestBody: RequestBody
    ): Response<ResponseBody>

    @DELETE("Questions/{surveyId}")
    suspend fun deleteSurveyById(@Path("surveyId") surveyId: Int): Response<ResponseBody>
}

interface RoadMapItemsEndpointInterface {

    @GET("RoadMapItems/{id}")
    suspend fun getRoadMapItemById(@Path("id") id: Int): Response<RoadMapItem>

    @GET("RoadMapItems/GetRoadMapItemsForChangeInitiative/{changeInitiativeId}")
    suspend fun getRoadMapItemsForChangeInitatitveWithId(@Path("changeInitiativeId") changeInitiativeId: Int): Response<List<RoadMapItem>>
}

interface SurveyEndpointInterface {

    @GET("Survey")
    suspend fun getAllSurveys(): Response<List<Survey>>

    @GET("Survey/{id}")
    suspend fun getSurveyById(@Path("id") id: Int): Response<Survey>

    @GET("Survey/GetSurveyByRoadMapItemId/{roadmapItemId}")
    suspend fun getSurveyByRoadMapItemId(@Path("roadmapItemId") roadmapItemId: Int): Response<Survey>
}

interface AccountEndpointInterface {
    @POST("Account/Login")
    suspend fun login(
        @Body requestBody: RequestBody
    ): Response<ResponseBody>
}
