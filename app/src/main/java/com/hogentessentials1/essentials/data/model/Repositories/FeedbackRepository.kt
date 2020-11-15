package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.DAOs.FeedbackDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class FeedbackRepository @Inject constructor(private val feedbackDao: FeedbackDao) {

    fun getFeedbacks() = feedbackDao.getFeedbacks()

    fun getFeedback(feedbackId: Int) = feedbackDao.getFeedback(feedbackId)
}
