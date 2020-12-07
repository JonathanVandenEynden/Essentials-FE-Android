package com.hogentessentials1.essentials.ui.dashboard

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.anastr.speedviewlib.Speedometer
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.Question
import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.databinding.FragmentDashboardBinding
import com.hogentessentials1.essentials.ui.homeScreen.HomeScreenFragmentDirections
import com.hogentessentials1.essentials.ui.surveys.AllSurveysViewModel
import org.koin.android.ext.android.inject
import timber.log.Timber


/**
 *
 * @author Marbod Naassens
 *
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {
    private var ciList: ArrayList<ChangeInitiative> = arrayListOf()
    private var rmiList: ArrayList<RoadMapItem> = arrayListOf()
    private var selectedCI: Int = 0
    private var selectedRMI: Int = 0
    //lateinit var viewModel: DashboardViewModel
    private lateinit var binding: FragmentDashboardBinding
    val viewModel: DashboardViewModel by inject()
    lateinit var adapter: DashboardAdapter
    lateinit var rmiAdapter: DashboardRMIAdapter
    lateinit var spinner: Spinner
    lateinit var spinnerrmi: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_dashboard,
            container,
            false
        )
        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        val spinner = binding.spinnerCi
        val spinnerrmi = binding.spinnerRmi
        val speed = binding.speedView
        speed.unit = "% of Surveys filled in"
        speed.isWithTremble = false
        speed.setMaxSpeed(100);
        speed.lowSpeedPercent = 33;
        speed.mediumSpeedPercent = 66;
        speed.lowSpeedColor = Color.RED
        speed.mediumSpeedColor = Color.YELLOW
        speed.highSpeedColor = Color.GREEN

        val manager = LinearLayoutManager(activity)

        //ciList = ArrayList(viewModel.changeInitiatives)
        viewModel.cis.observe(viewLifecycleOwner, Observer {
            Timber.e("test1")
            adapter = DashboardAdapter(this.requireContext(), ArrayList(it))
            spinner.adapter = adapter
            Timber.e("Test2")
        })
        //rmiList = ArrayList(viewModel.roadMapItems)
        /*this.viewModel.rmis.observe(viewLifecycleOwner, Observer {
            rmiAdapter = DashboardRMIAdapter(this.requireContext(), ArrayList(it))
            spinnerrmi.adapter = rmiAdapter
        })*/
        Timber.e("Test3")
        spinner.setSelection(selectedCI)
        Timber.e("Test4")
        spinnerrmi.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val clickedItem: RoadMapItem = parent?.getItemAtPosition(position) as RoadMapItem
                val clickedText: String = clickedItem.title
                Toast.makeText(
                    context,
                    "$clickedText selected",
                    Toast.LENGTH_SHORT
                ).show()
                //showCharts(clickedItem)
                var amount_filledIn: Double = 0.0;
                viewModel.fi.observe(viewLifecycleOwner, Observer {
                    amount_filledIn = it
                    speed.speedTo(it.toFloat())
                })

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

        spinner.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val clickedItem: ChangeInitiative = parent?.getItemAtPosition(position) as ChangeInitiative
                val clickedText: String = clickedItem.title
                Toast.makeText(
                    context,
                    "$clickedText selected",
                    Toast.LENGTH_SHORT
                ).show()
                viewModel.chosenCIId = clickedItem.id
                refreshVM()
                rmiAdapter = DashboardRMIAdapter(parent.context, ArrayList(clickedItem.roadMap.toList()))
                spinnerrmi.adapter = rmiAdapter
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

        spinnerrmi.setSelection(selectedRMI)

        viewModel.navigateToGraph.observe(
            viewLifecycleOwner,
            {
                if (it) {
                    val navController = binding.root.findNavController()
                    selectedCI = spinner.selectedItemPosition
                    Timber.e(spinner.selectedItem.toString())
                    Timber.e(selectedCI.toString())
                    selectedRMI = spinnerrmi.selectedItemPosition
                    navController.navigate(
                        DashboardFragmentDirections.actionDashboardFragmentToDashboardGraphFragment(
                            spinner.selectedItem as ChangeInitiative, spinnerrmi.selectedItem as RoadMapItem
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

    fun refreshVM()
    {
        viewModel.fillDashboard()
    }


}
