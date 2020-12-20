package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.data.model.Survey
import com.hogentessentials1.essentials.data.network.SurveyRemoteDataSource
import com.hogentessentials1.essentials.util.Resource
import javax.inject.Singleton

/**
 * Repository for surveys
 *
 */
@Singleton
class SurveyRepository(val remoteDataSource: SurveyRemoteDataSource) {

    /**
     * get all surveys
     * @return Resource with list of surveys
     */
    suspend fun getAllSurveys(): Resource<List<Survey>> {
        return remoteDataSource.getAllSurveys()
    }

    /**
     * get survey by id
     * @param surveyId
     * @return Resource with survey
     */
    suspend fun getSurveyById(surveyId: Int): Resource<Survey> {
        return remoteDataSource.getSurveyById(surveyId)
    }
    /**
     * get survey by road map item id
     * @param roadMapItemId
     * @return Resource with survey
     */
    suspend fun getSurveyByRoadMapItemId(roadMapItemId: Int): Resource<Survey> {
        return remoteDataSource.getSurveyByRoadMapItemId(roadMapItemId)
    }
}
