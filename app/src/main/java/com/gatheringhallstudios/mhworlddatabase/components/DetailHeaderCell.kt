package com.gatheringhallstudios.mhworlddatabase.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gatheringhallstudios.mhworlddatabase.R
import kotlinx.android.synthetic.main.cell_detail_header.view.*

/**
 * A reusable component for detail page headers.
 */
class DetailHeaderCell : ConstraintLayout {

    private val TAG = javaClass.simpleName

    constructor(context: Context, @DrawableRes imgSrc: Int, titleText: String, descriptionText: String, subtitleText: String? = null) : super(context) {
        val drawable = ContextCompat.getDrawable(getContext(), imgSrc)
        init(drawable, titleText, descriptionText, subtitleText)
    }

    constructor(context: Context) : super(context) {
        init(null, "", "", null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.DetailHeaderCell)

        // Set values from attributes
        val drawable: Drawable?
        val titleText: String?
        val descriptionText: String?
        val subtitleText: String?
        try {
            drawable = attributes.getDrawable(R.styleable.DetailHeaderCell_iconSrc)
            titleText = attributes.getString(R.styleable.DetailHeaderCell_titleText)
            descriptionText = attributes.getString(R.styleable.DetailHeaderCell_descriptionText)
            subtitleText = attributes.getString(R.styleable.DetailHeaderCell_subtitleText)
        } finally {
            // Typed arrays should be recycled after use
            attributes.recycle()
        }

        init(drawable, titleText, descriptionText, subtitleText)
    }

    fun init(drawable: Drawable?, titleText: String?, descriptionText: String?, subtitleText: String?) {
        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.cell_detail_header, this, true)

        header_icon.setImageDrawable(drawable)
        header_title.text = titleText
        header_description.text = descriptionText

        if (subtitleText != null) {
            header_subtitle.visibility = View.VISIBLE
            header_subtitle.text = subtitleText
        }

        layoutParams = ViewGroup.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    /**
     * Set custom drawable for the left icon
     */
    fun setIconDrawable(drawable: Drawable?) {
        header_icon.setImageDrawable(drawable)

        // Invalidate to trigger layout update
        invalidate()
    }

    fun setTitleText(titleText: String?) {
        header_title.text = titleText
    }

    fun setDescriptionText(descriptionText: String?) {
        header_description.text = descriptionText
    }

    fun setSubtitleText(subtitleText: String?) {
        header_subtitle.visibility = View.VISIBLE
        header_subtitle.text = subtitleText
    }

    /**
     * Removes the decorator around the icon.
     * TODO Make this an instantiation flag if necessary
     */
    fun removeDecorator() {
        header_icon.background = null
        header_icon.setPadding(0, 0, 0, 0)
    }
}