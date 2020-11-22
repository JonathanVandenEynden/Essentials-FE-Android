package com.hogentessentials1.essentials.data.model.network

import com.hogentessentials1.essentials.data.model.*
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*

/**
 * @author Kilian Hoefman
 * @author Jonathan Vanden Eynden
 */

private const val BASE_URL = "https://essentialsapi.azurewebsites.net/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface EmployeeEndpointInterface {

    @GET("Employees/{id}")
    suspend fun getEmployee(@Path("id") id: Int): Call<Employee>

    @GET("Employees/GetAllEmployeesFromOrganization/{organizationId}")
    suspend fun getAllEmployeesFromOrganization(@Path("organizationId") organizationId: Int): Call<List<Employee>>
}

interface ChangeInitiativesEndpointInterface {

    @GET("ChangeInitiatives/{id}")
    suspend fun getChangeInitiativeById(@Path("id") id: Int): Response<List<ChangeInitiative>>

    @GET("ChangeInitatives/GetChangeInitiativesForEmployee/{employeeId}")
    suspend fun getChangeInitiativesForEmployee(@Path("employeeId") employeeId: Int): Call<List<ChangeInitiative>>

    @GET("ChangeInitiatives/GetChangeInitiativesForChangeManager/{changeManagerId}")
    suspend fun getChangeInitiativesForChangeManager(@Path("changeManagerId") changeManagerId: Int): Call<List<ChangeInitiative>>
}

interface ChangeManagersEndpointInterface {

    @GET("ChangeManagers/GetChangeManagersFromOrganization/{organizationId}")
    suspend fun getChangeManagersFromOrganizationWithId(@Path("organizationId") organizationId: Int): Call<List<ChangeManager>>

    @GET("ChangeManagers/{changeManagerId}")
    suspend fun getChangeManagerById(@Path("changeManagerId") changeManagerId: Int): Call<ChangeManager>
}

interface OrganizationsEndpointInterface {

    @GET("Organizations/{organizationId}")
    suspend fun getOrganizationById(@Path("organizationId") organizationId: Int): Call<Organization>
}

interface ProjectsEndpointInterface {

    @GET("Projects/GetProjectsForOrganization/{organizationId}")
    suspend fun getProjectsFromOrganization(@Path("organizationId") organizationId: Int): Call<List<Project>>

    @GET("Projects/{projectId}")
    suspend fun getProjectById(@Path("projectId") projectId: Int): Call<Project>
}

interface QuestionsEndpointInterface {

    @GET("Questions/{surveyId}")
    suspend fun getAllQuestionsFromSurveyById(@Path("surveyId") surveyId: Int): Call<List<Question>>

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
    suspend fun getRoadMapItemsForChangeInitatitveWithId(@Path("changeInitiativeId") changeInitiativeId: Int): Call<List<RoadMapItem>>
}

interface SurveyEndpointInterface {

    @GET("Survey")
    suspend fun getAllSurveys(): Call<List<Survey>>

    @GET("Survey/{id}")
    suspend fun getSurveyById(@Path("id") id: Int): Call<Survey>

    @GET("Survey/GetSurveyByRoadMapItemId/{roadmapItemId}")
    suspend fun getSurveyByRoadMapItemId(@Path("roadmapItemId") roadmapItemId: Int): Call<RoadMapItem>
}

