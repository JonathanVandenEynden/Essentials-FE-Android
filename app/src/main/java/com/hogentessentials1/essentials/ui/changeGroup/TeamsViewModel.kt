package com.hogentessentials1.essentials.ui.changeGroup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.ChangeGroup

/**
 * @author Simon De Wilde
 *
 * Viewmodel for the overview of the teams
 */
class TeamsViewModel : ViewModel() {

    private val _changeGroups = MutableLiveData<List<ChangeGroup>>()
    val changeGroups: LiveData<List<ChangeGroup>>
        get() = _changeGroups

    init {
        // TODO ChangeGroups ophalen uit dao
        val mockMembers = arrayListOf<String>()
        mockMembers.add("Simon")
        mockMembers.add("Ziggy")
        mockMembers.add("Kilian")
        mockMembers.add("Jonathan")
        mockMembers.add("Marbod")
        mockMembers.add("Sébastien")

        val mockChangeGroups = mutableListOf<ChangeGroup>()
        mockChangeGroups.add(ChangeGroup(321, "changeGroup1", mockMembers))
        mockChangeGroups.add(ChangeGroup(123, "changeGroup2", mockMembers))

        _changeGroups.value = mockChangeGroups
    }
}
