package com.example.charactersheet.views

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.TextViewCompat
import com.example.charactersheet.R
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
        context.obtainStyledAttributes(attrs, R.styleable.CSTextView).apply {
            try {
                isText = getBoolean(R.styleable.CSTextView_isText, false)
                isNumber = getBoolean(R.styleable.CSTextView_isNumber, false)
                isBonus = getBoolean(R.styleable.CSTextView_isBonus, false)
            } finally {
                recycle()
            }
        }

        TextViewCompat.setAutoSizeTextTypeWithDefaults(this, AUTO_SIZE_TEXT_TYPE_UNIFORM)
        setTextColor(context.getColor(R.color.black))
        setOnClickListener {
            when {
                isText -> {createTextDialog(context)}
                isNumber -> {createNumberDialog(context)}
                isBonus -> {createBonusDialog(context)}
            }
        }
    }

    fun setText(text: String) {
        this.text = text
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
        editText.inputType = InputType.TYPE_CLASS_NUMBER
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
        editText.inputType = InputType.TYPE_CLASS_NUMBER.or(InputType.TYPE_NUMBER_FLAG_SIGNED)
        editText.setText(this.text.toString().replace("+", ""))
        MaterialAlertDialogBuilder(context)
            .setTitle("${if (editText.text!!.isEmpty()) "Add" else "Edit"} ${this.contentDescription}")
            .setMessage("A + will automatically be added to positive bonuses")
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("Add") { dialog, which ->
                var newBonus = editText.text.toString()
                if (!newBonus.contains("-")) { newBonus = "+$newBonus" }
                this.text = newBonus
                dialog.dismiss()
            }
            .setView(editText)
            .show()
    }

}