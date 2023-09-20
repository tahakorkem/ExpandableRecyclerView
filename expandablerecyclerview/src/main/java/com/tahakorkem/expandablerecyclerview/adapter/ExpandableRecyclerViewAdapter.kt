package com.tahakorkem.expandablerecyclerview.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tahakorkem.expandablerecyclerview.model.ExpandableChild
import com.tahakorkem.expandablerecyclerview.model.ExpandableGroup
import com.tahakorkem.expandablerecyclerview.model.ExpandableItem
import com.tahakorkem.expandablerecyclerview.viewholder.ExpandableChildViewHolder
import com.tahakorkem.expandablerecyclerview.viewholder.ExpandableGroupViewHolder

abstract class ExpandableRecyclerViewAdapter<GVH : ExpandableGroupViewHolder, CVH : ExpandableChildViewHolder>(
    data: List<ExpandableGroup>,
    private val options: Options = Options(),
) : RecyclerView.Adapter<ViewHolder>() {

    private val data: MutableList<ExpandableItem> = data.toMutableList()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        if (options.scrollToGroupOnExpand) {
            registerAdapterDataObserver(object :
                RecyclerView.AdapterDataObserver() {
                override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                    (recyclerView.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(
                        positionStart - 1,
                        0
                    )
                }
            })
        }
    }

    abstract fun onCreateGroupViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GVH

    abstract fun onCreateChildViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CVH

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            0 -> onCreateGroupViewHolder(parent, viewType)

            1 -> onCreateChildViewHolder(parent, viewType)
            else -> throw IllegalArgumentException("Invalid View Type")
        }
    }

    abstract fun onBindGroupViewHolder(holder: GVH, item: ExpandableGroup)

    abstract fun onBindChildViewHolder(holder: CVH, item: ExpandableChild)

    final override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (val item = data[position]) {
            is ExpandableGroup -> {
                holder as GVH
                bindGroupItemViewClick(holder, item)
                onBindGroupViewHolder(holder, item)
            }

            is ExpandableChild -> onBindChildViewHolder(holder as CVH, item)
        }
    }

    private fun bindGroupItemViewClick(holder: GVH, item: ExpandableGroup) {
        holder.itemView.setOnClickListener {
            fun expand() {
                item.isExpanded = true
                notifyItemChanged(holder.adapterPosition, null)
                data.addAll(
                    holder.adapterPosition + 1,
                    item.children
                )
                notifyItemRangeInserted(
                    holder.adapterPosition + 1,
                    item.children.size
                )
            }

            fun collapse(start: Int, count: Int) {
                data.subList(start, start + count).clear()
                notifyItemRangeRemoved(start, count)
            }

            fun collapse() {
                item.isExpanded = false
                notifyItemChanged(holder.adapterPosition, null)
                // Remove child items
                collapse(holder.adapterPosition + 1, item.children.size)
            }

            fun collapseAll() {
                // Iterate through all items and collapse them
                for (i in data.indices.reversed()) {
                    val currentItem = data[i]
                    if (currentItem is ExpandableGroup && currentItem != item && currentItem.isExpanded) {
                        currentItem.isExpanded = false
                        notifyItemChanged(i, null)
                        // Remove child items
                        collapse(i + 1, currentItem.children.size)
                    }
                }
            }

            // Collapse all other items if this behavior is enabled
            if (options.collapseOthersOnExpand) {
                collapseAll()
            }

            // Add or Remove Children Items
            if (item.isExpanded) {
                collapse()
            } else {
                expand()
            }
        }
    }

    final override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is ExpandableGroup -> 0
            is ExpandableChild -> 1
            else -> throw IllegalArgumentException("Invalid View Type")
        }
    }

    final override fun getItemCount(): Int {
        return data.size
    }

    data class Options(
        val collapseOthersOnExpand: Boolean = true,
        val scrollToGroupOnExpand: Boolean = true,
    )
}

