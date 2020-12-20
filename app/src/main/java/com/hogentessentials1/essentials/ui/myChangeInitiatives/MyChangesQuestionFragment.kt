package com.hogentessentials1.essentials.ui.myChangeInitiatives

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TableRow
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.Question
import com.hogentessentials1.essentials.databinding.FragmentMychangeQuestionBinding

/**
 * Fragment for the detail of a survey
 * @author Sébastien De Pauw
 */

class MyChangesQuestionFragment : Fragment() {
    private lateinit var question: Question

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentMychangeQuestionBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_mychange_question, container, false)

        val args = MyChangesQuestionFragmentArgs.fromBundle(requireArguments())
        question = args.question

        val viewModel = ViewModelProvider(this).get(MyChangesQuestionViewModel::class.java)

        val amountFilledIn = question.questionRegistered!!.size

        binding.myChangeQuestion.text = question.questionString

        val ll = binding.myChangeTable

        question.possibleAnswers.forEach { (k, v) ->
            val tr = TableRow(activity)
            val tAnswer = TextView(activity)
            val tTimesChosen = TextView(activity)
            if (amountFilledIn == 0) {
                tTimesChosen.text = "0 %"
            } else {
                tTimesChosen.text = getString(R.string.chosen_perc, (v / amountFilledIn * 100).toString())
            }
            if (question.type.toInt() == 1) {
                val stars = RatingBar(activity)
                stars.rating = k.toFloat()
                stars.numStars = 5
                stars.setIsIndicator(true)
                tr.addView(stars, TableRow.LayoutParams(240, 120))
                val lp = TableRow.LayoutParams(110, 120)
                lp.gravity = Gravity.CENTER
                tr.addView(tTimesChosen, lp)
            } else if (question.type.toInt() == 2) {
                tAnswer.text = k
                tr.addView(tAnswer, TableRow.LayoutParams(240, 50))
                val lp = TableRow.LayoutParams(110, 50)
                lp.gravity = Gravity.CENTER
                tr.addView(tTimesChosen, lp)
            }

            ll.addView(tr)
        }

        viewModel.question = question

        binding.viewModel = viewModel

        return binding.root
    }
}
