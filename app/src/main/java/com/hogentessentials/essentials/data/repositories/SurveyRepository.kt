package com.hogentessentials.essentials.data.repositories

import com.hogentessentials.essentials.data.model.Survey
import com.hogentessentials.essentials.data.network.SurveyRemoteDataSource
import com.hogentessentials.essentials.util.Resource

class SurveyRepository(val remoteDataSource: SurveyRemoteDataSource) {

    suspend fun getAllSurveys(): Resource<List<Survey>> {
        return remoteDataSource.getAllSurveys()
    }

    suspend fun getSurveyById(surveyId: Int): Resource<Survey> {
        return remoteDataSource.getSurveyById(surveyId)
    }

    suspend fun getSurveyByRoadMapItemId(roadMapItemId: Int): Resource<Survey> {
        return remoteDataSource.getSurveyByRoadMapItemId(roadMapItemId)
    }
}
