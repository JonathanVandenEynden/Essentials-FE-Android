package com.example.essentials.ui.changeInitiatives

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.essentials.data.model.ChangeInitiative

class ChangeInitiativeViewModel : ViewModel() {

    lateinit var changeInitiatives: ArrayList<ChangeInitiative>

    init {
        changeInitiatives = ArrayList()
    }

    override fun onCleared() {
        super.onCleared()
    }

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
