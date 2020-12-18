package com.hogentessentials1.essentials.ui.roadMap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.RoadMapItem

/**
 * view model for the road map fragment
 *
 * @author Ziggy Moens
 */
class RoadMapViewModel : ViewModel() {

    lateinit var roadMapItem: RoadMapItem

    override fun onCleared() {
        super.onCleared()
    }

    private val _navigateToSurvey = MutableLiveData<Boolean>()
    val navigateToSurvey: LiveData<Boolean>
        get() = _navigateToSurvey

    fun onSurveyClicked() {
        _navigateToSurvey.value = true
    }

    fun onNavigatedToSurvey() {
        _navigateToSurvey.value = false
    }
}
