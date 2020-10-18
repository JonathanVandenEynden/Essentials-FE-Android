package com.example.essentials.ui.changeInitiatives

import androidx.lifecycle.ViewModel
import com.example.essentials.data.model.ChangeInitiative

class ChangeInitiativeViewModel : ViewModel() {

    lateinit var changeInitiatives: ArrayList<ChangeInitiative>

    init {
        changeInitiatives = ArrayList()
        changeInitiatives.add(ChangeInitiative("New Resto"))
        changeInitiatives.add(ChangeInitiative("Upgrade office layout"))
    }

    override fun onCleared() {
        super.onCleared()
    }
}
