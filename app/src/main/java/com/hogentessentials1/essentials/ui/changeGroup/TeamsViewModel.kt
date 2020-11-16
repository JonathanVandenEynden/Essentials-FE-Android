package com.hogentessentials1.essentials.ui.changeGroup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.network.ChangeGroupApi
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

/**
 * Author Simon De Wilde
 *
 * Apistatus enum
 */
enum class ChangeGroupApiStatus { LOADING, ERROR, DONE }

/**
 * @author Simon De Wilde
 *
 * Viewmodel for the overview of the teams
 */
class TeamsViewModel : ViewModel() {

    private val _status = MutableLiveData<ChangeGroupApiStatus>()
    val status: LiveData<ChangeGroupApiStatus>
        get() = _status

    private val _changeGroups = MutableLiveData<List<ChangeGroup>>()
    val changeGroups: LiveData<List<ChangeGroup>>
        get() = _changeGroups

    init {

        getChangeGroupsForLoggedInUser()

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

    private fun getChangeGroupsForLoggedInUser() {
        viewModelScope.launch {
            _status.value = ChangeGroupApiStatus.LOADING
            Timber.e("start met ophalen")
            try {
                _changeGroups.value =
                    ChangeGroupApi.changeGroupApiService.getChangeGroupsForUser(4); // TODO logged in userid meegeven
                Timber.e("ophalen successvol")
                _status.value = ChangeGroupApiStatus.DONE
            } catch (e: Exception) {
                Timber.e("ophalen mislukt")
                Timber.e("${e.message}")

                _status.value = ChangeGroupApiStatus.ERROR
                _changeGroups.value = ArrayList()
            }
        }
    }
}
