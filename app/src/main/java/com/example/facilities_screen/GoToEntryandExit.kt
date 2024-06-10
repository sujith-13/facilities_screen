package com.example.facilities_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class GoToEntryandExit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_go_to_entryand_exit)
        val btn=findViewById<Button>(R.id.enter_delete)
        val enter=findViewById<LinearLayout>(R.id.linearLayout)
        val delete=findViewById<LinearLayout>(R.id.linearLayout2)
        var bool=true;
        btn.setOnClickListener {
            if(bool)
            {
                delete.visibility=View.GONE
                enter.visibility=View.VISIBLE
                bool=false

            }
            else{
                enter.visibility=View.GONE
                delete.visibility=View.VISIBLE
                bool=true
            }
        }
    }
}