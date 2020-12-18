package com.hogentessentials1.essentials.ui.survey

import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.button.MaterialButton
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.Question
import com.hogentessentials1.essentials.data.model.RoadMapItem
import com.hogentessentials1.essentials.databinding.SurveyQuestionBinding
import com.hogentessentials1.essentials.ui.roadMap.RoadMapFragmentDirections
import kotlinx.android.synthetic.main.survey_question.*
import kotlinx.android.synthetic.main.survey_question.view.*
import org.koin.android.ext.android.inject

/**
 * fragement for a question
 *
 * @author Ziggy Moens
 */

@Suppress("DEPRECATION")
class SurveyQuestionFragement : Fragment() {

    private var questions: List<Question> = arrayListOf()
    private lateinit var roadMapItem: RoadMapItem
    private lateinit var binding: SurveyQuestionBinding
    lateinit var currentQuestion: Question
    private var questionIndex = 0
    private var numberOfQuestions = 0
    private var errorOccured = false
    private lateinit var answer: String

    private lateinit var viewModel: SurveyQuestionViewModel

    fun getViewModel(): SurveyQuestionViewModel {
        val viewModel: SurveyQuestionViewModel by inject()
        return viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate<SurveyQuestionBinding>(
            inflater,
            R.layout.survey_question,
            container,
            false
        )
        viewModel = getViewModel()
        val args = SurveyQuestionFragementArgs.fromBundle(requireArguments())
        roadMapItem = args.roadmapitem
        questions = roadMapItem.assessment!!.questions

        binding.currentQuestion = this
        numberOfQuestions = questions.size

        setQuestion()

        binding.nextQuestion.setOnClickListener { _: View ->
            handleNextQuestion()
        }
        return binding.root
    }

    private fun getAsnwer(): String {
        var answer = ""
        if (currentQuestion.type == "1") {
            answer = ratingBar_question.rating.toString()
        } else if (currentQuestion.type == "3") {
            answer = open_question_text.text.toString()
        }
        return answer
    }

    private fun setContent() {
        binding.yesnoQuestion.visibility = View.INVISIBLE
        binding.ratingBarQuestion.visibility = View.INVISIBLE
        binding.mcQuestion.visibility = View.INVISIBLE
        binding.openQuestion.visibility = View.INVISIBLE
        if (currentQuestion.type == "0") {
            binding.yesnoQuestion.visibility = View.VISIBLE
            binding.yesButton.setOnClickListener { view: View ->
                answer = "true"
                view.setBackgroundColor(resources.getColor(R.color.selected_brown))
                no_button.setBackgroundColor(resources.getColor(R.color.white))
            }
            binding.noButton.setOnClickListener { view: View ->
                answer = "false"
                view.setBackgroundColor(resources.getColor(R.color.selected_brown))
                yes_button.setBackgroundColor(resources.getColor(R.color.white))
            }
        } else if (currentQuestion.type == "1") {
            binding.ratingBarQuestion.visibility = View.VISIBLE
        } else if (currentQuestion.type == "2") {
            binding.mcQuestion.visibility = View.VISIBLE

            for (x in currentQuestion.possibleAnswers.keys) {
                val r =
                    context?.let { MaterialButton(ContextThemeWrapper(it, R.style.button_style)) }
                r?.let {
                    r.setBackgroundColor(resources.getColor(R.color.white))
                    r.text = x
                    r.width = Int.MAX_VALUE
                    r.setTextColor(resources.getColor(R.color.black))
                    r.setOnClickListener { view: View ->
                        for (b in binding.mcQuestion.children) {
                            b.setBackgroundColor(resources.getColor(R.color.white))
                        }
                        answer = x
                        view.setBackgroundColor(resources.getColor(R.color.selected_brown))
                    }
                }
                binding.mcQuestion.mc_question.addView(r)
            }
        } else if (currentQuestion.type == "3") {
            binding.openQuestion.visibility = View.VISIBLE
        }
        binding.surveyQuestion.text = currentQuestion.questionString
    }

    private fun handleNextQuestion() {
        if (currentQuestion.type != "0" && currentQuestion.type != "2") {
            answer = getAsnwer()
        }
        viewModel.answer(currentQuestion.id.toInt(), answer)
        if (questionIndex < numberOfQuestions) {
            currentQuestion = questions[questionIndex]
            setQuestion()
            binding.invalidateAll()
        } else {
            view?.findNavController()?.navigate(
                SurveyQuestionFragementDirections.actionSurveyQuestionFragmentToSurveyEndFragment(
                    roadMapItem
                )
            )
        }
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.title_survey_question, questionIndex + 1, numberOfQuestions)
        questionIndex++
        setContent()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (errorOccured) {
            view?.findNavController()
                ?.navigate(RoadMapFragmentDirections.actionRoadMapFragmentToNotFoundFragment())
        }
    }
}

/*Timber.e(roadMapItem.assessment.toString())
try {
val questions = roadMapItem.assessment!!.questions
numberOfQuestions = questions.size


binding.currentQuestion = this
setQuestion()

binding.ratingBarQuestion.setOnRatingBarChangeListener { _, _, _ ->
    (ratingGiven())
}

binding.nextQuestion.setOnClickListener { view: View ->
    // if (ratingIsGiven) {
    //currentQuestion.answer = binding.ratingBarQuestion.rating.toDouble()
    if (questionIndex < numberOfQuestions) {
        currentQuestion = questions[questionIndex]
        setQuestion()
        binding.ratingBarQuestion.rating = 0.0F
        binding.invalidateAll()
    } else {
        view.findNavController().navigate(
            SurveyQuestionFragementDirections.actionSurveyQuestionFragmentToSurveyEndFragment(
                roadMapItem
            )
        )
    }

    // }
*/
