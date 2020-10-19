package com.example.essentials.ui.homeScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeScreenViewModel : ViewModel() {

    private val _navigateToChangeInitiatives = MutableLiveData<Boolean>()
    val navigateToChangeInitiatives: LiveData<Boolean>
        get() = _navigateToChangeInitiatives

    fun onChangeInitiativesClicked() {
        _navigateToChangeInitiatives.value = true
    }

    fun onNavigatedToChangeInitiatives() {
        _navigateToChangeInitiatives.value = false
    }
}
