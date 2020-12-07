package com.hogentessentials1.essentials.ui.changeInitiatives

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.repositories.ChangeInitiativeRepository
import com.hogentessentials1.essentials.util.Status
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * @author Ziggy Moens
 * @author Simon De Wilde
 * viewmodel voor changeInitiative
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

    fun changeinitiativesEmployee() {
        viewModelScope.launch {
            _status.value = Status.LOADING
            Timber.e("Change initiative - start met ophalen")
            try {
                _changeinitiavtives.value =
                    repo.getChangeInitiativesForEmployee().data
                Timber.e("Change initiative E - ophalen successvol")
                Timber.e(changeinitiatives.value.toString())
                _status.value = Status.SUCCESS
            } catch (e: Exception) {
                Timber.e("Change initiatives E - ophalen mislukt")
                Timber.e("$e")
                _status.value = Status.ERROR
            }
        }
    }

    fun changeinitiativesChangeManager() {
        viewModelScope.launch {
            _status.value = Status.LOADING
            Timber.e("Change initiative - start met ophalen")
            try {
                _changeinitiavtives.value =
                    repo.getChangeInitiativesForChangeManager().data
                Timber.e("Change initiative C - ophalen successvol")
                Timber.e(changeinitiatives.value.toString())
                _status.value = Status.SUCCESS
            } catch (e: Exception) {
                Timber.e("Change initiatives C - ophalen mislukt")
                Timber.e("$e")
                _status.value = Status.ERROR
            }
        }
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

// ChangeInitiative(
//            title = "New Resto",
//            surveys = arrayListOf(
//                Survey(
//                    name = "Personnel Survey",
//                    questions = arrayListOf(
//                        SurveyQuestion(
//                            question = "What do you think of the new personnel?",
//                            option0 = "Uneatable",
//                            option5 = "Delicious"
//                        ),
//                        SurveyQuestion(
//                            question = "Would you recommend the new resto to your colleagues?",
//                            option0 = "No",
//                            option5 = "Yes"
//                        )
//                    )
//                ),
//                Survey(
//                    name = "Food Survey",
//                    questions = arrayListOf(
//                        SurveyQuestion(
//                            question = "What do you think of the new food?",
//                            option0 = "Uneatable",
//                            option5 = "Delicious"
//                        ),
//                        SurveyQuestion(
//                            question = "Would you recommend the food to your colleagues?",
//                            option0 = "No",
//                            option5 = "Yes"
//                        )
//                    )
//                ),
//                Survey(
//                    name = "Impact Survey",
//                    questions= arrayListOf(
//                        SurveyQuestion(
//                            question = "What do you think this change has an impact on your work?",
//                            option0 = "No",
//                            option5 = "Yes"
//                        ),
//                        SurveyQuestion(
//                            question = "Would you feel more happy at work?",
//                            option0 = "No",
//                            option5 = "Yes"
//                        )
//                    )
//                )
//            )
//        ),
//        ChangeInitiative(
//            title = "Expansion to German market",
//            surveys = arrayListOf(
//                Survey(
//                    name = "Financial Survey",
//                    questions= arrayListOf(
//                        SurveyQuestion(
//                            question = "What do you think of the new financial arrangement concerning the expansion?",
//                            option0 = "Very bad",
//                            option5 = "Very Good"
//                        ),
//                        SurveyQuestion(
//                            question = "Do you think you will get a raise by the end of the year?",
//                            option0 = "No",
//                            option5 = "Yes"
//                        )
//                    )
//                ),
//                Survey(
//                    name = "Work Survey",
//                    questions= arrayListOf(
//                        SurveyQuestion(
//                            question = "Do you feel more pressure at work?",
//                            option0 = "No",
//                            option5 = "Yes"
//                        ),
//                        SurveyQuestion(
//                            question = "Would you like working form home while we are expanding?",
//                            option0 = "No",
//                            option5 = "Yes"
//                        )
//                    )
//                )
//            )
//        )
