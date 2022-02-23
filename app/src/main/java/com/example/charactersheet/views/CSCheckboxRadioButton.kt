package com.example.charactersheet.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.example.charactersheet.R
import com.example.charactersheet.databinding.CsCheckboxRadioButtonBinding

class CSCheckboxRadioButton: ConstraintLayout {
    constructor(context: Context) : super(context) { init(context) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { init(context) }

    private lateinit var binding: CsCheckboxRadioButtonBinding

    private fun init(context: Context) {
        binding = CsCheckboxRadioButtonBinding.inflate(LayoutInflater.from(context), this, true)

        this.setOnClickListener {
            binding.radioButton.toggle()
        }
    }

    fun isChecked(): Boolean {
        return binding.radioButton.isChecked
    }

    fun setChecked(checked: Boolean) {
        binding.radioButton.isChecked = checked
    }
}