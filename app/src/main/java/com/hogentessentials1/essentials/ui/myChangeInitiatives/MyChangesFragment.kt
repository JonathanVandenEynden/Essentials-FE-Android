package com.hogentessentials1.essentials.ui.myChangeInitiatives

/**
 * @author Sébastien De Pauw
 */

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.SurveyQuestion
import com.hogentessentials1.essentials.databinding.FragmentMychangeSurveysBinding

class MyChangesFragment: Fragment() {

    lateinit var viewModel: MyChangesViewModel
    private lateinit var binding: FragmentMychangeSurveysBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val args = MyChangesFragmentArgs.fromBundle(requireArguments())

        viewModel = ViewModelProvider(this).get(MyChangesViewModel::class.java)
        viewModel.survey = args.survey
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mychange_surveys, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        var meanFeedback: Double = 0.0
        viewModel.survey.feedback.questionRegistered?.forEach { (k,v) -> meanFeedback += v }
        if(meanFeedback != 0.0)
            meanFeedback = meanFeedback/ viewModel.survey.feedback.questionRegistered?.size!!
        binding.surveyAveragemoodImageviewId.setImageResource(when(Math.floor(meanFeedback.toDouble()).toInt()){
            0 -> R.drawable.ic_happiness_0
            1 -> R.drawable.ic_happiness_1
            2 -> R.drawable.ic_happiness_2
            3 -> R.drawable.ic_happiness_3
            4 -> R.drawable.ic_happiness_4
            5 -> R.drawable.ic_happiness_5
            else -> R.drawable.ic_happiness_none
        })
        binding.surveyAveragemoodTextviewId.text = "Overall happiness: " + calculatePercent(meanFeedback)

        (activity as AppCompatActivity).supportActionBar?.title = viewModel.survey.roadMapItem?.title

        val adapter = MyChangesAdapter()
        binding.questionList.adapter = adapter
        adapter.data = viewModel.survey.questions

        return binding.root
    }

    fun calculatePercent(meanFeedback: Double): String {
        var ret = ""
        when(meanFeedback){
            -1.0 -> ret = "not yet applicable"
            else -> ret = (meanFeedback / 5 * 100).toString() + " %"
        }
        return ret
    }
}