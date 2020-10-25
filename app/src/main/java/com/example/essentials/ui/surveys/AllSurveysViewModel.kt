package com.example.essentials.ui.surveys

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.essentials.data.model.Survey

class AllSurveysViewModel : ViewModel() {

    var surveys: ArrayList<Survey>

    override fun onCleared() {
        super.onCleared()
    }

    init {
        surveys = arrayListOf()
    }

    private val _navigateToSurvey = MutableLiveData<Survey>()
    val navigateToSurvey
        get() = _navigateToSurvey

    fun onSurveyClicked(survey: Survey) {
        _navigateToSurvey.value = survey
    }

    fun onSurveyNavigated() {
        _navigateToSurvey.value = null
    }
}
