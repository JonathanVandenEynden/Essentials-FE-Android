package com.hogentessentials1.essentials.data.model.Repositories

import com.hogentessentials1.essentials.data.model.DAOs.QuestionDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kilian Hoefman
 */

@Singleton
class QuestionRepository @Inject constructor(private val questionDao: QuestionDao){

    fun getQuestions() = questionDao.getQuestions()

    fun getQuestion(questionId: Int) = questionDao.getQuestion(questionId)
}