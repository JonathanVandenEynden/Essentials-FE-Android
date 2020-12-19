package com.hogentessentials1.essentials.data.network

import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.ChangeManager
import com.hogentessentials1.essentials.data.model.Employee
import com.hogentessentials1.essentials.data.model.Organization
import com.hogentessentials1.essentials.data.model.Project
import com.hogentessentials1.essentials.data.model.Question
import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.data.model.Survey
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

/**
 * @author Kilian Hoefman
 * @author Jonathan Vanden Eynden
 * @author Simon De Wilde
 */

// private const val BASE_URL = "https://essentialsapi.azurewebsites.net/api/"

// private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()
//
// private val retrofit = Retrofit.Builder()
//    .addConverterFactory(ScalarsConverterFactory.create())
//    .baseUrl(BASE_URL)
//    .build()

/**
 * Interface to make api calls for employees using the Retrofit library
 */
interface EmployeeEndpointInterface {

    @GET("Employees/{id}")
    suspend fun getEmployee(@Path("id") id: Int): Response<Employee>

    @GET("Employees/GetAllEmployeesFromOrganization/{organizationId}")
    suspend fun getAllEmployeesFromOrganization(@Path("organizationId") organizationId: Int): Response<List<Employee>>

    @GET("Employees/GetEmployeeByEmail/{email}")
    suspend fun getEmployeeByEmail(@Path("email") email: String): Response<Employee>
}

/**
 * Interface to make api calls for changeInitiatives using the Retrofit library
 */
interface ChangeInitiativesEndpointInterface {

    @GET("ChangeInitiatives/{id}")
    suspend fun getChangeInitiativeById(@Path("id") id: Int): Response<ChangeInitiative>

    @GET("ChangeInitiatives/GetChangeInitiativesForEmployee")
    suspend fun getChangeInitiativesForEmployee(): Response<List<ChangeInitiative>>

    @GET("ChangeInitiatives/GetChangeInitiativesForChangeManager")
    suspend fun getChangeInitiativesForChangeManager(): Response<List<ChangeInitiative>>
}

/**
 * Interface to make api calls for changeGroups using the Retrofit library
 */
interface ChangeGroupEndpointInterface {
    @GET("ChangeGroups/GetChangeGroupForUser")
    suspend fun getChangeGroupsForUser(): Response<List<ChangeGroup>>
}

/**
 * Interface to make api calls for changeManagers using the Retrofit library
 */
interface ChangeManagersEndpointInterface {

    @GET("ChangeManagers/GetChangeManagersFromOrganization/{organizationId}")
    suspend fun getChangeManagersFromOrganizationWithId(@Path("organizationId") organizationId: Int): Response<List<ChangeManager>>

    @GET("ChangeManagers/{changeManagerId}")
    suspend fun getChangeManagerById(@Path("changeManagerId") changeManagerId: Int): Response<ChangeManager>

    @GET("ChangeManagers/GetChangeManagerByEmail/{email}")
    suspend fun getChangeManagerByEmail(@Path("email") email: String): Response<ChangeManager>
}

/**
 * Interface to make api calls for organizations using the Retrofit library
 */
interface OrganizationsEndpointInterface {

    @GET("Organizations/{organizationId}")
    suspend fun getOrganizationById(@Path("organizationId") organizationId: Int): Response<Organization>
}

/**
 * Interface to make api calls for projects using the Retrofit library
 */
interface ProjectsEndpointInterface {

    @GET("Projects/GetProjectsForOrganization/{organizationId}")
    suspend fun getProjectsFromOrganization(@Path("organizationId") organizationId: Int): Response<List<Project>>

    @GET("Projects/{projectId}")
    suspend fun getProjectById(@Path("projectId") projectId: Int): Response<Project>
}

/**
 * Interface to make api calls for questions using the Retrofit library
 */
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

/**
 * Interface to make api calls for road map items using the Retrofit library
 */
interface RoadMapItemsEndpointInterface {

    @GET("RoadMapItems/{id}")
    suspend fun getRoadMapItemById(@Path("id") id: Int): Response<RoadMapItem>

    @GET("RoadMapItems/GetRoadMapItemsForChangeInitiative/{changeInitiativeId}")
    suspend fun getRoadMapItemsForChangeInitatitveWithId(@Path("changeInitiativeId") changeInitiativeId: Int): Response<List<RoadMapItem>>
}

/**
 * Interface to make api calls for surveys using the Retrofit library
 */
interface SurveyEndpointInterface {

    @GET("Survey")
    suspend fun getAllSurveys(): Response<List<Survey>>

    @GET("Survey/{id}")
    suspend fun getSurveyById(@Path("id") id: Int): Response<Survey>

    @GET("Survey/GetSurveyByRoadMapItemId/{roadmapItemId}")
    suspend fun getSurveyByRoadMapItemId(@Path("roadmapItemId") roadmapItemId: Int): Response<Survey>
}

/**
 * Interface to make api calls for dashboards using the Retrofit library
 */
interface DashboardEndpointInterface {
    @GET("Dashboard/GetFilledInSurveysOfChangeInitiative/{id}")
    suspend fun getFilledInSurveys(@Path("id") id: Int): Response<Double>

    @GET("Dashboard/GetMoodFromChangeInitiative/{id}")
    suspend fun getMood(@Path("id") id: Int): Response<Map<Int, Int>>
}

/**
 * Interface to make api calls for accounts using the Retrofit library
 */
interface AccountEndpointInterface {
    @POST("Account/Login")
    suspend fun login(
        @Body requestBody: RequestBody
    ): Response<ResponseBody>
}

interface DeviceTokenEndpointInterface {
    @POST("DeviceTokens/{userid}")
    suspend fun postDeviceToken(@Path("userid") userid: String, @Query("token") token: String): Response<ResponseBody>
}
