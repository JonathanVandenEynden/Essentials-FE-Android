package com.hogentessentials1.essentials.ui.changeGroup.changeGroupDetail.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.Employee

/**
 * Viewmodel for TeamDetailsListFragment
 * @author Jonathan Vanden Eynden Van Lysebeth
 */

class TeamDetailsListViewModel : ViewModel() {

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
