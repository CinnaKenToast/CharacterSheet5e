package com.shipsco.charactersheet.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.WindowManager
import androidx.appcompat.widget.AppCompatTextView
import com.shipsco.charactersheet.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.shipsco.charactersheet.ManualEditListener

class CSTextViewLong: AppCompatTextView {
    constructor(context: Context) : super(context) { init(context) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context, attrs) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { init(context, attrs) }

    private fun init(context: Context, attrs: AttributeSet? = null) {
        context.obtainStyledAttributes(attrs, R.styleable.CSTextViewLong).apply {
            try {
                isLocked = getBoolean(R.styleable.CSTextView_isLocked, false)
            } finally {
                recycle()
            }
        }
        setBackgroundColor(context.getColor(android.R.color.transparent))
        setTextColor(context.getColor(R.color.black))
        setOnClickListener {
            if (!isLocked) {
                createTextDialog(context)
            }
        }
        setOnLongClickListener {
            createTextDialog(context)
            true
        }
    }

    var eventListener: ManualEditListener? = null

    var isLocked: Boolean = false

    private fun createTextDialog(context: Context) {
        val editText = TextInputEditText(context)
        editText.id = R.id.importDialog
        editText.hint = "Insert ${this.contentDescription}"
        editText.maxLines = 15
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
    }
}