package com.hogentessentials1.essentials.ui.myChangeInitiatives.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.Question
import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.data.repositories.QuestionRepository
import com.hogentessentials1.essentials.util.Status
import kotlinx.coroutines.launch
import timber.log.Timber

class MyChangesQuestionListViewModel (private val repo: QuestionRepository) : ViewModel() {

    private val _status = MutableLiveData<Status>()

    val status: LiveData<Status>
        get() = _status

    private val _questions = MutableLiveData<List<Question>>()

    val Questions: LiveData<List<Question>>
        get() = _questions

    fun getAllQuestions(id: Int?) {
        viewModelScope.launch {
            _status.value = Status.LOADING
            Timber.e("All questions - start met ophalen")
            try {
                if(id != null){
                _questions.value =
                    repo.getAllQuestionsFromSurveyById(id).data
                }
                Timber.e("All questions - ophalen successvol")

                val temp_q = arrayListOf<Question>()
                for (q in _questions.value!!) {
                    temp_q.add(q)
                }
                val temp_final_q = temp_q.toList()
                _questions.value = temp_final_q

                _status.value = Status.SUCCESS
            } catch (e: Exception) {
                Timber.e("All questions - ophalen mislukt")
                Timber.e("$e")
                _status.value = Status.ERROR
            }
        }
    }

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