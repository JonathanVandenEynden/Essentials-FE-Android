package com.hogentessentials1.essentials.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.ChangeInitiative

/**
 * adapter class to create dashboards
 * @author Marbod Naassens
 */
class DashboardAdapter(context: Context, var list: ArrayList<ChangeInitiative>) :
    ArrayAdapter<ChangeInitiative>(context, 0, list) {
    private var vi: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView
            ?: LayoutInflater.from(context).inflate(
                R.layout.fragment_dashboard_spinner_item,
                parent,
                false
            )
        val textViewName = view.findViewById<TextView>(R.id.spinner_text)
        val currentItem = getItem(position)

        if (currentItem != null) {
            textViewName.text = currentItem.title
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
