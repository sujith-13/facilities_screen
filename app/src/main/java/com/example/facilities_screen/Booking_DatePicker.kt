package com.example.facilities_screen

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class Booking_DatePicker : AppCompatActivity() {
    private lateinit var dialog: Dialog
   private lateinit var record_payment:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_date_picker)
        val paybtn=findViewById<Button>(R.id.pay_now_btn)

        paybtn.setOnClickListener {
            dialog= Dialog(this)
            dialog.setContentView(R.layout.payment_dialog)
            dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.setBackgroundDrawableResource(R.drawable.dialog_background)
            dialog.show()
            record_payment=dialog.findViewById(R.id.record_payment)
            record_payment.setOnClickListener {
                dialog.dismiss()
                val dialog2=Dialog(this@Booking_DatePicker)
                dialog2.setContentView(R.layout.record_payment_dialog)
                dialog2.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                dialog2.window?.setBackgroundDrawableResource(R.drawable.dialog_background)
                dialog2.show()
            }
        }


    }
}