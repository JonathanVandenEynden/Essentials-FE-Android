package com.hogentessentials1.essentials.data.network

/**
 * The remote data source for surveys
 * @author Kilian Hoefman
 * @property surveyApiService
 */
class SurveyRemoteDataSource(val surveyApiService: SurveyEndpointInterface) : BaseDataSource() {

    /**
     * gets all surveys
     *
     */
    suspend fun getAllSurveys() = getResult { surveyApiService.getAllSurveys() }

    /**
     * gets a survey with a given id
     *
     * @param surveyId
     */
    suspend fun getSurveyById(surveyId: Int) = getResult { surveyApiService.getSurveyById(surveyId) }

    /**
     * gets the survey from the road map with a given id
     *
     * @param roadMapItemId
     */
    suspend fun getSurveyByRoadMapItemId(roadMapItemId: Int) = getResult { surveyApiService.getSurveyByRoadMapItemId(roadMapItemId) }
}
