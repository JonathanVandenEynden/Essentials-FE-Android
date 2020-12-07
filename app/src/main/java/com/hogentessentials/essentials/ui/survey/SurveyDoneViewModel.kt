package com.hogentessentials.essentials.ui.survey

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hogentessentials.essentials.data.repositories.QuestionRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class SurveyDoneViewModel(private val repo: QuestionRepository) : ViewModel() {

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
