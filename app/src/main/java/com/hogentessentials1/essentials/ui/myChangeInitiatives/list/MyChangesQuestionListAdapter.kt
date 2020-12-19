package com.hogentessentials1.essentials.ui.myChangeInitiatives.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hogentessentials1.essentials.data.model.Question
import com.hogentessentials1.essentials.databinding.FragmentMychangeQuestionsListitemBinding

/**
 * @author Sébastien De Pauw
 */

class MyChangesQuestionListAdapter(val clickListener: MyChangesQuestionListener) : ListAdapter<Question, MyChangesQuestionListAdapter.ViewHolder>(MyChangesQuestionDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(clickListener, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: FragmentMychangeQuestionsListitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: MyChangesQuestionListener, item: Question) {
            binding.question = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    FragmentMychangeQuestionsListitemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class MyChangesQuestionDiffCallback : DiffUtil.ItemCallback<Question>() {
    override fun areItemsTheSame(oldItem: Question, newItem: Question): Boolean {
        return oldItem.questionString == newItem.questionString
    }

    override fun areContentsTheSame(oldItem: Question, newItem: Question): Boolean {
        return oldItem == newItem
    }
}

class MyChangesQuestionListener(val clickListener: (question: Question) -> Unit) {
    fun onClick(question: Question) = clickListener(question)
}
