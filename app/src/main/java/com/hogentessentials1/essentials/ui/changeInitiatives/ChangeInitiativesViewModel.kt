package com.hogentessentials1.essentials.ui.changeInitiatives

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.repositories.ChangeInitiativeRepository
import com.hogentessentials1.essentials.util.Resource
import com.hogentessentials1.essentials.util.Status

/**
 * view model for list of change initiatives
 * @author Ziggy Moens
 * @author Simon De Wilde
 *
 * @property repo
 */
class ChangeInitiativesViewModel(private val repo: ChangeInitiativeRepository) : ViewModel() {

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status

    private val _changeinitiavtives = MutableLiveData<List<ChangeInitiative>>()
    val changeinitiatives: LiveData<List<ChangeInitiative>>
        get() = _changeinitiavtives

    val changeinitiativesEmployee: LiveData<Resource<List<ChangeInitiative>>> = repo.getChangeInitiativesForEmployee()

    val changeinitiativesChangeManager: LiveData<Resource<List<ChangeInitiative>>> = repo.getChangeInitiativesForChangeManager()

    private val _navigateToChangeInitiative = MutableLiveData<ChangeInitiative?>()
    val navigateToChangeInitiative
        get() = _navigateToChangeInitiative

    fun onChangeInitiativeClicked(changeInitiative: ChangeInitiative) {
        _navigateToChangeInitiative.value = changeInitiative
    }

    fun onChangeInitiativeNavigated() {
        _navigateToChangeInitiative.value = null
    }
}
