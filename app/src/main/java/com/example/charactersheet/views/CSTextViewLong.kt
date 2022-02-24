package com.example.charactersheet.views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.charactersheet.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class CSTextViewLong: AppCompatTextView {
    constructor(context: Context) : super(context) { init(context) }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) { init(context) }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) { init(context) }

    private fun init(context: Context) {
        setBackgroundColor(context.getColor(android.R.color.transparent))
        setTextColor(context.getColor(R.color.black))
        setOnClickListener { createTextDialog(context) }
    }

    private fun createTextDialog(context: Context) {
        val editText = TextInputEditText(context)
        editText.id = R.id.importDialog
        editText.hint = "Insert ${this.contentDescription}"
        editText.maxLines = 15
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