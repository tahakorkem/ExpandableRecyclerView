package com.tahakorkem.expandablerecyclerview

import com.tahakorkem.expandablerecyclerview.model.ExpandableChild
import com.tahakorkem.expandablerecyclerview.model.ExpandableGroup

data class SampleGroup(
    val title: String,
    override val children: List<SampleChild>,
    override var isExpanded: Boolean = false,
) : ExpandableGroup

data class SampleChild(
    val title: String,
) : ExpandableChild