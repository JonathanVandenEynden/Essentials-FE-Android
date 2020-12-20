package com.hogentessentials1.essentials.ui.survey

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.databinding.SurveyCompletelyFinishedBinding

/**
 * fragment to show a survey is already filled in
 *
 * @author Ziggy Moens
 *
 *
 */
class SurveyComplete : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: SurveyCompletelyFinishedBinding =
            DataBindingUtil.inflate(inflater, R.layout.survey_completely_finished, container, false)

        binding.surveyDoneButton.setOnClickListener { view: View ->
            view.findNavController().navigate(
                SurveyCompleteDirections.actionSurveyCompleteToHomeScreenFragment()
            )
        }

        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.survey_finished)
        return binding.root
    }
}
