package com.shipsco.charactersheet.views

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatCheckBox
import com.shipsco.charactersheet.ManualEditListener
import com.shipsco.charactersheet.R

class CSCheckbox: AppCompatCheckBox {
    constructor(context: Context) : super(context) { init(context) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context, attrs) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int ) : super(context, attrs, defStyle) { init(context, attrs) }

    var eventListener: ManualEditListener? = null

    fun init(context: Context, attrs: AttributeSet? = null) {
        buttonTintList = ColorStateList.valueOf(context.getColor(R.color.black))
        setOnClickListener {
            setManualCompleted()
        }
    }

    fun setManualCompleted() {
        eventListener?.manualEditCompleted()
    }


}