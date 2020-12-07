package com.hogentessentials1.essentials.data.network

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray

class QuestionRemoteDataSource(val questionApiService: QuestionsEndpointInterface) :
    BaseDataSource() {

    suspend fun getAllQuestionsFromSurveyById(surveyId: Int) =
        getResult { questionApiService.getAllQuestionsFromSurveyById(surveyId) }

    suspend fun postAnswerToQuestion(question: Int, answer: String) {
        val answerArray = JSONArray()
        answerArray.put(answer)
        val jsonObjectString = answerArray.toString()
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())
        questionApiService.postAnswerToQuestion(question, requestBody)
    }
}
