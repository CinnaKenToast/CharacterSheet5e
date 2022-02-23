package com.example.charactersheet.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.charactersheet.databinding.LayoutCantripBinding

class CSCantrip: LinearLayout {
    constructor(context: Context) : super(context) { init(context) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { init(context) }

    private lateinit var binding: LayoutCantripBinding

    private fun init(context: Context) {
        binding = LayoutCantripBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun getText(): String {
        return binding.cantripName.toString()
    }

    fun setText(string: String) {
        binding.cantripName.text = string
    }
}