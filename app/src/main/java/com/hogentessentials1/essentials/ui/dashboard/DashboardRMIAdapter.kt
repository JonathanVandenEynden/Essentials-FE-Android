package com.hogentessentials1.essentials.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hogentessentials1.essentials.R
import com.hogentessentials1.essentials.data.model.ChangeInitiative
import com.hogentessentials1.essentials.data.model.RoadmapItem
import com.hogentessentials1.essentials.databinding.ChangeInitiativeListItemBinding
import com.hogentessentials1.essentials.ui.changeInitiatives.ChangeInitiativeListener
import kotlinx.android.synthetic.main.fragment_dashboard_spinner_item.view.*

/**
 * @author Marbod Naassens
 */
class DashboardRMIAdapter(context: Context, list: ArrayList<RoadmapItem>) :
    ArrayAdapter<RoadmapItem>(context, 0, list) {
    var list: ArrayList<RoadmapItem>
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

    fun initView(position: Int, convertView: View?, parent: ViewGroup): View{
        var view: View
        if (convertView == null)
        {
            view = LayoutInflater.from(context).inflate(
                R.layout.fragment_dashboard_spinner_item, parent, false
            )
        }
        else
        {
            view = convertView
        }
        val textViewName = view.findViewById<TextView>(R.id.spinner_text)
        val currentItem = getItem(position)

        if (currentItem != null) {
            textViewName.setText(currentItem.title)
        };

        return view
    }
}

class RoadmapItemDiffCallback : DiffUtil.ItemCallback<RoadmapItem>() {
    override fun areItemsTheSame(oldItem: RoadmapItem, newItem: RoadmapItem): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: RoadmapItem, newItem: RoadmapItem): Boolean {
        return oldItem == newItem
    }
}

class DashboardRMIListener(val clickListener: (changeInitiative: ChangeInitiative) -> Unit) {
    fun onClick(changeInitiative: ChangeInitiative) = clickListener(changeInitiative)
}
