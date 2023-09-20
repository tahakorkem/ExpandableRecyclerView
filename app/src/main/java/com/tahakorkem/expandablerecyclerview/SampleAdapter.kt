package com.tahakorkem.expandablerecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.tahakorkem.expandablerecyclerview.adapter.ExpandableRecyclerViewAdapter
import com.tahakorkem.expandablerecyclerview.model.ExpandableChild
import com.tahakorkem.expandablerecyclerview.model.ExpandableGroup
import com.tahakorkem.expandablerecyclerview.model.ExpandableItem
import com.tahakorkem.expandablerecyclerview.viewholder.ExpandableChildViewHolder
import com.tahakorkem.expandablerecyclerview.viewholder.ExpandableGroupViewHolder

class SampleAdapter(data: List<ExpandableGroup>) :
    ExpandableRecyclerViewAdapter<SampleAdapter.SampleGroupViewHolder, SampleAdapter.SampleChildViewHolder>(
        data,
//        Options(collapseOthersOnExpand = false, scrollToGroupOnExpand = true)
    ) {
    inner class SampleGroupViewHolder(v: android.view.View) :
        ExpandableGroupViewHolder(v) {
        private val textViewTitle: TextView = v.findViewById(R.id.textViewTitle)
        private val textViewArrow: TextView = v.findViewById(R.id.textViewArrow)

        fun bind(item: SampleGroup) {
            textViewTitle.text = item.title
            textViewArrow.text = if (item.isExpanded) "⬆️" else "⬇️"
        }
    }

    inner class SampleChildViewHolder(v: android.view.View) :
        ExpandableChildViewHolder(v) {
        private val textView: TextView = v.findViewById(R.id.textView)

        fun bind(item: SampleChild) {
            textView.text = item.title
        }
    }

    override fun onCreateGroupViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SampleGroupViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_sample_group, parent, false)
        return SampleGroupViewHolder(view)
    }

    override fun onCreateChildViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SampleChildViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_sample_child, parent, false)
        return SampleChildViewHolder(view)
    }

    override fun onBindGroupViewHolder(holder: SampleGroupViewHolder, item: ExpandableGroup) {
        holder.bind(item as SampleGroup)
    }

    override fun onBindChildViewHolder(holder: SampleChildViewHolder, item: ExpandableChild) {
        holder.bind(item as SampleChild)
    }
}