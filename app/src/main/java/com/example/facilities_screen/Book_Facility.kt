package com.example.facilities_screen

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class Book_Facility : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_facility)
        val openlayout=findViewById<LinearLayout>(R.id.linearLayout_open)
        val opentimings=findViewById<TextView>(R.id.open_timings)
        opentimings.setOnClickListener {
            if(openlayout.visibility== View.VISIBLE)
            {
                openlayout.visibility=View.GONE
            }
            else{
                openlayout.visibility=View.VISIBLE
            }
        }
        val btn=findViewById<Button>(R.id.book_facility_btn)
        btn.setOnClickListener{
            val intent= Intent(this,Booking_DatePicker::class.java)
            startActivity(intent)
        }

    }
}