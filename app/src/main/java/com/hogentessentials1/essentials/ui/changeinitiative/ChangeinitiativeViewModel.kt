package com.hogentessentials1.essentials.ui.changeinitiative

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.ChangeInitiative

/**
 * @author Ziggy Moens
 */

class ChangeinitiativeViewModel : ViewModel() {

    lateinit var changeInitiative: ChangeInitiative /* = ChangeInitiative(
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
    )*/

    private val _navigateToRoadmap = MutableLiveData<Boolean>()
    val navigateToRoadmap
        get() = _navigateToRoadmap

    fun onRoadmapClicked() {
        _navigateToRoadmap.value = true
    }

    fun onRoadmapNavigated() {
        _navigateToRoadmap.value = false
    }
}
