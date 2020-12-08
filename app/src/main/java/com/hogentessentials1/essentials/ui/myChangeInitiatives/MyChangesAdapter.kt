package com.hogentessentials1.essentials.ui.myChangeInitiatives

/**
 * @author Sébastien De Pauw
 */

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.Question
import com.hogentessentials1.essentials.data.model.SurveyQuestion

class MyChangesAdapter : RecyclerView.Adapter<MyChangesAdapter.ViewHolder>(){
     var data =  listOf<Question>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("listSize", data.size.toString())
        val item = data[position]
        holder.question.text = item.questionString
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.fragment_mychange_survey_listitem, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView){
        val question:TextView = itemView.findViewById(R.id.question_string)
    }
}