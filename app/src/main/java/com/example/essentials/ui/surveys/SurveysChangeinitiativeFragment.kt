package com.example.essentials.ui.surveys

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.essentials.R
import com.example.essentials.databinding.SurveysChangeinitiativeBinding

class SurveysChangeinitiativeFragment : Fragment() {

    lateinit var viewModel: SurveysChangeinitiativeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: SurveysChangeinitiativeBinding =
            DataBindingUtil.inflate(inflater, R.layout.surveys_changeinitiative, container, false)

        viewModel = ViewModelProvider(this).get(SurveysChangeinitiativeViewModel::class.java)

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        val manager = LinearLayoutManager(activity)

        binding.surveysCISummary.layoutManager = manager

        val adapter = SurveysChangeinitiativeAdapter(
            SurveyListner { survey ->
                viewModel.onSurveyClicked(survey)
            }
        )

        viewModel.navigateToSurvey.observe(
            viewLifecycleOwner, { survey ->
                survey?.let {
                    this.findNavController().navigate(
                        SurveysChangeinitiativeFragmentDirections.actionSurveysChangeinitiativeFragmentToSurveyQuestionFragement(
                            survey
                        )
                    )
                    viewModel.onSurveyNavigated()
                }
            }
        )

        binding.surveysCISummary.adapter = adapter

        adapter.submitList(viewModel.changeInitiative.surveys)

        (activity as AppCompatActivity).supportActionBar?.title = viewModel.changeInitiative.title
        return binding.root
    }
}
