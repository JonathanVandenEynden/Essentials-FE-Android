package com.hogentessentials.essentials.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.hogentessentials.essentials.R
import com.hogentessentials.essentials.data.model.ChangeInitiative

/**
 * @author Marbod Naassens
 */
class DashboardAdapter(context: Context, list: ArrayList<ChangeInitiative>) :
    ArrayAdapter<ChangeInitiative>(context, 0, list) {
    var list: ArrayList<ChangeInitiative>
    var vi: LayoutInflater

    init {
        this.list = list
        this.vi = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(
                R.layout.fragment_dashboard_spinner_item,
                parent,
                false
            )
        } else {
            view = convertView
        }
        val textViewName = view.findViewById<TextView>(R.id.spinner_text)
        val currentItem = getItem(position)

        if (currentItem != null) {
            textViewName.setText(currentItem.title)
        }

        return view
    }
}

class ChangeInitiativeDiffCallback : DiffUtil.ItemCallback<ChangeInitiative>() {
    override fun areItemsTheSame(oldItem: ChangeInitiative, newItem: ChangeInitiative): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ChangeInitiative, newItem: ChangeInitiative): Boolean {
        return oldItem == newItem
    }
}

class DashboardListener(val clickListener: (changeInitiative: ChangeInitiative) -> Unit) {
    fun onClick(changeInitiative: ChangeInitiative) = clickListener(changeInitiative)
}
