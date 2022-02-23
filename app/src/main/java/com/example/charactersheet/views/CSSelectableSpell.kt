package com.example.charactersheet.views

import android.content.Context
import android.text.Layout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.charactersheet.databinding.LayoutSelectableSpellBinding

class CSSelectableSpell: LinearLayout {
    constructor(context: Context) : super(context) { init(context) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { init(context) }

    private lateinit var binding: LayoutSelectableSpellBinding

    private fun init(context: Context) {
        binding = LayoutSelectableSpellBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun isChecked(): Boolean {
        return binding.spellButton.isChecked()
    }

    fun setChecked(checked: Boolean) {
        binding.spellButton.setChecked(checked)
    }

    fun getText(): String {
        return binding.spellName.toString()
    }

    fun setText(string: String) {
        binding.spellName.text = string
    }

}