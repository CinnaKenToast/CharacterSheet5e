package com.example.charactersheet.views

import android.content.Context
import android.text.Layout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.charactersheet.R
import com.example.charactersheet.databinding.LayoutSelectableSpellBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class CSSelectableSpell: LinearLayout {
    constructor(context: Context) : super(context) { init(context) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { init(context) }

    private lateinit var binding: LayoutSelectableSpellBinding

    private fun init(context: Context) {
        binding = LayoutSelectableSpellBinding.inflate(LayoutInflater.from(context), this, true)

        binding.spellName.setOnClickListener {
            createSpellDialog(context)
        }
    }

    fun isChecked(): Boolean {
        return binding.spellButton.isChecked()
    }

    fun setChecked(checked: Boolean) {
        binding.spellButton.setChecked(checked)
    }

    fun getText(): String {
        return binding.spellName.text.toString()
    }

    fun setText(string: String) {
        binding.spellName.text = string
    }

    private fun createSpellDialog(context: Context) {
        val editText = TextInputEditText(context)
        editText.id = R.id.importDialog
        editText.hint = "Insert Spell Name/Details"
        editText.setText(binding.spellName.text)
        MaterialAlertDialogBuilder(context)
            .setTitle("Add Spell")
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("Add") { dialog, which ->
                binding.spellName.text = editText.text.toString()
                dialog.dismiss()
            }
            .setView(editText)
            .show()
    }

}