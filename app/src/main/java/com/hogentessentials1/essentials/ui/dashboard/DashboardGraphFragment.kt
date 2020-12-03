package com.hogentessentials1.essentials.ui.dashboard

import android.graphics.Color
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.databinding.FragmentDashboardGraphBinding
import org.koin.android.ext.android.inject
import timber.log.Timber

class DashboardGraphFragment : Fragment() {
    // lateinit var viewModel: DashboardViewModel
    private lateinit var binding: FragmentDashboardGraphBinding
    val viewModel: DashboardViewModel by inject()
    var ci: ChangeInitiative? = null
    var rmi: RoadMapItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_dashboard_graph,
            container,
            false
        )
        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        arguments?.getParcelable<ChangeInitiative>("changeInitiative")?.let {
            ci = it
        }
        arguments?.getParcelable<RoadMapItem>("roadMapItem")?.let {
            rmi = it
        }

        if (ci != null && rmi != null) {
            binding.textView2.text = ci?.title
            showCharts(rmi!!)
        }

        setupHyperlink()

        (activity as AppCompatActivity).supportActionBar?.title = "Dashboard"

        return binding.root
    }

    fun showCharts(item: RoadMapItem) {
        val chart = binding.chart
        chart.description.textSize = 20f
        chart.legend.textSize = 15f
        val data = PieData(getDataSet(item))
        chart.data = data
        chart.data.setValueTextSize(15f)
        chart.setEntryLabelTextSize(20f)
        chart.description.text = item.title
        chart.animateXY(2000, 2000)
        chart.invalidate()
    }

    private fun getDataSet(item: RoadMapItem): PieDataSet {
        viewModel.chosenCIId = ci!!.id
        refreshVM()
        var mood: Map<Int, Int> = mapOf()
        viewModel.m.observe(viewLifecycleOwner, { mood = it })
        Timber.e("Test:%s", mood.toString())
        val moods: List<String> =
            listOf("\uD83D\uDE26", "\uD83D\uDE41", "\uD83D\uDE10", "\uD83D\uDE42", "\uD83D\uDE04")
        val valueSet1 = ArrayList<PieEntry>()
        if (!mood.isEmpty()) {
            for (m in mood) {
                val ve = PieEntry(m.value.toFloat(), moods[m.key])
                valueSet1.add(ve)
            }
            val dataSet1 = PieDataSet(valueSet1, "Overal Mood")
            dataSet1.valueTextSize = 20f
            dataSet1.setColors(*ColorTemplate.COLORFUL_COLORS)
            return dataSet1
        }
        val ve = PieEntry(100f, "N/A")
        valueSet1.add(ve)
        val dataSet1 = PieDataSet(valueSet1, "Overal Mood")
        dataSet1.setColors(*ColorTemplate.COLORFUL_COLORS)
        return dataSet1
    }

    fun setupHyperlink() {
        val linkTextView = binding.siteLink
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance())
        linkTextView.setLinkTextColor(Color.BLUE)
    }

    fun refreshVM() {
        viewModel.fillDashboard()
    }
}
