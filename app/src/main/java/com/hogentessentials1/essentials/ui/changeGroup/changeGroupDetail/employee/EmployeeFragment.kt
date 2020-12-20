package com.hogentessentials1.essentials.ui.changeGroup.changeGroupDetail.employee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.Employee
import com.hogentessentials1.essentials.databinding.EmployeeDetailsFragmentBinding

/**
 * @author Sébastien De Pauw
 */

class EmployeeFragment : Fragment() {
    private lateinit var employee: Employee

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: EmployeeDetailsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.employee_details_fragment, container, false)

        val args = EmployeeFragmentArgs.fromBundle(requireArguments())
        employee = args.employee

        val viewModel = ViewModelProvider(this).get(EmployeeViewModel::class.java)

        binding.viewModel = viewModel

        return binding.root
    }
}
