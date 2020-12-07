package com.hogentessentials.essentials.data.repositories

import com.hogentessentials.essentials.DAOs.AssessmentDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class AssessmentRepository @Inject constructor(private val assessmentDao: AssessmentDao) {

    fun getAssessments() = assessmentDao.getAssessments()

    fun getAssessment(assessmentId: Int) = assessmentDao.getAssessment(assessmentId)
}
