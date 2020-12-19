package com.hogentessentials1.essentials.ui.changeGroup.EmployeeDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hogentessentials1.essentials.R

class EmployeeDetails : Fragment() {

    companion object {
        fun newInstance() = EmployeeDetails()
    }

    private lateinit var viewModel: EmployeeDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.employee_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EmployeeDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}