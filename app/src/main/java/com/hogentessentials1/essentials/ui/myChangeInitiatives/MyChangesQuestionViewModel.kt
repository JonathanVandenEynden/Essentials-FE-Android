package com.hogentessentials1.essentials.ui.myChangeInitiatives

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.*
import java.util.*

/**
 * @author Sébastien De Pauw
 */

class MyChangesQuestionViewModel() : ViewModel(){
    lateinit var question: Question

    override fun onCleared() {
        super.onCleared()
    }
}