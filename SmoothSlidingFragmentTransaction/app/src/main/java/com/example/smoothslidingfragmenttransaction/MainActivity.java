package com.example.smoothslidingfragmenttransaction;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Build;
import android.os.Bundle;

import com.example.smoothslidingfragmenttransaction.adapters.DayTimeSlotAdapter;
import com.example.smoothslidingfragmenttransaction.adapters.viewPagerAdapters.WeeklyCalanderViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvDayTimeSlot, rvWeeklySlots;
    ViewPager2 vpWeeklyCalander;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvWeeklySlots = findViewById(R.id.rvWeeklySlots);

        rvDayTimeSlot = findViewById(R.id.rvDayTimeSlot);
        DayTimeSlotAdapter dayTimeSlotAdapter = new DayTimeSlotAdapter();
        rvDayTimeSlot.setAdapter(dayTimeSlotAdapter);

        vpWeeklyCalander = findViewById(R.id.vpWeeklyCalander);
        WeeklyCalanderViewPagerAdapter weeklyCalanderViewPagerAdapter = new WeeklyCalanderViewPagerAdapter(getSupportFragmentManager(), this.getLifecycle());
        vpWeeklyCalander.setAdapter(weeklyCalanderViewPagerAdapter);
    }
}