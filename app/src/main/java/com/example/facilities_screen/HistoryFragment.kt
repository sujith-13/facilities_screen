package com.example.facilities_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HistoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var bookingAdapter: BookingAdapter
    private lateinit var bookingList: MutableList<Booking>

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
        val view = inflater.inflate(R.layout.fragment_history, container, false)
        val monthSpinner = view.findViewById<Spinner>(R.id.spinner_month)
        ArrayAdapter.createFromResource(
            requireContext(), R.array.months_array, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            monthSpinner.adapter = adapter
        }
        val layout_filter_button=view.findViewById<LinearLayout>(R.id.linearLayout_filter_button)
        val layout_filter=view.findViewById<LinearLayout>(R.id.linearLayout_filter)
        val default_layout=view.findViewById<LinearLayout>(R.id.linaerlayout_default)
        layout_filter_button.setOnClickListener {
            layout_filter.visibility=View.GONE
            default_layout.visibility=View.VISIBLE
        }
        val filter_btn=view.findViewById<ImageButton>(R.id.filter_button)
        filter_btn.setOnClickListener {
            default_layout.visibility=View.GONE
            layout_filter.visibility=View.VISIBLE
        }

        recyclerView = view.findViewById(R.id.history_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        bookingList = mutableListOf()
        bookingList.add(Booking("22378965", "April 26, 2023", "Meeting Room", " 5,000.00", "27/03/2024", "Net Banking"))
        bookingList.add(Booking("22378965", "April 26, 2023", "Gym", " 40,000.00", "6 Months", "Cheque"))
        bookingList.add(Booking("22378965", "April 26, 2023", "Banquet Hall", " 2,000.00", "14/01/2024", "Cash"))
        bookingList.add(Booking("22378965", "April 26, 2023", "Club House", " 2,000.00", "14/01/2024", "Cheque"))

        bookingAdapter = BookingAdapter(bookingList)
        recyclerView.adapter = bookingAdapter

        return view

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HistoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}