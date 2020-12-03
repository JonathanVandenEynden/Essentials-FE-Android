package com.hogentessentials1.essentials.data.model.network

class SurveyRemoteDataSource(val surveyApiService: SurveyEndpointInterface) : BaseDataSource() {

    suspend fun getAllSurveys() = getResult { surveyApiService.getAllSurveys() }

    suspend fun getSurveyById(surveyId: Int) = getResult { surveyApiService.getSurveyById(surveyId) }

    suspend fun getSurveyByRoadMapItemId(roadMapItemId: Int) = getResult { surveyApiService.getSurveyByRoadMapItemId(roadMapItemId) }
}
