package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.DAOs.AnswerDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class AnswerRepository @Inject constructor(private val answerDao: AnswerDao) {

    fun getAnswers() = answerDao.getAnswers()

    fun getAnswer(answerId: Int) = answerDao.getAnswer(answerId)
}
