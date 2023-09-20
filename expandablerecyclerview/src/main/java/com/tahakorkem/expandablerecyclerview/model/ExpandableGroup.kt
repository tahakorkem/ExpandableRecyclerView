package com.tahakorkem.expandablerecyclerview.model

interface ExpandableGroup : ExpandableItem {
    var isExpanded: Boolean
    val children: List<ExpandableChild>
}