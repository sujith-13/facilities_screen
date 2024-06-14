package com.example.facilities_screen

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookingAdapter(private val bookingList: List<Booking>) :
    RecyclerView.Adapter<BookingAdapter.BookingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.booking_item, parent, false)
        return BookingViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
        val booking = bookingList[position]
        holder.bookingId.text = "Booking ID: ${booking.bookingId}"
        holder.availDate.text = "Availed Date: ${booking.availDate}"
        holder.bookingType.text = booking.bookingType
        holder.paymentAmount.text = booking.paymentAmount
        holder.paymentDate.text = booking.paymentDate
        holder.paymentMethod.text = booking.paymentMethod
        val underlinedText = Html.fromHtml("<u>View Receipt</u>")
        holder.textView.text = underlinedText
    }

    override fun getItemCount(): Int = bookingList.size

    class BookingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookingId: TextView = itemView.findViewById(R.id.booking_id)
        val availDate: TextView = itemView.findViewById(R.id.avail_date)
        val bookingType: TextView = itemView.findViewById(R.id.booking_type)
        val paymentAmount: TextView = itemView.findViewById(R.id.payment_amount)
        val paymentDate: TextView = itemView.findViewById(R.id.payment_date)
        val paymentMethod: TextView = itemView.findViewById(R.id.payment_method)
        val textView = itemView.findViewById<TextView>(R.id.view_receipt)



    }
}
