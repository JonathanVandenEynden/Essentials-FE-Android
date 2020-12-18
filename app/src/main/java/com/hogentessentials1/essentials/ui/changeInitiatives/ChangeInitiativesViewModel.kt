package com.hogentessentials1.essentials.ui.changeInitiatives

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.repositories.ChangeInitiativeRepository
import com.hogentessentials1.essentials.util.Resource
import com.hogentessentials1.essentials.util.Status

/**
 * @author Ziggy Moens
 * @author Simon De Wilde
 * viewmodel for list of change initiatives
 */
class ChangeInitiativesViewModel(private val repo: ChangeInitiativeRepository) : ViewModel() {

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status

    private val _changeinitiavtives = MutableLiveData<List<ChangeInitiative>>()
    val changeinitiatives: LiveData<List<ChangeInitiative>>
        get() = _changeinitiavtives

    init {
    }

    val changeinitiativesEmployee: LiveData<Resource<List<ChangeInitiative>>> = repo.getChangeInitiativesForEmployee()

//    fun changeinitiativesEmployee() {
//        viewModelScope.launch {
//            _status.value = Status.LOADING
//            Timber.e("Change initiative - start met ophalen")
//            try {
//                _changeinitiavtives.value =
//                    repo.getChangeInitiativesForEmployee().data
//                Timber.e("Change initiative E - ophalen successvol")
//                Timber.e(changeinitiatives.value.toString())
//                _status.value = Status.SUCCESS
//            } catch (e: Exception) {
//                Timber.e("Change initiatives E - ophalen mislukt")
//                Timber.e("$e")
//                _status.value = Status.ERROR
//            }
//        }
//    }

    val changeinitiativesChangeManager: LiveData<Resource<List<ChangeInitiative>>> = repo.getChangeInitiativesForChangeManager()

//    fun changeinitiativesChangeManager() {
//        viewModelScope.launch {
//            _status.value = Status.LOADING
//            Timber.e("Change initiative - start met ophalen")
//            try {
//                _changeinitiavtives.value =
//                    repo.getChangeInitiativesForChangeManager().data
//                Timber.e("Change initiative C - ophalen successvol")
//                Timber.e(changeinitiatives.value.toString())
//                _status.value = Status.SUCCESS
//            } catch (e: Exception) {
//                Timber.e("Change initiatives C - ophalen mislukt")
//                Timber.e("$e")
//                _status.value = Status.ERROR
//            }
//        }
//    }

    private val _navigateToChangeInitiative = MutableLiveData<ChangeInitiative>()
    val navigateToChangeInitiative
        get() = _navigateToChangeInitiative

    fun onChangeInitiativeClicked(changeInitiative: ChangeInitiative) {
        _navigateToChangeInitiative.value = changeInitiative
    }

    fun onChangeInitiativeNavigated() {
        _navigateToChangeInitiative.value = null
    }
}
