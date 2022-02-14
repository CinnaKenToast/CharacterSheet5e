package com.example.charactersheet.views

import android.content.Context
import android.util.AttributeSet
import android.widget.RadioGroup
import androidx.appcompat.widget.AppCompatRadioButton

class CSRadioButton: AppCompatRadioButton {
    constructor(context: Context) : super(context) { init() }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init() }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { init() }

    override fun toggle() {
        if (isChecked) {
            if (parent is RadioGroup) {
                (parent as RadioGroup).clearCheck()
            }
        } else {
            isChecked = true
        }
    }

    private fun init() {

    }
}