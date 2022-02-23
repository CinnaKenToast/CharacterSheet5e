package com.example.charactersheet.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.findFragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.charactersheet.R
import com.example.charactersheet.SpellsFragment

class CSTextView: AppCompatTextView {
    constructor(context: Context) : super(context) { init(context) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { init(context) }


    private fun init(context: Context) {
        TextViewCompat.setAutoSizeTextTypeWithDefaults(this, AUTO_SIZE_TEXT_TYPE_UNIFORM)
        setTextColor(context.getColor(R.color.black))
        maxLines = 1
        isScrollContainer = true
        isNestedScrollingEnabled = true
        overScrollMode = OVER_SCROLL_ALWAYS
    }

}