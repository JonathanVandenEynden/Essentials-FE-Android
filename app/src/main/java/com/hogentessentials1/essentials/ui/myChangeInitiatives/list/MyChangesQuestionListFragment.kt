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
import com.hogentessentials1.essentials.databinding.FragmentMychangeQuestionsListitemBinding
import com.hogentessentials1.essentials.databinding.FragmentMychangeSurveyBinding
import com.hogentessentials1.essentials.ui.myChangeInitiatives.list.*
import org.koin.android.ext.android.inject

/**
 * @author Sébastien De Pauw
 */

class MyChangesQuestionListFragment : Fragment() {

    lateinit var viewModel: MyChangesQuestionListViewModel

    private lateinit var binding: FragmentMychangeSurveyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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

        var meanFeedback: Double = 0.0
        roadmapItem.assessment?.feedback?.possibleAnswers?.forEach{(k,v) -> meanFeedback +=  v}
        if(meanFeedback != 0.0){
            meanFeedback = meanFeedback/ roadmapItem.assessment?.feedback?.possibleAnswers?.size!!
            binding.surveyAveragemoodTextviewId.text = "Overall happiness: " + calculatePercent(meanFeedback)
        }
        else{
            binding.surveyAveragemoodTextviewId.text = "Overall happiness: not yet applicable"
        }

        binding.surveyAveragemoodImageviewId.setImageResource(when(Math.floor(meanFeedback.toDouble()).toInt()){
            1 -> R.drawable.ic_happiness_1
            2 -> R.drawable.ic_happiness_2
            3 -> R.drawable.ic_happiness_3
            4 -> R.drawable.ic_happiness_4
            5 -> R.drawable.ic_happiness_5
            else -> R.drawable.ic_happiness_none
        })

        viewModel.getAllQuestions((roadmapItem.assessment?.id)?.toInt())
        viewModel.Questions.observe(
                viewLifecycleOwner,
                {
                    adapter.submitList(it)
                }
            )

        (activity as AppCompatActivity).supportActionBar?.title = roadmapItem.title

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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