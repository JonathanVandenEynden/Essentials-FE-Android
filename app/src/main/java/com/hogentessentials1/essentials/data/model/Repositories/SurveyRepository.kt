package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.Survey
import com.hogentessentials1.essentials.data.model.network.SurveyRemoteDataSource
import com.hogentessentials1.essentials.data.model.util.Resource

class SurveyRepository(val remoteDataSource: SurveyRemoteDataSource) {

    suspend fun getAllSurveys() : Resource<List<Survey>> {
        return remoteDataSource.getAllSurveys()
    }

    suspend fun getSurveyById(surveyId: Int) : Resource<Survey> {
        return remoteDataSource.getSurveyById(surveyId)
    }

    suspend fun getSurveyByRoadMapItemId(roadMapItemId: Int) : Resource<Survey> {
        return remoteDataSource.getSurveyByRoadMapItemId(roadMapItemId)
    }
}