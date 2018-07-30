package com.gatheringhallstudios.mhworlddatabase.adapters.common

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.gatheringhallstudios.mhworlddatabase.R
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import kotlinx.android.synthetic.main.listitem_sub_header.view.*

/**
 * Adapter delegate to handle displaying SubHeader objects inside RecyclerViews.
 */
class SubHeaderAdapterDelegate : AdapterDelegate<List<Any>>() {

    override fun isForViewType(items: List<Any>, position: Int): Boolean {
        return items[position] is SubHeader
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.listitem_sub_header, parent, false)

        return HeaderViewHolder(v)
    }

    override fun onBindViewHolder(items: List<Any>,
                                  position: Int,
                                  holder: RecyclerView.ViewHolder,
                                  payloads: List<Any>) {
        val subHeader = items[position] as SubHeader

        val vh = holder as HeaderViewHolder
        vh.setTitle(subHeader.text)
        vh.itemView.setTag(R.id.view_type, subHeader.javaClass)

        if (position != 0) vh.addMarginTop()

        // todo: allow collapsible header. Collapsible header via onSelected is not the proper way
    }

    internal inner class HeaderViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun setTitle(title : String?) {
            view.label_text.text = title
            //vh.labelText.setTypeface(vh.labelText.getTypeface(), Typeface.BOLD);
        }

        fun addMarginTop() {
            var marginLayoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
            marginLayoutParams.topMargin = view.resources.getDimensionPixelSize(R.dimen.margin_medium)
        }
    }
}
