package com.hogentessentials.essentials.data.network

class SurveyRemoteDataSource(val surveyApiService: SurveyEndpointInterface) : BaseDataSource() {

    suspend fun getAllSurveys() = getResult { surveyApiService.getAllSurveys() }

    suspend fun getSurveyById(surveyId: Int) = getResult { surveyApiService.getSurveyById(surveyId) }

    suspend fun getSurveyByRoadMapItemId(roadMapItemId: Int) = getResult { surveyApiService.getSurveyByRoadMapItemId(roadMapItemId) }
}
