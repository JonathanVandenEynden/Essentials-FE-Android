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
import com.hogentessentials1.essentials.data.model.Question
import com.hogentessentials1.essentials.databinding.SurveyQuestionBinding
import timber.log.Timber

/**
 * @author Ziggy Moens
 */

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

    private var questions: ArrayList<Question> = arrayListOf()
    private lateinit var binding: SurveyQuestionBinding
    lateinit var currentQuestion: Question
    private lateinit var option0: String
    private lateinit var option5: String
    private var questionIndex = 0
    private var numberOfQuestions = 0
    private var ratingIsGiven = false

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

        val args = SurveyQuestionFragementArgs.fromBundle(requireArguments())
        val roadMapItem = args.roadmapitem
        binding.surveyQuestion.text = roadMapItem.assessment.toString()

        Timber.e(roadMapItem.assessment.toString())
        Timber.e(roadMapItem.toString())
        binding.nextQuestion.setOnClickListener { view: View ->
            view.findNavController().navigate(
                SurveyQuestionFragementDirections.actionSurveyQuestionFragmentToSurveyEndFragment(
                    roadMapItem
                )
            )
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
        return binding.root
    }

    private fun ratingGiven() {
        ratingIsGiven = true
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        questionIndex++
//        option0 = currentQuestion.option0
//        option5 = currentQuestion.option5
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.title_survey_question, questionIndex + 1, numberOfQuestions)
    }
}
