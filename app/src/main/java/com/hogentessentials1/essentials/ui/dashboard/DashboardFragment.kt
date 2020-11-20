package com.hogentessentials1.essentials.ui.dashboard

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.databinding.FragmentDashboardBinding


/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var viewModel: DashboardViewModel

    private lateinit var binding: FragmentDashboardBinding

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

        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        val manager = LinearLayoutManager(activity)

        //binding.ciList.layoutManager = manager

        /*val adapter = ChangeInitiativeAdapter(
            ChangeInitiativeListener { changeInitiative ->
                viewModel.onChangeInitiativeClicked(changeInitiative)
            }
        )

        binding.ciList.adapter = adapter

        adapter.submitList(viewModel.changeInitiatives)*/

        (activity as AppCompatActivity).supportActionBar?.title = "Dashboard"

        val chart = binding.chart as PieChart

        val data = PieData(getDataSet())
        chart.data = data
        chart.description.text =  "My chart"
        chart.animateXY(2000, 2000)
        chart.invalidate()

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun getDataSet(): PieDataSet {
        val valueSet1 = ArrayList<PieEntry>()
        val v1e1 = PieEntry(20f, "Sad") // Jan
        valueSet1.add(v1e1)
        val v1e2 = PieEntry(40f, "Happy") // Feb
        valueSet1.add(v1e2)
        val v1e3 = PieEntry(20f, "Amazed") // Mar
        valueSet1.add(v1e3)
        val v1e4 = PieEntry(20f, "Indifferent") // Apr
        valueSet1.add(v1e4)
        val v1e5 = BarEntry(90.000f, 4f) // May

        val dataSet1 = PieDataSet(valueSet1, "Overal Mood")
        dataSet1.setColors(*ColorTemplate.COLORFUL_COLORS)
        return dataSet1
    }

    private fun getXAxisValues(): ArrayList<String> {
        val xAxis = ArrayList<String>()
        xAxis.add("JAN")
        xAxis.add("FEB")
        xAxis.add("MAR")
        xAxis.add("APR")
        xAxis.add("MAY")
        xAxis.add("JUN")
        return xAxis
    }
}
