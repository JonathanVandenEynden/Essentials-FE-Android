package com.example.essentials.ui.homeScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.essentials.data.model.ChangeInitiative
import com.example.essentials.data.model.Survey
import com.example.essentials.data.model.SurveyQuestion

/**
 * @author Simon De Wilde
 */
class HomeScreenViewModel : ViewModel() {

    val changeInitiatives: ArrayList<ChangeInitiative> = arrayListOf(
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

    fun getSurveys(): ArrayList<Survey> {
        val surveys: ArrayList<Survey> = arrayListOf()
        for (c in changeInitiatives) {
            surveys.addAll(c.surveys)
        }
        return surveys
    }

    /**
     * navigatie naar Change Initiatives
     */
    private val _navigateToChangeInitiatives = MutableLiveData<Boolean>()
    val navigateToChangeInitiatives: LiveData<Boolean>
        get() = _navigateToChangeInitiatives

    fun onChangeInitiativesClicked() {
        _navigateToChangeInitiatives.value = true
    }

    fun onNavigatedToChangeInitiatives() {
        _navigateToChangeInitiatives.value = false
    }

    /**
     * navigatie naar DashBoard
     */
    private val _navigateToDasboard = MutableLiveData<Boolean>()
    val navigateToDasboard: LiveData<Boolean>
        get() = _navigateToDasboard

    fun onDasboardClicked() {
        _navigateToDasboard.value = true
    }

    fun onNavigatedToDasboard() {
        _navigateToDasboard.value = false
    }

    /**
     * navigatie naar Surveys
     */
    private val _navigateToSurveys = MutableLiveData<Boolean>()
    val navigateToSurveys: LiveData<Boolean>
        get() = _navigateToSurveys

    fun onSurveysClicked() {
        _navigateToSurveys.value = true
    }

    fun onNavigatedToSurveys() {
        _navigateToSurveys.value = false
    }

    /**
     * navigatie naar Teams
     */
    private val _navigateToTeams = MutableLiveData<Boolean>()
    val navigateToTeams: LiveData<Boolean>
        get() = _navigateToTeams

    fun onTeamsClicked() {
        _navigateToTeams.value = true
    }

    fun onNavigatedToTeams() {
        _navigateToTeams.value = false
    }

    /**
     * navigatie naar My Change Initiatives
     */
    private val _navigateToMyChangeInitiatives = MutableLiveData<Boolean>()
    val navigateToMyChangeInitiatives: LiveData<Boolean>
        get() = _navigateToMyChangeInitiatives

    fun onMyChangeInitiativesClicked() {
        _navigateToMyChangeInitiatives.value = true
    }

    fun onNavigatedToMyChangeInitiatives() {
        _navigateToMyChangeInitiatives.value = false
    }
}
