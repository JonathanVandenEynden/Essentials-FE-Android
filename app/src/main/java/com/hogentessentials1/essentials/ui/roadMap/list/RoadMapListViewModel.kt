package com.hogentessentials1.essentials.ui.roadMap.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.data.repositories.ChangeInitiativeRepository
import com.hogentessentials1.essentials.util.Status
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * @author Ziggy Moens
 */
class RoadMapListViewModel(private val repo: ChangeInitiativeRepository) : ViewModel() {

    private val _status = MutableLiveData<Status>()

    val status: LiveData<Status>
        get() = _status

    private val _roadmapitems = MutableLiveData<List<RoadMapItem>>()
    private val _changeinitiatives = MutableLiveData<List<ChangeInitiative>>()

    val RoadMapItems: LiveData<List<RoadMapItem>>
        get() = _roadmapitems

    fun getAllSurveys() {
        viewModelScope.launch {
            _status.value = Status.LOADING
            Timber.e("All roadmapitems - start met ophalen")
            try {
                _changeinitiatives.value =
                    repo.getChangeInitiativesForEmployee().value?.data
                Timber.e("All roadmapitems - ophalen successvol")

                val temp_rmi = arrayListOf<RoadMapItem>()
                for (c in _changeinitiatives.value!!) {
                    for (r in c.roadMap) {
                        temp_rmi.add(r)
                    }
                }
                val temp_final_rmi = temp_rmi.toList()
                _roadmapitems.value = temp_final_rmi

                _status.value = Status.SUCCESS
            } catch (e: Exception) {
                Timber.e("All roadmapitems - ophalen mislukt")
                Timber.e("$e")
                _status.value = Status.ERROR
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }

    private val _navigateToRoadMapItem = MutableLiveData<RoadMapItem>()
    val navigateToRoadMapItem
        get() = _navigateToRoadMapItem

    fun onRoadMapClicked(roadMapItem: RoadMapItem) {
        _navigateToRoadMapItem.value = roadMapItem
    }

    fun onRoadMapNavigated() {
        _navigateToRoadMapItem.value = null
    }
}

/*var surveys: ArrayList<Survey> = arrayListOf(
       Survey(
           name = "Personnel Survey",
           arrayListOf(
               SurveyQuestion(
                   question = "What do you think of the new personnel?",
                   option0 = "Uneatable",
                   option5 = "Delicious"
               ),
               SurveyQuestion(
                   question = "Would you recommend the new resto to your colleagues?",
                   option0 = "No",
                   option5 = "Yes"
               )
           )
       ),
       Survey(
           name = "Food Survey",
           arrayListOf(
               SurveyQuestion(
                   question = "What do you think of the new food?",
                   option0 = "Uneatable",
                   option5 = "Delicious"
               ),
               SurveyQuestion(
                   question = "Would you recommend the food to your colleagues?",
                   option0 = "No",
                   option5 = "Yes"
               )
           )
       ),
       Survey(
           name = "Financial Survey",
           arrayListOf(
               SurveyQuestion(
                   question = "What do you think of the new financial arrangement concerning the expansion?",
                   option0 = "Very bad",
                   option5 = "Very Good"
               ),
               SurveyQuestion(
                   question = "Do you think you will get a raise by the end of the year?",
                   option0 = "No",
                   option5 = "Yes"
               )
           )
       ),
       Survey(
           name = "Work Survey",
           arrayListOf(
               SurveyQuestion(
                   question = "Do you feel more pressure at work?",
                   option0 = "No",
                   option5 = "Yes"
               ),
               SurveyQuestion(
                   question = "Would you like working form home while we are expanding?",
                   option0 = "No",
                   option5 = "Yes"
               )
           )
       )
   )
*/
