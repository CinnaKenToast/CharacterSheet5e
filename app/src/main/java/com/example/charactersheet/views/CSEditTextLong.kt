package com.example.charactersheet.views

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText
import com.example.charactersheet.R

class CSEditTextLong: AppCompatEditText {
    constructor(context: Context) : super(context) { init(context) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { init(context) }

    override fun onKeyPreIme(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            clearFocus()
        }
        return super.onKeyPreIme(keyCode, event)
    }

    private fun init(context: Context) {
        setBackgroundColor(context.getColor(android.R.color.transparent))
    }
}