package com.hogentessentials1.essentials.ui.changeinitiative

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hogentessentials1.essentials.data.model.Survey
import com.hogentessentials1.essentials.databinding.SurveysChangeinitiativeListitemBinding

/**
 * @author Ziggy Moens
 *
 * Adapter to create a view based on a Survey
 * @param clickListener listener when a survey is tapped
 */

class SurveysChangeinitiativeAdapter(val clickListener: SurveyListener) :
    ListAdapter<Survey, SurveysChangeinitiativeAdapter.ViewHolder>(SurveyDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(clickListener, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: SurveysChangeinitiativeListitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: SurveyListener, item: Survey) {
            binding.survey = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding =
                    SurveysChangeinitiativeListitemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class SurveyDiffCallback : DiffUtil.ItemCallback<Survey>() {
    override fun areItemsTheSame(oldItem: Survey, newItem: Survey): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Survey, newItem: Survey): Boolean {
        return oldItem == newItem
    }
}

class SurveyListener(val clickListener: (survey: Survey) -> Unit) {
    fun onClick(survey: Survey) = clickListener(survey)
}
