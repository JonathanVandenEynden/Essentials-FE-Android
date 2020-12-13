package com.hogentessentials1.essentials.ui.changeGroup

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.data.repositories.ChangeGroupRepository
import com.hogentessentials1.essentials.util.Resource

/**
 * @author Simon De Wilde
 *
 * Viewmodel for the overview of the teams
 */
class TeamsViewModel(private val repo: ChangeGroupRepository) : ViewModel() {

    val changeGroups: LiveData<Resource<List<ChangeGroup>>> = repo.getChangeGroups()

    init {

//        val mockMembers = arrayListOf<String>()
//        mockMembers.add("Simon")
//        mockMembers.add("Ziggy")
//        mockMembers.add("Kilian")
//        mockMembers.add("Jonathan")
//        mockMembers.add("Marbod")
//        mockMembers.add("Sébastien")
//
//        val mockChangeGroups = mutableListOf<ChangeGroup>()
//        mockChangeGroups.add(ChangeGroup(321, "changeGroup1", mockMembers))
//        mockChangeGroups.add(ChangeGroup(123, "changeGroup2", mockMembers))
//
//        _changeGroups.value = mockChangeGroups
    }

//    private fun getChangeGroupsForLoggedInUser() {
//        viewModelScope.launch {
//            _status.value = ChangeGroupApiStatus.LOADING
//            Timber.e("start met ophalen")
//            try {
//                _changeGroups.value =
//                    repo.getChangeGroupsForUser().data
//                Timber.e("ophalen successvol")
//                _status.value = ChangeGroupApiStatus.DONE
//            } catch (e: Exception) {
//                Timber.e("ophalen mislukt")
//                Timber.e("${e.message}")
//
//                _status.value = ChangeGroupApiStatus.ERROR
//                _changeGroups.value = ArrayList()
//            }
//        }
//    }
}
