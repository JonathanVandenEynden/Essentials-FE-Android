package com.hogentessentials1.essentials.ui.changeGroup

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.data.repositories.ChangeGroupRepository
import com.hogentessentials1.essentials.util.Resource

/**
 * View model for the overview of the teams
 * @author Simon De Wilde
 *
 * @property repo
 */
class TeamsViewModel(private val repo: ChangeGroupRepository) : ViewModel() {
    val changeGroups: LiveData<Resource<List<ChangeGroup>>> = repo.getChangeGroups()
}