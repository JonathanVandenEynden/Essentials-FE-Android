package com.hogentessentials1.essentials.ui.surveys

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.Survey
import com.hogentessentials1.essentials.data.model.SurveyQuestion

/**
 * @author Simon De Wilde: added offline data used from ChangeInitiativeViewModel
 * @author Ziggy Moens
 */
class AllSurveysViewModel : ViewModel() {

    var surveys: ArrayList<Survey>

    override fun onCleared() {
        super.onCleared()
    }

    init {
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
            ),
            Survey(
                name = "Financial Survey",
                arrayListOf(
                    SurveyQuestion(
                        question = "What do you think of the new financial arrangement concerning the expansion?",
                        option0 = "Very bad",
                        option5 = "Very Good"
                    ),
                    SurveyQuestion(
                        question = "Do you think you will get a raise by the end of the year?",
                        option0 = "No",
                        option5 = "Yes"
                    )
                )
            ),
            Survey(
                name = "Work Survey",
                arrayListOf(
                    SurveyQuestion(
                        question = "Do you feel more pressure at work?",
                        option0 = "No",
                        option5 = "Yes"
                    ),
                    SurveyQuestion(
                        question = "Would you like working form home while we are expanding?",
                        option0 = "No",
                        option5 = "Yes"
                    )
                )
            )
        )
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
