package com.shipsco.charactersheet.views

import android.content.Context
import android.graphics.Typeface
import android.text.InputType
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.widget.TextViewCompat
import com.shipsco.charactersheet.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.shipsco.charactersheet.ManualEditListener

class CSTextView: AppCompatTextView {
    constructor(context: Context) : super(context) { init(context) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context, attrs) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { init(context, attrs) }

    private var isText: Boolean = false
    private var isNumber: Boolean = false
    private var isBonus: Boolean = false
    var isLocked: Boolean = false

    private fun init(context: Context, attrs: AttributeSet? = null) {
        context.obtainStyledAttributes(attrs, R.styleable.CSTextView).apply {
            try {
                isText = getBoolean(R.styleable.CSTextView_isText, false)
                isNumber = getBoolean(R.styleable.CSTextView_isNumber, false)
                isBonus = getBoolean(R.styleable.CSTextView_isBonus, false)
                isLocked = getBoolean(R.styleable.CSTextView_isLocked, false)
            } finally {
                recycle()
            }
        }

        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(this, 8, 50, 1, TypedValue.COMPLEX_UNIT_SP)
        setTextColor(context.getColor(R.color.black))
        setOnClickListener {
            if (!isLocked) {
                showDialog()
            }
        }
        setOnLongClickListener {
            showDialog()
            true
        }
    }

    private fun showDialog() {
        when {
            isText -> {createTextDialog(context)}
            isNumber -> {createNumberDialog(context)}
            isBonus -> {createBonusDialog(context)}
        }
    }

    var eventListener: ManualEditListener? = null

    fun setText(text: String) {
        this.text = text
    }

    private fun createTextDialog(context: Context) {
        val editText = TextInputEditText(context)
        editText.id = R.id.importDialog
        editText.hint = "Insert ${this.contentDescription}"
        editText.inputType = InputType.TYPE_CLASS_TEXT
        editText.imeOptions = EditorInfo.IME_ACTION_DONE
        editText.setText(this.text)
        editText.requestFocus()
        val dialog = MaterialAlertDialogBuilder(context)
            .setTitle("${if (editText.text!!.isEmpty()) "Add" else "Edit"} ${this.contentDescription}")
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("Add") { dialog, which ->
                this.text = editText.text.toString()
                eventListener?.manualEditCompleted(this)
                dialog.dismiss()
            }
            .setView(editText)
            .show()
        val window = dialog.window
        window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        editText.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                this.text = editText.text.toString()
                eventListener?.manualEditCompleted(this)
                dialog.dismiss()
            }
            true
        }
    }

    private fun createNumberDialog(context: Context) {
        val editText = TextInputEditText(context)
        editText.id = R.id.importDialog
        editText.hint = "Insert ${this.contentDescription}"
        editText.inputType = InputType.TYPE_CLASS_NUMBER
        editText.setText(this.text)
        editText.imeOptions = EditorInfo.IME_ACTION_DONE
        editText.requestFocus()
        val dialog = MaterialAlertDialogBuilder(context)
            .setTitle("${if (editText.text!!.isEmpty()) "Add" else "Edit"} ${this.contentDescription}")
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("Add") { dialog, which ->
                this.text = editText.text.toString()
                eventListener?.manualEditCompleted(this)
                dialog.dismiss()
            }
            .setView(editText)
            .show()
        val window = dialog.window
        window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        editText.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                this.text = editText.text.toString()
                eventListener?.manualEditCompleted(this)
                dialog.dismiss()
            }
            true
        }
    }

    private fun createBonusDialog(context: Context) {
        val editText = TextInputEditText(context)
        editText.id = R.id.importDialog
        editText.hint = "Insert ${this.contentDescription}"
        editText.inputType = InputType.TYPE_CLASS_NUMBER.or(InputType.TYPE_NUMBER_FLAG_SIGNED)
        editText.imeOptions = EditorInfo.IME_ACTION_DONE
        editText.setText(this.text.toString().replace("+", ""))
        editText.requestFocus()
        val dialog = MaterialAlertDialogBuilder(context)
            .setTitle("${if (editText.text!!.isEmpty()) "Add" else "Edit"} ${this.contentDescription}")
            .setMessage("A + will automatically be added to positive bonuses")
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .setPositiveButton("Add") { dialog, which ->
                this.text = getBonusFromText(editText.text.toString())
                eventListener?.manualEditCompleted(this)
                dialog.dismiss()
            }
            .setView(editText)
            .show()
        val window = dialog.window
        window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
        window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        editText.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                this.text = getBonusFromText(editText.text.toString())
                eventListener?.manualEditCompleted(this)
                dialog.dismiss()
            }
            true
        }
    }

    private fun getBonusFromText(text: String): String {
        var bonus = text
        if (!bonus.contains("-")) { bonus = "+$bonus" }
        if (bonus.length == 1) { bonus = "" }
        return bonus
    }
}