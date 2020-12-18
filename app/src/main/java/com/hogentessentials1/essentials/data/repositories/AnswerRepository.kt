package com.hogentessentials1.essentials.data.repositories

import com.hogentessentials1.essentials.DAOs.AnswerDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Repository for answers
 * @author Kilian Hoefman
 *
 * @property answerDao
 */

@Singleton
class AnswerRepository @Inject constructor(private val answerDao: AnswerDao) {

    /**
     * get all answers
     * @return liveData with list of answers
     */
    fun getAnswers() = answerDao.getAnswers()

    /**
     * get answer by id
     * @param answerId
     * @return LiveData with answer
     */
    fun getAnswer(answerId: Int) = answerDao.getAnswer(answerId)
}
