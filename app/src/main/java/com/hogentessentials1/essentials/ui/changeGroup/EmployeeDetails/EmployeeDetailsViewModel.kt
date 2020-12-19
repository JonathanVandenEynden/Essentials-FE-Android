package com.hogentessentials1.essentials.ui.changeGroup.EmployeeDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hogentessentials1.essentials.data.model.Employee

class EmployeeDetailsViewModel : ViewModel() {
    private val _navigateToEmployeeDetails = MutableLiveData<Employee?>()
    val navigateToEmployeeDetails
        get() = _navigateToEmployeeDetails

    fun onEmployeeListenerClicked(employee: Employee) {
        _navigateToEmployeeDetails.value = employee
    }

    fun onEmployeeNavigated() {
        _navigateToEmployeeDetails.value = null
    }
}