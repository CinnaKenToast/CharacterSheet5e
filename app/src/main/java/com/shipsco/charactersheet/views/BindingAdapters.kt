package com.shipsco.charactersheet.views

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:isLocked")
fun setIsLocked(view: View, isLocked: Boolean) {
    (view as? CSTextView)?.isLocked = isLocked
    (view as? CSTextViewLong)?.isLocked = isLocked
}