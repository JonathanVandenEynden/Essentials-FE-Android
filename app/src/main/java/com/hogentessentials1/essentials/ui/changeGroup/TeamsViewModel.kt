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
}
