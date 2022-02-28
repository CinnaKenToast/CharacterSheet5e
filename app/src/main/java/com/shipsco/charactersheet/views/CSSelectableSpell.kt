package com.shipsco.charactersheet.views

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import com.shipsco.charactersheet.R
import com.shipsco.charactersheet.databinding.LayoutSelectableSpellBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class CSSelectableSpell: LinearLayout {
    constructor(context: Context) : super(context) { init(context) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { init(context) }

    lateinit var binding: LayoutSelectableSpellBinding

    private fun init(context: Context) {
        binding = LayoutSelectableSpellBinding.inflate(LayoutInflater.from(context), this, true)

        binding.spellName.setOnClickListener {
            createSpellDialog(context)
        }
    }

    fun isChecked(): Boolean {
        return binding.spellButton.isChecked
    }

    fun setChecked(checked: Boolean) {
        binding.spellButton.isChecked = checked
    }

    fun getText(): String {
        return binding.spellName.text.toString()
    }

    fun setText(text: String) {
        binding.spellName.setText(text)
    }

    private fun createSpellDialog(context: Context) {
        val editText = TextInputEditText(context)
        editText.id = R.id.importDialog
        editText.hint = "Insert Spell Name/Details"
        editText.inputType = InputType.TYPE_CLASS_TEXT
        editText.imeOptions = EditorInfo.IME_ACTION_DONE
        editText.setText(binding.spellName.text)
        editText.requestFocus()
        val dialog = MaterialAlertDialogBuilder(context)
            .setTitle("${if (editText.text!!.isEmpty()) "Add" else "Edit"} ${this.contentDescription}")
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("Add") { dialog, which ->
                binding.spellName.text = editText.text.toString()
                dialog.dismiss()
            }
            .setView(editText)
            .show()
        val window = dialog.window
        window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        editText.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding.spellName.text = editText.text.toString()
                dialog.dismiss()
            }
            true
        }
    }

}