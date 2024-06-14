package com.example.facilities_screen

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class OTBookingAdapter(private val bookings: List<OTBooking>,val requireContext: Context) :
    RecyclerView.Adapter<OTBookingAdapter.OTBookingViewHolder>() {
    private lateinit var dialog: Dialog


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OTBookingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_time_booking_item, parent, false)
        return OTBookingViewHolder(view)
    }

    override fun onBindViewHolder(holder: OTBookingViewHolder, position: Int) {
        val booking = bookings[position]
            holder.tvbooking.text=booking.bookingId
        holder.availDate.text=booking.availDate
        holder.status.text=booking.bookingStatus
        holder.booking_venu.text=booking.bookingVenue
        holder.booking_location.text=booking.bookingLocation
        holder.booking_amount.text=booking.BookingAmout.toString()
//code for reschedule pop-up .adjust the code according to the time from the api
//        holder.reschedulebtn.setOnClickListener {
//            dialog= Dialog(requireContext)
//            dialog.setContentView(R.layout.dialog_reschedule)
//            dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
//            dialog.window?.setBackgroundDrawableResource(R.drawable.dialog_background)
//            dialog.show()
//
//        }
        holder.reschedulebtn.setOnClickListener {
            dialog= Dialog(requireContext)
            dialog.setContentView(R.layout.reschedule_warning)
            dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.setBackgroundDrawableResource(R.drawable.dialog_background)
            dialog.show()

        }
        holder.cancelbtn.setOnClickListener {
            dialog= Dialog(requireContext)
            dialog.setContentView(R.layout.dialog_cancel)
            dialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.window?.setBackgroundDrawableResource(R.drawable.dialog_background)
            dialog.show()
        }
    }

    override fun getItemCount(): Int = bookings.size

    class OTBookingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val tvbooking= itemView.findViewById<TextView>(R.id.tvBooking_id)
        val availDate=itemView.findViewById<TextView>(R.id.tv_availdate)
        val status=itemView.findViewById<TextView>(R.id.booking_status)
        val booking_venu=itemView.findViewById<TextView>(R.id.booking_venue)
        val booking_location=itemView.findViewById<TextView>(R.id.booking_location)
        val booking_amount=itemView.findViewById<TextView>(R.id.booking_amount)
        val reschedulebtn=itemView.findViewById<Button>(R.id.reschedule_btn)
         val cancelbtn=itemView.findViewById<Button>(R.id.cancel_btn)
    }
}
