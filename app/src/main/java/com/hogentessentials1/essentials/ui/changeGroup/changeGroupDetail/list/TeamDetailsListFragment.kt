package com.hogentessentials1.essentials.ui.changeGroup.changeGroupDetail.list

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.ChangeGroup
import com.hogentessentials1.essentials.data.model.Employee
import com.hogentessentials1.essentials.databinding.TeamdetailsListBinding

/**
 * @author Jonathan Vanden Eynden Van Lysebeth
 */

class TeamDetailsListFragment : Fragment() {

    lateinit var viewModel: TeamDetailsListViewModel

    private lateinit var binding: TeamdetailsListBinding


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.teamdetails_list,
            container,
            false
        )

        var employees: ArrayList<Employee> = arrayListOf()

        viewModel = ViewModelProvider(this).get(TeamDetailsListViewModel::class.java)

        val args = TeamDetailsListFragmentArgs.fromBundle(requireArguments())
        val cg: ChangeGroup = args.changeGroup

        cg.employeeChangeGroups!!.forEach { e -> e.employee?.let { employees.add(it) } }


        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        val manager = LinearLayoutManager(activity)

        binding.TeamDetailsRV.layoutManager = manager

        val adapter = TeamDetailsListAdapter(
            TeamDetailsClickListener { e ->
                viewModel.onEmployeeClicked(e)
            }
        )

        viewModel.navigateToEmpolyee.observe(
            viewLifecycleOwner,
            { e ->
                e?.let {
                    this.findNavController().navigate(
                        TeamDetailsListFragmentDirections.actionTeamDetailsListFragmentToEmployeeFragment(
                            e
                        )
                    )
                    viewModel.onEmployeeNavigated()
                }
            }
        )

        binding.TeamDetailsRV.adapter = adapter

        adapter.submitList(employees)

        (activity as AppCompatActivity).supportActionBar?.title = "Team details"

        return binding.root
    }

}
