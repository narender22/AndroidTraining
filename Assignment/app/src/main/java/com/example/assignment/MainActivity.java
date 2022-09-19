package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    /*
    * Initiate variables to be used
    * */
    TabLayout tabLayout;
    ViewPager2 viewPager;
    com.example.assignment.MyViewPagerAdapter myViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         * assign variable required IDs
         * */
//        to use the TabLayout
        tabLayout = findViewById(R.id.tabLayout2);
//        to use the ViewPager
        viewPager = findViewById(R.id.pager);
//        to use the ViewPager created
        myViewPagerAdapter = new com.example.assignment.MyViewPagerAdapter(this);
//        set adapter for the view pager
        viewPager.setAdapter(myViewPagerAdapter);

//        to change the current selected page
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        to change the position of current selected page when slided
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
//                will return the page number of the selected page
                Objects.requireNonNull(tabLayout.getTabAt(position)).select();
            }
        });
    }
}