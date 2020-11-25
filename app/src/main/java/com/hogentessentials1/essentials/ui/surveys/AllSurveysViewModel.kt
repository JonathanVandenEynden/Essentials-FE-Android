package com.hogentessentials1.essentials.ui.surveys

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hogentessentials1.essentials.data.model.*
import com.hogentessentials1.essentials.data.model.Repositories.*

import com.hogentessentials1.essentials.data.model.util.Status
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * @author Simon De Wilde: added offline data used from ChangeInitiativeViewModel
 * @author Ziggy Moens
 */
class AllSurveysViewModel(private val repo: EmployeeRepository) : ViewModel() {


    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status

//    private val _rmi = MutableLiveData<List<RoadMapItem>>()
//    val rmi: LiveData<List<RoadMapItem>>
//        get() = _rmi

//    private val _changeInit = MutableLiveData<List<ChangeInitiative>>()
//    val changeInit: LiveData<List<ChangeInitiative>>
//        get() = _changeInit

//    private val _project = MutableLiveData<List<Project>>()
//    val project: LiveData<List<Project>>
//        get() = _project

//    private val _questions = MutableLiveData<List<Question>>()
//    val questions: LiveData<List<Question>>
//        get() = _questions

//    private val _organization = MutableLiveData<Organization>()
//    val organization: LiveData<Organization>
//        get() = _organization

    private val _employee = MutableLiveData<Employee>()
    val employee: LiveData<Employee>
        get() = _employee

    var surveys: ArrayList<Survey> = arrayListOf(
//        Survey(
//            name = "Personnel Survey",
//            arrayListOf(
//                SurveyQuestion(
//                    question = "What do you think of the new personnel?",
//                    option0 = "Uneatable",
//                    option5 = "Delicious"
//                ),
//                SurveyQuestion(
//                    question = "Would you recommend the new resto to your colleagues?",
//                    option0 = "No",
//                    option5 = "Yes"
//                )
//            )
//        ),
//        Survey(
//            name = "Food Survey",
//            arrayListOf(
//                SurveyQuestion(
//                    question = "What do you think of the new food?",
//                    option0 = "Uneatable",
//                    option5 = "Delicious"
//                ),
//                SurveyQuestion(
//                    question = "Would you recommend the food to your colleagues?",
//                    option0 = "No",
//                    option5 = "Yes"
//                )
//            )
//        ),
//        Survey(
//            name = "Financial Survey",
//            arrayListOf(
//                SurveyQuestion(
//                    question = "What do you think of the new financial arrangement concerning the expansion?",
//                    option0 = "Very bad",
//                    option5 = "Very Good"
//                ),
//                SurveyQuestion(
//                    question = "Do you think you will get a raise by the end of the year?",
//                    option0 = "No",
//                    option5 = "Yes"
//                )
//            )
//        ),
//        Survey(
//            name = "Work Survey",
//            arrayListOf(
//                SurveyQuestion(
//                    question = "Do you feel more pressure at work?",
//                    option0 = "No",
//                    option5 = "Yes"
//                ),
//                SurveyQuestion(
//                    question = "Would you like working form home while we are expanding?",
//                    option0 = "No",
//                    option5 = "Yes"
//                )
//            )
//        )
    )

    init {

        viewModelScope.launch {
            _status.value = Status.LOADING
            Timber.e("start met ophalen")
            try {
//                _rmi.value =
//                    repo.getRoadMaps(1).data
//                _changeInit.value =
//                    repo.getChangeInitiativesForEmployee(5).data
//                _project.value =
//                    repo.getProjectsFromOrganization(1).data
//                    _questions.value =
//                        repo.getAllQuestionsFromSurveyById(1).data
//                    _organization.value =
//                        repo.getOrganizationById(1).data
                    _employee.value =
                        repo.getEmployeeByEmail("ziggy@essentials.com").data
                Timber.e("ophalen successvol")
                _status.value = Status.SUCCESS
            } catch (e: Exception) {
                Timber.e("ophalen mislukt")
                Timber.e("${e.message}")

                _status.value = Status.ERROR
            }
        }

    }

//    private fun getRoadMapItemsById(id: Int) {
//        viewModelScope.launch {
//            _status.value = Status.LOADING
//            Timber.e("start ophaling dink")
//            try {
//                _rmi.value = EssentialsApi.retrofitService.getRoadMapItemById(id).body()
//                _status.value = Status.SUCCESS
//                Timber.e("ophaling dink gelukt")
//            } catch (e: Exception) {
//                _status.value = Status.ERROR
//                _rmi.value = null
//                Timber.e("ophaling dink mislukt")
//            }
//        }
//    }

    private val _navigateToSurvey = MutableLiveData<Survey>()
    val navigateToSurvey
        get() = _navigateToSurvey

    fun onSurveyClicked(survey: Survey) {
        _navigateToSurvey.value = survey
    }

    fun onSurveyNavigated() {
        _navigateToSurvey.value = null
    }
}
