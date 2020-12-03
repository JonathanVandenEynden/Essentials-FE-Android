package com.hogentessentials1.essentials.ui.survey

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hogentessentials1.essentials.data.model.Repositories.QuestionRepository
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * @author Ziggy Moens
 */

class SurveyQuestionViewModel(private val repo: QuestionRepository) : ViewModel() {

    fun answer(questionId: Int, answer: String) {
        try {
            viewModelScope.launch {
                Timber.e(questionId.toString())
                repo.postAnswerToQuestion(questionId, answer)
            }
        } catch (e: Exception) {
        }
    }
}
