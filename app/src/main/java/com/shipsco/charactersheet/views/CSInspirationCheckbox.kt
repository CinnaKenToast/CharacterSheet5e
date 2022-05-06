package com.shipsco.charactersheet.views

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatCheckBox
import com.shipsco.charactersheet.ManualEditListener
import com.shipsco.charactersheet.R

class CSInspirationCheckbox: AppCompatCheckBox {
    constructor(context: Context) : super(context) { init(context) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int ) : super(context, attrs, defStyle) { init(context) }

    var eventListener: ManualEditListener? = null

    private fun init(context: Context) {
        buttonDrawable = context.getDrawable(R.drawable.inspiration_checkbox)
        buttonTintList = ColorStateList.valueOf(context.getColor(R.color.black))
        setOnClickListener {
            setManualCompleted()
        }
    }

    private fun setManualCompleted() {
        eventListener?.manualEditCompleted(this)
    }


}