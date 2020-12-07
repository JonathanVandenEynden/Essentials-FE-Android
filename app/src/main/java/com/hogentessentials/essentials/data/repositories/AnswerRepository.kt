package com.hogentessentials.essentials.data.repositories

import com.hogentessentials.essentials.DAOs.AnswerDao
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
