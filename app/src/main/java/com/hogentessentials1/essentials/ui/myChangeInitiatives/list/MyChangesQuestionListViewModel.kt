package com.hogentessentials1.essentials.ui.myChangeInitiatives.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.Question
import com.hogentessentials1.essentials.data.repositories.QuestionRepository
import com.hogentessentials1.essentials.util.Status

/**
 * @author Sébastien De Pauw
 */

class MyChangesQuestionListViewModel (private val repo: QuestionRepository) : ViewModel() {

    private val _status = MutableLiveData<Status>()

    val status: LiveData<Status>
        get() = _status

    private val _questions = MutableLiveData<List<Question>>()

    val Questions: LiveData<List<Question>>
        get() = _questions

    override fun onCleared() {
        super.onCleared()
    }

    private val _navigateToQuestion = MutableLiveData<Question>()
    val navigateToQuestion
        get() = _navigateToQuestion

    fun onQuestionClicked(question: Question) {
        _navigateToQuestion.value = question
    }

    fun onQuestionNavigated() {
        _navigateToQuestion.value = null
    }
}