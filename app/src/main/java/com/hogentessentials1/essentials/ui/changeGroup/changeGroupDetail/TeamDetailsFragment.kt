package com.hogentessentials1.essentials.ui.changeGroup.changeGroupDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.data.model.Employee
import com.hogentessentials1.essentials.databinding.TeamDetailsFragmentBinding
import com.hogentessentials1.essentials.ui.changeGroup.EmployeeDetails.EmployeeDetailsAdapter
import com.hogentessentials1.essentials.ui.changeGroup.EmployeeDetails.EmployeeDetailsViewModel
import com.hogentessentials1.essentials.ui.changeGroup.EmployeeDetails.EmployeeListener
import com.hogentessentials1.essentials.ui.roadMap.RoadMapViewModel

/**
 * Fragment for showing the team members of a change group
 * @author Simon De Wilde
 *
 */
class TeamDetailsFragment : Fragment() {

    private lateinit var changeGroupMembers : ChangeGroup
    private lateinit var adapter : EmployeeDetailsAdapter
    private lateinit var viewModel : EmployeeDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<TeamDetailsFragmentBinding>(
            inflater,
            R.layout.team_details_fragment,
            container,
            false
        )

        arguments?.get("changeGroupMembers")?.let{
            changeGroupMembers = it as ChangeGroup
        }

        var employees : ArrayList<Employee> = arrayListOf()

        changeGroupMembers.employeeChangeGroups?.forEach { e -> employees.add(e.employee!!) }
        viewModel = ViewModelProvider(this).get(EmployeeDetailsViewModel::class.java)

        adapter = EmployeeDetailsAdapter(
            EmployeeListener { employee ->
                viewModel.onEmployeeListenerClicked(employee)
            }
        )

        viewModel.navigateToEmployeeDetails.observe(
            viewLifecycleOwner,
            { employee ->
                employee?.let {
                    this.findNavController().navigate(
                        TeamDetailsFragmentDirections.actionTeamDetailsFragmentToEmployeeDetails(
                            employee
                        )
                    )
                    viewModel.onEmployeeNavigated()
                }
            }
        )

        binding.teamsdetailsRV.adapter = adapter

        adapter.submitList(employees)

        (activity as AppCompatActivity).supportActionBar?.title = "Team members"

        return binding.root
    }
}
