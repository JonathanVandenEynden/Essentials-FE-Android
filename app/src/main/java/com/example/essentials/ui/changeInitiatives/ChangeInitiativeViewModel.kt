package com.example.essentials.ui.changeInitiatives

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.essentials.data.model.ChangeInitiative
import com.example.essentials.data.model.Survey
import com.example.essentials.data.model.SurveyQuestion

/**
 * @author Simon De Wilde
 *
 * viewmodel voor changeInitiative
 */
class ChangeInitiativeViewModel : ViewModel() {

//    fun getSurveys(): ArrayList<Survey> {
//        val surveys: ArrayList<Survey> = arrayListOf()
//        for (c in changeInitiatives) {
//            surveys.addAll(c.surveys)
//        }
//        return surveys
//    }

    lateinit var changeInitiatives: ArrayList<ChangeInitiative>

    init {
        // TODO hier data ophalen van API
        changeInitiatives = arrayListOf(
            ChangeInitiative(
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
            ),
            ChangeInitiative(
                title = "Expansion to German market",
                surveys = arrayListOf(
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
            )
        )
    }

    override fun onCleared() {
        super.onCleared()
    }

    private val _navigateToChangeInitiative = MutableLiveData<ChangeInitiative>()
    val navigateToChangeInitiative
        get() = _navigateToChangeInitiative

    fun onChangeInitiativeClicked(changeInitiative: ChangeInitiative) {
        _navigateToChangeInitiative.value = changeInitiative
    }

    fun onChangeInitiativeNavigated() {
        _navigateToChangeInitiative.value = null
    }
}
