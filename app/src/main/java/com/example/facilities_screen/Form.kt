package com.example.facilities_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView

class Form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        val tv=findViewById<TextView>(R.id.textView8)
        val text = "Attach Reference*"
        val spannableString = SpannableString(text)

        // Set the color of the asterisk to red
        val start = text.indexOf("*")
        val end = start + 1
        spannableString.setSpan(
            ForegroundColorSpan(0xFFFF0000.toInt()),
            start,
            end,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tv.text=spannableString
    }
}