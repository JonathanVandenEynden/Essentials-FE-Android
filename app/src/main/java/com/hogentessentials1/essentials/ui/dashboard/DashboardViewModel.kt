package com.hogentessentials1.essentials.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.data.repositories.ChangeInitiativeRepository
import com.hogentessentials1.essentials.data.repositories.DashboardRepository
import com.hogentessentials1.essentials.data.repositories.RoadMapRepository
import com.hogentessentials1.essentials.util.Resource
import kotlinx.coroutines.launch

/**
 * viewmodel for Dashboard
 *
 * @author Marbod Naassens
 *
 * @property dashboardRepository
 * @property cirepository
 * @property rmiRepository
 */
class DashboardViewModel(private val dashboardRepository: DashboardRepository, private val cirepository: ChangeInitiativeRepository, private val rmiRepository: RoadMapRepository) : ViewModel() {

    var chosenCIId: Int = 1

    val cis: LiveData<Resource<List<ChangeInitiative>>> = cirepository.getChangeInitiativesForChangeManager()

    val rmis: LiveData<Resource<List<RoadMapItem>>> = rmiRepository.getRoadMaps(chosenCIId)

    private val _filledIn = MutableLiveData<Double>()
    val fi: LiveData<Double>
        get() = _filledIn

    private val _mood = MutableLiveData<Map<Int, Int>>()
    val m: LiveData<Map<Int, Int>>
        get() = _mood

    fun fillDashboard() {
        viewModelScope.launch {
            _filledIn.value = dashboardRepository.getFilledInSurveys(chosenCIId).data!!
            _mood.value = dashboardRepository.getMood(chosenCIId).data!!
        }
    }

    private val _navigateToGraph = MutableLiveData<Boolean>()
    val navigateToGraph: LiveData<Boolean>
        get() = _navigateToGraph

    fun onButtonClicked() {
        _navigateToGraph.value = true
    }

    fun onNavigatedToGraph() {
        _navigateToGraph.value = false
    }
}
