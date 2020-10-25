package com.example.essentials.ui.surveys

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.essentials.data.model.Survey
import com.example.essentials.databinding.SurveysChangeinitiativeListitemBinding

class SurveysChangeinitiativeAdapter(val clickListener: SurveyListner) :
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

        fun bind(clickListener: SurveyListner, item: Survey) {
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
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Survey, newItem: Survey): Boolean {
        return oldItem == newItem
    }
}

class SurveyListner(val clickListener: (survey: Survey) -> Unit) {
    fun onClick(survey: Survey) = clickListener(survey)
}
