package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.DAOs.QuestionDao
import com.hogentessentials1.essentials.data.model.Question
import com.hogentessentials1.essentials.data.model.network.QuestionRemoteDataSource
import com.hogentessentials1.essentials.data.model.util.Resource
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class QuestionRepository(val remoteDataSource: QuestionRemoteDataSource){

    suspend fun getAllQuestionsFromSurveyById(surveyId: Int): Resource<List<Question>>{
        return remoteDataSource.getAllQuestionsFromSurveyById(surveyId)
    }
}
