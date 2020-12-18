package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.DAOs.AssessmentDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository for assessments
 * @author Kilian Hoefman
 *
 * @property assessmentDao
 */

@Singleton
class AssessmentRepository @Inject constructor(private val assessmentDao: AssessmentDao) {

    /**
     * get all assessments
     * @return liveData with list of assessments
     */
    fun getAssessments() = assessmentDao.getAssessments()

    /**
     * get assessment by id
     * @param assessmentId
     * @return LiveData with assessment
     */
    fun getAssessment(assessmentId: Int) = assessmentDao.getAssessment(assessmentId)
}
