package com.hogentessentials1.essentials.ui.changeGroup.changeGroupDetail.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.Employee
import com.hogentessentials1.essentials.data.model.Question
import com.hogentessentials1.essentials.data.repositories.QuestionRepository
import com.hogentessentials1.essentials.util.Status

/**
 * @author Sébastien De Pauw
 */

class TeamDetailsListViewModel() : ViewModel() {

    private val _navigateToEmployee = MutableLiveData<Employee?>()
    val navigateToEmpolyee
        get() = _navigateToEmployee

    fun onEmployeeClicked(employee: Employee) {
        _navigateToEmployee.value = employee
    }

    fun onEmployeeNavigated() {
        _navigateToEmployee.value = null
    }
}

