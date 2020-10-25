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
import com.example.essentials.data.model.SurveyQuestion
import com.example.essentials.databinding.SurveyQuestionBinding

class SurveyQuestionFragement : Fragment() {
    /*private val questions: MutableList<SurveyQuestion> = mutableListOf(
        SurveyQuestion(
            question = "What do you think of the new food?",
            option0 = "uneatable",
            option5 = "delicious"
        ),
        SurveyQuestion(
            question = "What do you think of the personnel working in the new cafeteria",
            option0 = "unfriendly",
            option5 = "friendly"
        )
    )*/

    private var questions: ArrayList<SurveyQuestion> = arrayListOf()
    lateinit var currentQuestion: SurveyQuestion
    lateinit var option0: String
    lateinit var option5: String
    private var questionIndex = 0
    private var numberOfQuestions = 0
    private var ratingIsGiven = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = SurveyQuestionFragementArgs.fromBundle(requireArguments())
        questions = args.survey.questions
        numberOfQuestions = questions.size
        val binding = DataBindingUtil.inflate<SurveyQuestionBinding>(
            inflater,
            R.layout.survey_question,
            container,
            false
        )

        binding.currentQuestion = this
        setQuestion()

        binding.ratingBarQuestion.setOnRatingBarChangeListener { _, _, _ ->
            (ratingGiven())
        }

        binding.nextQuestion.setOnClickListener { view: View ->
            if (ratingIsGiven) {
                currentQuestion.answer = binding.ratingBarQuestion.rating.toDouble()
                questionIndex++
                if (questionIndex < numberOfQuestions) {
                    currentQuestion = questions[questionIndex]
                    setQuestion()
                    binding.ratingBarQuestion.rating = 0.0F
                    binding.invalidateAll()
                } else {
                    view.findNavController().navigate(
                        SurveyQuestionFragementDirections.actionSurveyQuestionFragementToSurveyDoneFragment(
                            questions.toTypedArray()
                        )
                    )
                }
            }
        }

        return binding.root
    }

    private fun ratingGiven() {
        ratingIsGiven = true
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        option0 = currentQuestion.option0
        option5 = currentQuestion.option5
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.title_survey_question, questionIndex + 1, numberOfQuestions)
    }
}
