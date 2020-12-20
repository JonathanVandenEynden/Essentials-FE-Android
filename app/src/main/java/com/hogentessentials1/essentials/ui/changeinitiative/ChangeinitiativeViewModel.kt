package com.hogentessentials1.essentials.ui.changeinitiative

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.ChangeInitiative

/**
 * Viewmodel for the change initiative (detail) fragment
 * @author Ziggy Moens
 *
 */

class ChangeinitiativeViewModel : ViewModel() {

    lateinit var changeInitiative: ChangeInitiative

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
