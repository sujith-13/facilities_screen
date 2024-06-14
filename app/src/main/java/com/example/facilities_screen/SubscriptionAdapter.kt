package com.example.facilities_screen

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.facilities_screen.R.drawable.sub_processing

class SubscriptionAdapter(private val subscriptions: List<Subscription>) :
    RecyclerView.Adapter<SubscriptionAdapter.SubscriptionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriptionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.subscription_recycler_view, parent, false)
        return SubscriptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubscriptionViewHolder, position: Int) {
        val subscription = subscriptions[position]

        holder.subscription_date.text=subscription.subscribedDate
        holder.subscription_img.setImageResource(subscription.imageResource)
        holder.subscription_type.text=subscription.subscriptiontype
        holder.status.text=subscription.status
        holder.sub_location.text=subscription.location
        when (subscription.paymentStatus) {
            "processing" -> {
                holder.status.setBackgroundResource(R.drawable.sub_processing)
                holder.status.setTextColor(Color.parseColor("#1794C5")) // Example: Orange
            }
            "failed" -> {
                holder.status.setBackgroundResource(R.drawable.sub_not_received)
                holder.status.setTextColor(Color.parseColor("#A3262E")) // Example: Red
            }
            "paid" -> {
                holder.status.setBackgroundResource(R.drawable.booking_paid)
                holder.status.setTextColor(Color.parseColor("#26A34D")) // Example: Green
            }
            else -> {
                holder.status.setBackgroundResource(R.drawable.booking_paid)
                holder.status.setTextColor(Color.parseColor("#26A34D")) // Example: Black
            }
        }


    }

    override fun getItemCount(): Int = subscriptions.size

    class SubscriptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val subscription_date=itemView.findViewById<TextView>(R.id.tvSubscribedDate)
        val subscription_img=itemView.findViewById<ImageView>(R.id.subscriptionimg)
        val subscription_type=itemView.findViewById<TextView>(R.id.subscription_venue)
        val sub_location=itemView.findViewById<TextView>(R.id.sub_location)
//        val endTime=itemView.findViewById<TextView>(R.id.sub_endtime)
        val status=itemView.findViewById<TextView>(R.id.sub_status)
//         val layout=itemView.findViewById<TextView>(R.id.linearLayout_status)
    }
}
