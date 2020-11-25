package com.hogentessentials1.essentials.ui.myChangeInitiatives

/**
 * @author Sébastien De Pauw
 */

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.Survey
import com.hogentessentials1.essentials.data.model.SurveyQuestion
import java.util.*

class MyChangesViewModel() : ViewModel(){
    lateinit var survey: Survey
}