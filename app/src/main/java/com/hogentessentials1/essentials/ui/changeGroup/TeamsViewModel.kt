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

    private val _navigateToTeam = MutableLiveData<Long>()
    val navigateToTeam: LiveData<Long>
        get() = _navigateToTeam

    fun onTeamClicked(id: Long){

        _navigateToTeam.value = id;
    }

    fun onNavigatedToTeamDetail(){
        _navigateToTeam.value = null;
    }
}