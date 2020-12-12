package com.hogentessentials1.essentials.ui.myChangeInitiatives

/**
 * @author Sébastien De Pauw
 */

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.*
import java.util.*

class MyChangesQuestionViewModel() : ViewModel(){
    lateinit var question: Question

    override fun onCleared() {
        super.onCleared()
    }

    private val _navigateToQuestion = MutableLiveData<Boolean>()
    val navigateToQuestion: LiveData<Boolean>
        get() = _navigateToQuestion

    fun onQuestionClicked() {
        _navigateToQuestion.value = true
    }

    fun onNavigatedToQuestion() {
        _navigateToQuestion.value = false
    }
}