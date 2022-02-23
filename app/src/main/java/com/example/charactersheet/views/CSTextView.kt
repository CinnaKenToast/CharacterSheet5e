package com.example.charactersheet.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.findFragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.charactersheet.R
import com.example.charactersheet.SpellsFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class CSTextView: AppCompatTextView {
    constructor(context: Context) : super(context) { init(context) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context, attrs) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { init(context, attrs) }

    private var isText: Boolean = false
    private var isNumber: Boolean = false
    private var isBonus: Boolean = false

    private fun init(context: Context, attrs: AttributeSet? = null) {

        attrs?.let {
            isText = attrs.getAttributeBooleanValue("app", "isText", false)
            isNumber = attrs.getAttributeBooleanValue("app", "isNumber", false)
            isBonus = attrs.getAttributeBooleanValue("app", "isBonus", false)
        }

        TextViewCompat.setAutoSizeTextTypeWithDefaults(this, AUTO_SIZE_TEXT_TYPE_UNIFORM)
        setTextColor(context.getColor(R.color.black))
        setOnClickListener {
            when {
                isText -> {createTextDialog(context)}
                isNumber -> {}
                isBonus -> {}
            }
        }
    }

    private fun createTextDialog(context: Context) {
        val editText = TextInputEditText(context)
        editText.id = R.id.importDialog
        editText.hint = "Insert ${this.contentDescription}"
        editText.setText(this.text)
        MaterialAlertDialogBuilder(context)
            .setTitle("${if (editText.text!!.isEmpty()) "Add" else "Edit"} ${this.contentDescription}")
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("Add") { dialog, which ->
                this.text = editText.text.toString()
                dialog.dismiss()
            }
            .setView(editText)
            .show()
    }

    private fun createNumberDialog(context: Context) {
        val editText = TextInputEditText(context)
        editText.id = R.id.importDialog
        editText.hint = "Insert ${this.contentDescription}"
        editText.setText(this.text)
        MaterialAlertDialogBuilder(context)
            .setTitle("${if (editText.text!!.isEmpty()) "Add" else "Edit"} ${this.contentDescription}")
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("Add") { dialog, which ->
                this.text = editText.text.toString()
                dialog.dismiss()
            }
            .setView(editText)
            .show()
    }

    private fun createBonusDialog(context: Context) {
        val editText = TextInputEditText(context)
        editText.id = R.id.importDialog
        editText.hint = "Insert ${this.contentDescription}"
        editText.setText(this.text)
        MaterialAlertDialogBuilder(context)
            .setTitle("${if (editText.text!!.isEmpty()) "Add" else "Edit"} ${this.contentDescription}")
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("Add") { dialog, which ->
                this.text = editText.text.toString()
                dialog.dismiss()
            }
            .setView(editText)
            .show()
    }

}