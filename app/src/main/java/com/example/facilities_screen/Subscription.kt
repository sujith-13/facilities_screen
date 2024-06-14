package com.example.facilities_screen

data class Subscription(
    val imageResource: Int,
    val subscriptiontype: String,
    val location: String,
    val subscribedDate: String,
    val status: String,
    val endDate: String,
    val paymentStatus: String
)

