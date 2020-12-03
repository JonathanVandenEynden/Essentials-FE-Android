package com.hogentessentials1.essentials.ui.surveys

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
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.databinding.SurveysChangeinitiativeBinding

/**
 * @author Ziggy Moens
 */

class SurveysChangeInitiativeFragment : Fragment() {

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

        val args =
            SurveysChangeInitiativeFragmentArgs.fromBundle(requireArguments()) // TODO controle op niet null

        val ci = args.changeInitiative

        viewModel.changeInitiative = ci

        binding.lifecycleOwner = this

        val manager = LinearLayoutManager(activity)

        binding.surveysCISummary.layoutManager = manager

        val adapter = SurveysChangeinitiativeAdapter(
            SurveyListener { survey ->
                viewModel.onSurveyClicked(survey)
            }
        )

        viewModel.navigateToSurvey.observe(
            viewLifecycleOwner,
            { survey ->
                survey?.let {
                    this.findNavController().navigate(
                        SurveysChangeInitiativeFragmentDirections.actionSurveysChangeinitiativeFragmentToSurveyQuestionFragement(
                            survey
                        )
                    )
                    viewModel.onSurveyNavigated()
                }
            }
        )

        binding.surveysCISummary.adapter = adapter

        // adapter.submitList(viewModel.changeInitiative.surveys)

        binding.surveysCIName.text = getString(R.string.ci_screen, viewModel.changeInitiative.title)

//        binding.surveysCISurvey.text = resources.getQuantityString(
//            R.plurals.amount_surveys,
//            viewModel.changeInitiative.surveys.size,
//            viewModel.changeInitiative.surveys.size
//        )

        (activity as AppCompatActivity).supportActionBar?.title = viewModel.changeInitiative.title
        return binding.root
    }
}
