package com.example.charactersheet.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.charactersheet.R
import com.example.charactersheet.databinding.LayoutCantripBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class CSCantrip: LinearLayout {
    constructor(context: Context) : super(context) { init(context) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { init(context) }

    lateinit var binding: LayoutCantripBinding

    private fun init(context: Context) {
        binding = LayoutCantripBinding.inflate(LayoutInflater.from(context), this, true)
        binding.cantripName.setOnClickListener {
            createCantripDialog(context)
        }
    }

    fun setText(text: String) {
        binding.cantripName.text = text
    }

    private fun createCantripDialog(context: Context) {
        val editText = TextInputEditText(context)
        editText.id = R.id.importDialog
        editText.hint = "Insert Cantrip Name/Details"
        editText.setText(binding.cantripName.text)
        MaterialAlertDialogBuilder(context)
            .setTitle("${if (editText.text!!.isEmpty()) "Add" else "Edit"} ${this.contentDescription}")
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("Add") { dialog, which ->
                binding.cantripName.text = editText.text.toString()
                dialog.dismiss()
            }
            .setView(editText)
            .show()
    }
}