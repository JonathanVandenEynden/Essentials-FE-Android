package com.example.essentials.ui.homeScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Simon De Wilde
 */
class HomeScreenViewModel : ViewModel() {

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
