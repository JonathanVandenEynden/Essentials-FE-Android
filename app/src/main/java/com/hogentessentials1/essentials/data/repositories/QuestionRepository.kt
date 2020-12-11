package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.model.Question
import com.hogentessentials1.essentials.data.network.QuestionRemoteDataSource
import com.hogentessentials1.essentials.util.Resource
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 *
 * Repository for answers
 */
@Singleton
class QuestionRepository(val remoteDataSource: QuestionRemoteDataSource) {

    /**
     * get all question for a survey
     * @param surveyId
     * @return Resource with list of questions
     */
    suspend fun getAllQuestionsFromSurveyById(surveyId: Int): Resource<List<Question>> {
        return remoteDataSource.getAllQuestionsFromSurveyById(surveyId)
    }

    /**
     * post an answer to a question
     * @param questionId
     * @param answer the answer to add to the question
     * @return Unit
     */
    suspend fun postAnswerToQuestion(questionId: Int, answer: String) {
        return remoteDataSource.postAnswerToQuestion(questionId, answer)
    }
}
