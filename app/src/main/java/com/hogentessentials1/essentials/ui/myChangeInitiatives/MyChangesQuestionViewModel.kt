package com.hogentessentials1.essentials.ui.myChangeInitiatives

import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.Question

/**
 * @author Sébastien De Pauw
 */

class MyChangesQuestionViewModel() : ViewModel() {
    lateinit var question: Question

    override fun onCleared() {
        super.onCleared()
    }
}
