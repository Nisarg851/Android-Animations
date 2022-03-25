package com.example.smoothslidingfragmenttransaction;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.smoothslidingfragmenttransaction.adapters.DayTimeSlotAdapter;
import com.example.smoothslidingfragmenttransaction.adapters.viewPagerAdapters.WeeklyCalanderViewPagerAdapter;
import com.example.smoothslidingfragmenttransaction.fragments.Fragment2;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

//    RecyclerView rvDayTimeSlot, rvWeeklySlots;
//    ViewPager2 vpWeeklyCalander;
    MaterialButton btnCalanderPrevWeek, btnCalanderNextWeek;
    FragmentManager fragmentManager;
    int WeekCount = 1;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalanderNextWeek = findViewById(R.id.btnCalanderNextWeek);
        btnCalanderPrevWeek = findViewById(R.id.btnCalanderPrevWeek);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment2 fragment = new Fragment2(WeekCount, 31);
        fragmentTransaction.add(R.id.fcFragmentContainer, fragment);
        fragmentTransaction.commit();
//        rvWeeklySlots = findViewById(R.id.rvWeeklySlots);
//
//        rvDayTimeSlot = findViewById(R.id.rvDayTimeSlot);
//        DayTimeSlotAdapter dayTimeSlotAdapter = new DayTimeSlotAdapter();
//        rvDayTimeSlot.setAdapter(dayTimeSlotAdapter);
//
//        vpWeeklyCalander = findViewById(R.id.vpWeeklyCalander);
//        WeeklyCalanderViewPagerAdapter weeklyCalanderViewPagerAdapter = new WeeklyCalanderViewPagerAdapter(getSupportFragmentManager(), this.getLifecycle());
//        vpWeeklyCalander.setAdapter(weeklyCalanderViewPagerAdapter);
        btnCalanderNextWeek.setOnClickListener(this);
        btnCalanderPrevWeek.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCalanderPrevWeek:
                WeekCount = WeekCount<=1 ? 1 : WeekCount-1;
                btnCalanderNextWeek.setVisibility(View.VISIBLE);
                if(WeekCount==1){
                    btnCalanderPrevWeek.setVisibility(View.GONE);
                    break;
                }
                btnCalanderPrevWeek.setVisibility(View.VISIBLE);
                changeWeek(WeekCount);
                break;

            case R.id.btnCalanderNextWeek:
                WeekCount = WeekCount>=4 ? 4 : WeekCount+1;
                btnCalanderPrevWeek.setVisibility(View.VISIBLE);
                if(WeekCount==4){
                    btnCalanderNextWeek.setVisibility(View.GONE);
                    break;
                }
                btnCalanderNextWeek.setVisibility(View.VISIBLE);
                changeWeek(WeekCount);
                break;
        }
    }

    private void changeWeek(int WeekCount){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment2 fragment = new Fragment2(WeekCount, 31);
        fragmentTransaction.replace(R.id.fcFragmentContainer, fragment);
        fragmentTransaction.commit();
    }
}