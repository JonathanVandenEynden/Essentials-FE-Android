package com.example.essentials.ui.surveys

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.essentials.R
import com.example.essentials.databinding.SurveyDoneBinding

class SurveyDoneFragment : Fragment() {
    lateinit var summary: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: SurveyDoneBinding =
            DataBindingUtil.inflate(inflater, R.layout.survey_done, container, false)
        binding.surveyDoneButton.setOnClickListener { view: View ->
            view.findNavController().navigate(
                SurveyDoneFragmentDirections.actionSurveyDoneFragmentToHomeScreenFragment()
            )
        }
        binding.surveyDone = this

        val args = SurveyDoneFragmentArgs.fromBundle(requireArguments())
        val questions = args.questions

        var ret = "Your answers: \n"

        for (q in questions) {
            ret += q.question + ": " + q.answer.toString() + "/5\n"
        }
        summary = ret

        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.survey_finished)
        return binding.root
    }
}
