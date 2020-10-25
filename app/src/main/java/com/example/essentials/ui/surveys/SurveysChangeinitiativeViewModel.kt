package com.example.essentials.ui.surveys

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.essentials.data.model.ChangeInitiative
import com.example.essentials.data.model.Survey
import com.example.essentials.data.model.SurveyQuestion

class SurveysChangeinitiativeViewModel : ViewModel() {

    val changeInitiative: ChangeInitiative = ChangeInitiative(
        title = "New Resto",
        surveys = arrayListOf(
            Survey(
                name = "Personnel Survey",
                arrayListOf(
                    SurveyQuestion(
                        question = "What do you think of the new personnel?",
                        option0 = "Uneatable",
                        option5 = "Delicious"
                    ),
                    SurveyQuestion(
                        question = "Would you recommend the new resto to your colleagues?",
                        option0 = "No",
                        option5 = "Yes"
                    )
                )
            ),
            Survey(
                name = "Food Survey",
                arrayListOf(
                    SurveyQuestion(
                        question = "What do you think of the new food?",
                        option0 = "Uneatable",
                        option5 = "Delicious"
                    ),
                    SurveyQuestion(
                        question = "Would you recommend the food to your colleagues?",
                        option0 = "No",
                        option5 = "Yes"
                    )
                )
            )
        )
    )

    override fun onCleared() {
        super.onCleared()
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
