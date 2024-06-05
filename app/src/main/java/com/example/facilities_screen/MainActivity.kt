package com.example.facilities_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)

        // Iterate through all tabs and set the background
        for (i in 0 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            if (tab != null) {
                // You can also add a custom view to the tab and set its background
                val tabView = (tabLayout.getChildAt(0) as ViewGroup).getChildAt(tab.position)
                tabView.setBackgroundResource(R.drawable.tab_background_selector)
            }
        }

        // Set a TabSelectedListener to update the background on tab selection
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val tabView = (tabLayout.getChildAt(0) as ViewGroup).getChildAt(tab.position)
                tabView.setBackgroundResource(R.drawable.tab_background_selector)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val tabView = (tabLayout.getChildAt(0) as ViewGroup).getChildAt(tab.position)
                tabView.setBackgroundResource(R.drawable.tab_background_selector)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // No action needed
            }
        })
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)

        viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Facility"
                1 -> "Bookings"
                2 -> "History"
                else -> null
            }
        }.attach()
    }
}