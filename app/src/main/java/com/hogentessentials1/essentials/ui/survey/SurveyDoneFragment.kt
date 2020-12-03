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
import com.hogentessentials1.essentials.databinding.SurveyEndBinding
import com.hsalf.smileyrating.SmileyRating
import org.koin.android.ext.android.inject

/**
 * @author Ziggy Moens
 */
class SurveyDoneFragment : Fragment() {
    private lateinit var viewModel: SurveyDoneViewModel
    private lateinit var answer: String

    fun getViewModel(): SurveyDoneViewModel {
        val viewModel: SurveyDoneViewModel by inject()
        return viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val args = SurveyDoneFragmentArgs.fromBundle(requireArguments())
        val roadMapItem = args.roadmapitem

        val binding: SurveyEndBinding =
            DataBindingUtil.inflate(inflater, R.layout.survey_end, container, false)
        binding.surveyDoneButton.setOnClickListener { view: View ->
            val smiley: SmileyRating.Type = binding.feedbackRating.getSelectedSmiley()
            val rating: Int = smiley.getRating()

            answer = rating.toString()

            viewModel.answer(roadMapItem.assessment!!.feedback?.id!!.toInt(), answer)

            view.findNavController().navigate(
                SurveyDoneFragmentDirections.actionSurveyDoneFragmentToHomeScreenFragment()
            )
        }

        viewModel = getViewModel()

        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.survey_finished)
        return binding.root
    }
}
