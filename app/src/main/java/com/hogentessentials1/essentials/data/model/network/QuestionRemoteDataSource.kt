package com.hogentessentials1.essentials.data.model.network

class QuestionRemoteDataSource(val questionApiService: QuestionsEndpointInterface) : BaseDataSource() {

    suspend fun getAllQuestionsFromSurveyById(surveyId: Int) = getResult { questionApiService.getAllQuestionsFromSurveyById(surveyId) }
}