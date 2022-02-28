package com.shipsco.charactersheet.views

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import androidx.appcompat.widget.AppCompatEditText
import com.shipsco.charactersheet.R

class CSEditText: AppCompatEditText {
    constructor(context: Context) : super(context) { init(context) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { init(context) }

    override fun onKeyPreIme(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            clearFocus()
        }
        return super.onKeyPreIme(keyCode, event)
    }

    override fun onEditorAction(actionCode: Int) {
        if (actionCode == EditorInfo.IME_ACTION_DONE) {
            clearFocus()
        }
        super.onEditorAction(actionCode)
    }

    private fun init(context: Context) {
        imeOptions = EditorInfo.IME_ACTION_DONE
        isSingleLine = true
        setTextColor(context.getColor(R.color.black))
        if (this.resources.getResourceName(id).contains("spellAttack"))
            background = context.getDrawable(R.drawable.edit_text_border)
        else
            setBackgroundColor(context.getColor(android.R.color.transparent))
    }
}