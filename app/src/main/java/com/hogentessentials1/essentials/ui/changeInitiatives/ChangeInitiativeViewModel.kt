package com.hogentessentials1.essentials.ui.changeInitiatives

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.Repositories.RoadMapRepository
import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.data.model.util.Status
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * @author Simon De Wilde
 * @author Ziggy Moens: added offline data
 *
 * viewmodel voor changeInitiative
 */
class ChangeInitiativeViewModel(private val repo: RoadMapRepository) : ViewModel() {

//    fun getSurveys(): ArrayList<Survey> {
//        val surveys: ArrayList<Survey> = arrayListOf()
//        for (c in changeInitiatives) {
//            surveys.addAll(c.surveys)
//        }
//        return surveys
//    }

    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status

    private val _rmi = MutableLiveData<RoadMapItem>()
    val rmi: LiveData<RoadMapItem>
        get() = _rmi

    var changeInitiatives: ArrayList<ChangeInitiative> = arrayListOf(
//        ChangeInitiative(
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
    )

    init {
        viewModelScope.launch {
            _status.value = Status.LOADING
            Timber.e("start met ophalen")
            try {
                _rmi.value =
                    repo.getRoadMapItemById(5).data
                Timber.e("ophalen successvol")
                _status.value = Status.SUCCESS
            } catch (e: Exception) {
                Timber.e("ophalen mislukt")
                Timber.e("${e.message}")

                _status.value = Status.ERROR
                // _changeGroups.value = ArrayList()
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
