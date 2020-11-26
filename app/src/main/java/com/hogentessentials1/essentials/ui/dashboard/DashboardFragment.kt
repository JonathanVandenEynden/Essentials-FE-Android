package com.hogentessentials1.essentials.ui.dashboard

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.RoadmapItem
import com.hogentessentials1.essentials.databinding.FragmentDashboardBinding


/**
 *
 * @author Marbod Naassens
 *
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {
    private lateinit var ciList: ArrayList<ChangeInitiative>
    private lateinit var rmiList: ArrayList<RoadmapItem>
    lateinit var viewModel: DashboardViewModel
    private lateinit var adapter: DashboardAdapter
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

        ciList = viewModel.changeInitiatives
        rmiList = viewModel.roadmapItems

        val adapter = context?.let { DashboardAdapter(it, ciList) }
        spinner.adapter = adapter
        val rmiAdapter = context?.let { DashboardRMIAdapter(it, rmiList) }
        spinnerrmi.adapter = rmiAdapter

        spinnerrmi.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val clickedItem: RoadmapItem = parent.getItemAtPosition(position) as RoadmapItem
                val clickedText: String = clickedItem.title
                Toast.makeText(
                    context,
                    "$clickedText selected",
                    Toast.LENGTH_SHORT
                ).show()
                //showCharts(clickedItem)
                speed.speedTo((((clickedItem.survey.questions.size - 1).toFloat()/clickedItem.survey.questions.size) *100));
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

        spinner.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val clickedItem: ChangeInitiative = parent.getItemAtPosition(position) as ChangeInitiative
                val clickedText: String = clickedItem.title
                Toast.makeText(
                    context,
                    "$clickedText selected",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        })

        (activity as AppCompatActivity).supportActionBar?.title = "Dashboard"

        return binding.root
    }

    fun showCharts(item: RoadmapItem)
    {
        /*val chart = binding.chart

        val data = PieData(getDataSet(item))
        chart.data = data
        chart.description.text =  "Surveys"
        chart.animateXY(2000, 2000)
        chart.invalidate()*/
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun getDataSet(item: RoadmapItem): PieDataSet {
        val length = item.survey.questions.size;
        val valueSet1 = ArrayList<PieEntry>()
        val v1e1 = PieEntry(10f, "Filled in") // Jan
        valueSet1.add(v1e1)
        val v1e2 = PieEntry(60f, "Happy") // Feb
        valueSet1.add(v1e2)
        val v1e3 = PieEntry(5f, "Amazed") // Mar
        valueSet1.add(v1e3)
        val v1e4 = PieEntry(25f, "Indifferent") // Apr
        valueSet1.add(v1e4)
        val v1e5 = BarEntry(90.000f, 4f) // May

        val dataSet1 = PieDataSet(valueSet1, "Overal Mood")
        dataSet1.setColors(*ColorTemplate.COLORFUL_COLORS)
        return dataSet1
    }

}
