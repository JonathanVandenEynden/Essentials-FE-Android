package com.hogentessentials1.essentials.ui.dashboard

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
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
import timber.log.Timber

/**
 * fragment for dashboards
 * @author Marbod Naassens
 */
class DashboardFragment : Fragment() {
    private var ciList: ArrayList<ChangeInitiative> = arrayListOf()
    // private var rmiList: ArrayList<RoadMapItem> = arrayListOf()
    private var selectedCI: Int = 0
    // private var selectedRMI: Int = 0

    // lateinit var viewModel: DashboardViewModel
    private lateinit var binding: FragmentDashboardBinding
    val viewModel: DashboardViewModel by inject()
    lateinit var adapter: DashboardAdapter
    // lateinit var rmiAdapter: DashboardRMIAdapter
    lateinit var spinner: Spinner
    // lateinit var spinnerrmi: Spinner
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
        // val spinnerrmi = binding.spinnerRmi
        val speed = binding.speedView
        speed.unit = "% of Surveys filled in"
        speed.isWithTremble = false
        speed.maxSpeed = 100
        speed.lowSpeedPercent = 33
        speed.mediumSpeedPercent = 66
        speed.lowSpeedColor = Color.RED
        speed.mediumSpeedColor = Color.YELLOW
        speed.highSpeedColor = Color.GREEN

        // ciList = ArrayList(viewModel.changeInitiatives)
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
        // rmiList = ArrayList(viewModel.roadMapItems)
        /*this.viewModel.rmis.observe(viewLifecycleOwner, Observer {
            rmiAdapter = DashboardRMIAdapter(this.requireContext(), ArrayList(it))
            spinnerrmi.adapter = rmiAdapter
        })*/
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

        spinner.setOnItemSelectedListener(
            object : OnItemSelectedListener {
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
                    refreshVM()
                    /*rmiAdapter =
                        DashboardRMIAdapter(parent.context, ArrayList(clickedItem.roadMap.toList()))
                    spinnerrmi.adapter = rmiAdapter*/
                    viewModel.fi.observe(
                        viewLifecycleOwner,
                        {
                            speed.speedTo(it.toFloat())
                        }
                    )
                    showLoading(false)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            })

        // spinnerrmi.setSelection(selectedRMI)

        viewModel.navigateToGraph.observe(
            viewLifecycleOwner,
            {
                if (it) {
                    val navController = binding.root.findNavController()
                    selectedCI = spinner.selectedItemPosition
                    Timber.e(spinner.selectedItem.toString())
                    Timber.e(selectedCI.toString())
                    // selectedRMI = spinnerrmi.selectedItemPosition
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

        (activity as AppCompatActivity).supportActionBar?.title = "Dashboard"

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.infoFragment -> this.findNavController().navigate(R.id.homeScreenFragment)
            R.id.websiteFragment -> {
                val uri: Uri = Uri.parse("https://essentialstoolkit.netlify.app/")
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
            // if (loadingDialogFragment.isAdded) {
            loadingDialogFragment.dismissAllowingStateLoss()
            // }
        }
    }
}
