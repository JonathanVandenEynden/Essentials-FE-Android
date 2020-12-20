package com.hogentessentials1.essentials.ui.dashboard

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.databinding.FragmentDashboardBinding
import com.hogentessentials1.essentials.ui.LoadingFragment
import com.hogentessentials1.essentials.util.Status
import org.koin.android.ext.android.inject

/**
 * fragment for dashboards
 * @author Marbod Naassens
 */
class DashboardFragment : Fragment() {
    private var ciList: ArrayList<ChangeInitiative> = arrayListOf()
    private var selectedCI: Int = 0
    private lateinit var selectedChange: ChangeInitiative

    private lateinit var binding: FragmentDashboardBinding
    val viewModel: DashboardViewModel by inject()
    lateinit var adapter: DashboardAdapter
    lateinit var spinner: Spinner
    private val loadingDialogFragment by lazy { LoadingFragment() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_dashboard,
            container,
            false
        )
        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        val spinner = binding.spinnerCi
        val speed = binding.speedView
        speed.unit = getString(R.string.speedometer_label)
        speed.isWithTremble = false
        speed.maxSpeed = 100
        speed.lowSpeedPercent = 33
        speed.mediumSpeedPercent = 66
        speed.lowSpeedColor = Color.RED
        speed.mediumSpeedColor = Color.YELLOW
        speed.highSpeedColor = Color.GREEN

        viewModel.cis.observe(
            viewLifecycleOwner,
            {

                when (it.status) {
                    Status.SUCCESS -> {
                        adapter = DashboardAdapter(this.requireContext(), ArrayList(it.data!!))
                        spinner.adapter = adapter
                    }
                    Status.LOADING -> {
                        showLoading(true)
                    }
                    Status.ERROR -> {
                        showLoading(false)
                    }
                }
            }
        )

        spinner.setSelection(selectedCI)
        /*spinnerrmi.setOnItemSelectedListener(
            object : OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val clickedItem: RoadMapItem =
                        parent?.getItemAtPosition(position) as RoadMapItem
                    val clickedText: String = clickedItem.title
                    Toast.makeText(
                        context,
                        "$clickedText selected",
                        Toast.LENGTH_SHORT
                    ).show()
                    // showCharts(clickedItem)
                    viewModel.fi.observe(
                        viewLifecycleOwner,
                        {
                            speed.speedTo(it.toFloat())
                        }
                    )
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        )*/

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val clickedItem: ChangeInitiative =
                    parent?.getItemAtPosition(position) as ChangeInitiative
                val clickedText: String = clickedItem.title
                Toast.makeText(
                    context,
                    "$clickedText selected",
                    Toast.LENGTH_SHORT
                ).show()
                viewModel.chosenCIId = clickedItem.id
                selectedChange = clickedItem
                refreshVM()
                viewModel.fi.observe(
                    viewLifecycleOwner,
                    {
                        speed.speedTo(it.toFloat())
                    }
                )
                showLoading(false)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        viewModel.navigateToGraph.observe(
            viewLifecycleOwner,
            {
                if (it) {
                    val navController = binding.root.findNavController()
                    selectedCI = spinner.selectedItemPosition
                    navController.navigate(
                        DashboardFragmentDirections.actionDashboardFragmentToDashboardGraphFragment(
                            spinner.selectedItem as ChangeInitiative
                        )
                    )
                    viewModel.onNavigatedToGraph()
                }
            }
        )

        setHasOptionsMenu(true)

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.dashboard_title)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.infoFragment -> findNavController().navigate(DashboardFragmentDirections.actionGlobalChangeInitiativeFragment(selectedChange, true))
            R.id.websiteFragment -> {
                val uri: Uri = Uri.parse(getString(R.string.essentials_website_link))
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun refreshVM() {
        viewModel.fillDashboard()
    }

    fun showLoading(b: Boolean) {
        if (b) {
            if (!loadingDialogFragment.isAdded) {
                loadingDialogFragment.show(requireActivity().supportFragmentManager, "loader")
            }
        } else {
            loadingDialogFragment.dismissAllowingStateLoss()
        }
    }
}
