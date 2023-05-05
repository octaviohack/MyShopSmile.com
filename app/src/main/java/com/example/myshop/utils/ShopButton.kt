package com.example.myshop.utils

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

class ShopButton (context: Context, attrs: AttributeSet): AppCompatButton(context, attrs) {

    init {
        // Call the function to apply the font to the components.
        applyFont()
    }

    private fun applyFont() {
        // This is used to get the file from the assets folder and set it to the title textView.

        val typeface: Typeface =
            Typeface.createFromAsset(context.assets, "montepetrum.bold.ttf")
        setTypeface(typeface)
    }
}