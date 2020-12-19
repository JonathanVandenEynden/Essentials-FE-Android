package com.hogentessentials1.essentials.data.network

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray

/**
 * The remote data source for questions
 * @author Kilian Hoefman
 * @author Ziggy Moens
 * @property questionApiService
 */
class QuestionRemoteDataSource(val questionApiService: QuestionsEndpointInterface) :
    BaseDataSource() {

    /**
     * gets all questions from a survey with a given id
     *
     * @param surveyId
     */
    suspend fun getAllQuestionsFromSurveyById(surveyId: Int) =
        getResult { questionApiService.getAllQuestionsFromSurveyById(surveyId) }

    /**
     * answer a question with a given id
     *
     * @param questionId
     * @param answer the answer that was chosen
     */
    suspend fun postAnswerToQuestion(questionId: Int, answer: String) {
        val answerArray = JSONArray()
        answerArray.put(answer)
        val jsonObjectString = answerArray.toString()
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())
        questionApiService.postAnswerToQuestion(questionId, requestBody)
    }
}
