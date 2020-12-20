package com.hogentessentials1.essentials.ui.roadMap.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.data.repositories.ChangeInitiativeRepository
import com.hogentessentials1.essentials.util.Resource

/**
 * view model for the road map overview
 *
 * @author Ziggy Moens
 * @author Simon De Wilde
 */
class RoadMapListViewModel(private val repo: ChangeInitiativeRepository) : ViewModel() {

//    private val _status = MutableLiveData<Status>()
//
//    val status: LiveData<Status>
//        get() = _status
//
//    private val _roadmapitems = MutableLiveData<List<RoadMapItem>>()
//    private val _changeinitiatives = MutableLiveData<List<ChangeInitiative>>()
//
//    val RoadMapItems: LiveData<List<RoadMapItem>>
//        get() = _roadmapitems

    val allCI: LiveData<Resource<List<ChangeInitiative>>> = repo.getChangeInitiativesForEmployee()

//    fun getAllSurveys() {
//        viewModelScope.launch {
//            _status.value = Status.LOADING
//            Timber.e("All roadmapitems - start met ophalen")
//            try {
//                _changeinitiatives.value =
//                    repo.getChangeInitiativesForEmployee().value?.data
//                Timber.e("All roadmapitems - ophalen successvol")
//
//                val temp_rmi = arrayListOf<RoadMapItem>()
//                for (c in _changeinitiatives.value!!) {
//                    for (r in c.roadMap) {
//                        temp_rmi.add(r)
//                    }
//                }
//                val temp_final_rmi = temp_rmi.toList()
//                _roadmapitems.value = temp_final_rmi
//
//                _status.value = Status.SUCCESS
//            } catch (e: Exception) {
//                Timber.e("All roadmapitems - ophalen mislukt")
//                Timber.e("$e")
//                _status.value = Status.ERROR
//            }
//        }
//    }

    private val _navigateToRoadMapItem = MutableLiveData<RoadMapItem?>()
    val navigateToRoadMapItem
        get() = _navigateToRoadMapItem

    fun onRoadMapClicked(roadMapItem: RoadMapItem) {
        _navigateToRoadMapItem.value = roadMapItem
    }

    fun onRoadMapNavigated() {
        _navigateToRoadMapItem.value = null
    }
}
