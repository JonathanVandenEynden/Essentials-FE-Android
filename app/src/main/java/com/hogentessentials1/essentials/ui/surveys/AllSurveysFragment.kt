package com.hogentessentials1.essentials.ui.surveys

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.databinding.AllSurveysBinding
import org.koin.android.ext.android.inject

/**
 * @author Ziggy Moens
 */
class AllSurveysFragment : Fragment() {

    lateinit var viewModel: AllSurveysViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: AllSurveysBinding =
            DataBindingUtil.inflate(inflater, R.layout.all_surveys, container, false)

        val viewModel: AllSurveysViewModel by inject()
//        viewModel = ViewModelProvider(this).get(AllSurveysViewModel::class.java)

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        val manager = LinearLayoutManager(activity)

        binding.allSurveysSummary.layoutManager = manager

        val adapter = AllSurveysAdapter(
            AllSurveyListener { survey ->
                viewModel.onSurveyClicked(survey)
            }
        )

        viewModel.navigateToSurvey.observe(
            viewLifecycleOwner,
            { survey ->
                survey?.let {
                    this.findNavController().navigate(
                        AllSurveysFragmentDirections.actionAllSurveysFragmentToSurveyQuestionFragment(
                            survey
                        )
                    )
                    viewModel.onSurveyNavigated()
                }
            }
        )

        binding.allSurveysSummary.adapter = adapter

        adapter.submitList(viewModel.surveys)

        (activity as AppCompatActivity).supportActionBar?.title = "All surveys"
        return binding.root
    }
}
