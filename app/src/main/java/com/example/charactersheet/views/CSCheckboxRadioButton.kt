package com.example.charactersheet.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import com.example.charactersheet.R
import com.example.charactersheet.databinding.CsCheckboxRadioButtonBinding

@BindingAdapter("app:isChecked")
fun setChecked(view: CSCheckboxRadioButton, checked: Boolean) {
    view.setChecked(checked)
}

class CSCheckboxRadioButton: ConstraintLayout {
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context, attrs) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { init(context, attrs) }

    private lateinit var binding: CsCheckboxRadioButtonBinding

    private fun init(context: Context, attrs: AttributeSet) {
        binding = CsCheckboxRadioButtonBinding.inflate(LayoutInflater.from(context), this, true)

        context.obtainStyledAttributes(attrs, R.styleable.CSCheckboxRadioButton).apply {
            binding.radioButton.isChecked = getBoolean(R.styleable.CSCheckboxRadioButton_isChecked, false)
        }

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