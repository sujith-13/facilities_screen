package com.example.facilities_screen

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookingsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var subscription_list: ArrayList<Subscription>
    private lateinit var booking_list:ArrayList<OTBooking>
    private lateinit var dialog:Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_bookings, container, false)
        val subscription_rv=view.findViewById<RecyclerView>(R.id.subscription_recycler_view)
        val ot_booking_rv=view.findViewById<RecyclerView>(R.id.one_time_booking_rv)
        val btnLeft=view.findViewById<ImageButton>(R.id.left_button)
        val btnRight=view.findViewById<ImageButton>(R.id.right_button)

        booking_list= arrayListOf()
        booking_list.add(
            OTBooking(
                 "123456",
                 "2024-06-01",
                "Confirmed",
               "Banquet Hall",
                 "Blook D",
                40000
            ),

            // Add more bookings as needed
        )
        booking_list.add(
            OTBooking(
                "123456",
                "2024-06-01",
                "Confirmed",
                "Banquet Hall",
                "Blook D",
                40000
            ),

            // Add more bookings as needed
        )

       val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        ot_booking_rv.layoutManager=layoutManager
        val adapter=OTBookingAdapter(booking_list,requireContext())

        ot_booking_rv.adapter=adapter

        btnLeft.setOnClickListener {
            val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()
            if (firstVisiblePosition > 0) {
                ot_booking_rv.smoothScrollToPosition(firstVisiblePosition - 1)
            }
        }

        btnRight.setOnClickListener {
            val lastVisiblePosition = layoutManager.findLastVisibleItemPosition()
            if (lastVisiblePosition < booking_list.size - 1) {
                ot_booking_rv.smoothScrollToPosition(lastVisiblePosition + 1)
            }
        }

        subscription_rv.layoutManager = LinearLayoutManager(context)
        subscription_list= arrayListOf()
        subscription_list.add(
            Subscription(
                     R.drawable.swimming_pool, // replace with actual image resource
               "Swimming Pool",
                 "Beside Block D",
                "April 26, 2023",
                 "Active",
                "Ends on 18 Dec, 2024",
                "paid"
            ))
        subscription_list.add(
            Subscription(
                R.drawable.gym, // replace with actual image resource
                "Gym",
                "Beside Block D",
                "April 26, 2023",
                "Processing",
                "Ends on 18 Dec, 2024",
                "processing"
            ))
        subscription_list.add(
            Subscription(
                R.drawable.club_house, // replace with actual image resource
                "Club House",
                "Beside Block D",
                "April 26, 2023",
                "Not Received",
                "Ends on 18 Dec, 2024",
                "failed"
            ))
        subscription_rv.adapter=SubscriptionAdapter(subscription_list)





        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookingsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookingsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}