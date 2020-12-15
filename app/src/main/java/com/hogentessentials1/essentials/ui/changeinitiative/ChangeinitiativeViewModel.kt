package com.hogentessentials1.essentials.ui.changeinitiative

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.ChangeInitiative

/**
 * @author Ziggy Moens
 *
 * Viewmodel for the change initiative (detail) fragment
 */

class ChangeinitiativeViewModel : ViewModel() {

    lateinit var changeInitiative: ChangeInitiative

    override fun onCleared() {
        super.onCleared()
    }

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
