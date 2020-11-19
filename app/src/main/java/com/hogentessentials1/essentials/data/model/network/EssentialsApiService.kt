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

private const val BASE_URL = "https://essentialsapi.azurewebsites.net/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface EmployeeEndpointInterface {

    @GET("Employees/{id}")
    fun getEmployee(@Path("id") id: Int): Call<Employee>

    @GET("Employees/GetAllEmployeesFromOrganization/{organizationId}")
    fun getAllEmployeesFromOrganization(@Path("organizationId") organizationId: Int): Call<List<Employee>>
}

interface ChangeInitiativesEndpointInterface{

    @GET("ChangeInitiatives/{id}")
    fun getChangeInitiativeById(@Path("id") id: Int): Call<List<ChangeInitiative>>

    @GET("ChangeInitatives/GetChangeInitiativesForEmployee/{employeeId}")
    fun getChangeInitiativesForEmployee(@Path("employeeId") employeeId: Int): Call<List<ChangeInitiative>>

    @GET("/ChangeInitiatives/GetChangeInitiativesForChangeManager/{changeManagerId}")
    fun getChangeInitiativesForChangeManager(@Path("changeManagerId") changeManagerId: Int): Call<List<ChangeInitiative>>
}

interface ChangeManagersEndpointInterface{

    @GET("/ChangeManagers/GetChangeManagersFromOrganization/{organizationId}")
    fun getChangeManagersFromOrganizationWithId(@Path("organizationId") organizationId: Int) : Call<List<ChangeManager>>

    @GET("ChangeManagers/{changeManagerId}")
    fun getChangeManagerById(@Path("changeManagerId") changeManagerId: Int) : Call<ChangeManager>
}

interface OrganizationsEndpointInterface{

    @GET("Organizations/{organizationId}")
    fun getOrganizationById(@Path("organizationId") organizationId: Int) : Call<Organization>
}


interface ProjectsEndpointInterface{

    @GET("/Projects/GetProjectsForOrganization/{organizationId}")
    fun getProjectsFromOrganization(@Path("organizationId") organizationId: Int): Call<List<Project>>

    @GET("/Projects/{projectId}")
    fun getProjectById(@Path("projectId") projectId: Int) : Call<Project>
}

interface QuestionsEndpointInterface {

    @GET("/Questions/{surveyId}")
    fun getAllQuestionsFromSurveyById(@Path("surveyId") surveyId: Int) : Call<List<Question>>

    @POST("/Questions/PostAnswerToQuestion/{questionId}")
    fun postAnswerToQuestion(@Path("questionId") questionId: Int, @Body requestBody: RequestBody) : Response<ResponseBody>

    @DELETE("/Questions/{surveyId}")
    fun deleteSurveyById(@Path("surveyId") surveyId: Int): Response<ResponseBody>
}

interface RoadMapItemsEndpointInterface{

    @GET("/RoadMapItems/{id}")
    fun getRoadMapItemById(@Path("id") id: Int) : Call<RoadMapItem>

    @GET("/RoadMapItems/GetRoadMapItemsForChangeInitiative/{changeInitiativeId}")
    fun getRoadMapItemsForChangeInitatitveWithId(@Path("changeInitiativeId") changeInitiativeId: Int) : Call<List<RoadMapItem>>
}

interface SurveyEndpointInterface {

    @GET("/Survey")
    fun getAllSurveys() : Call<List<Survey>>

    @GET("/Survey/{id}")
    fun getSurveyById(@Path("id") id: Int) : Call<Survey>

    @GET("/Survey/GetSurveyByRoadMapItemId/{roadmapItemId}")
    fun getSurveyByRoadMapItemId(@Path("roadmapItemId") roadmapItemId: Int): Call<RoadMapItem>
}