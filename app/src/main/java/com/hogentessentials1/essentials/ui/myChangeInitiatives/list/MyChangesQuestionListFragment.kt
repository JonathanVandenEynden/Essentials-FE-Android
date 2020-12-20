package com.hogentessentials1.essentials.ui.myChangeInitiatives.list

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.Question
import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.databinding.FragmentMychangeSurveyBinding
import org.koin.android.ext.android.inject
import kotlin.math.floor

/**
 * @author Sébastien De Pauw
 */

class MyChangesQuestionListFragment : Fragment() {

    lateinit var viewModel: MyChangesQuestionListViewModel

    private var questions: List<Question> = arrayListOf()

    private lateinit var binding: FragmentMychangeSurveyBinding

    fun viewModel(): MyChangesQuestionListViewModel {
        val viewModel: MyChangesQuestionListViewModel by inject()
        return viewModel
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_mychange_survey,
            container,
            false
        )

        viewModel = viewModel()

        val args = MyChangesQuestionListFragmentArgs.fromBundle(requireArguments())
        val roadmapItem: RoadMapItem = args.roadMapItem

        questions = roadmapItem.assessment!!.questions

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        val manager = LinearLayoutManager(activity)

        binding.questionList.layoutManager = manager

        val adapter = MyChangesQuestionListAdapter(
            MyChangesQuestionListener { q ->
                viewModel.onQuestionClicked(q)
            }
        )

        viewModel.navigateToQuestion.observe(
            viewLifecycleOwner,
            { q ->
                q?.let {
                    this.findNavController().navigate(
                        MyChangesQuestionListFragmentDirections.actionMyChangesQuestionListFragmentToMyChangesFragment(
                            q
                        )
                    )
                    viewModel.onQuestionNavigated()
                }
            }
        )

        binding.questionList.adapter = adapter

        var meanFeedback = 0.0
        roadmapItem.assessment.feedback?.possibleAnswers?.forEach { (_, v) -> meanFeedback += v }
        if (meanFeedback != 0.0) {
            meanFeedback /= roadmapItem.assessment.feedback?.possibleAnswers?.size!!
            binding.surveyAveragemoodTextviewId.text = getString(R.string.Overall_happiness_applicable, calculatePercent(meanFeedback))
            // "Overall happiness: " + calculatePercent(meanFeedback)
        } else {
            binding.surveyAveragemoodTextviewId.text = getString(R.string.Overall_happiness_not_applicable)
        }

        binding.surveyAveragemoodImageviewId.setImageResource(
            when (floor(meanFeedback).toInt()) {
                1 -> R.drawable.ic_happiness_1
                2 -> R.drawable.ic_happiness_2
                3 -> R.drawable.ic_happiness_3
                4 -> R.drawable.ic_happiness_4
                5 -> R.drawable.ic_happiness_5
                else -> R.drawable.ic_happiness_none
            }
        )

        adapter.submitList(roadmapItem.assessment.questions.filter { e -> e.type.toInt() != 3 })

        (activity as AppCompatActivity).supportActionBar?.title = roadmapItem.title

        return binding.root
    }

    private fun calculatePercent(meanFeedback: Double): String {
        return when (meanFeedback) {
            -1.0 -> "not yet applicable"
            else -> (meanFeedback / 5 * 100).toString() + " %"
        }
    }
}
