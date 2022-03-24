package com.example.smoothslidingfragmenttransaction.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smoothslidingfragmenttransaction.R;
import com.example.smoothslidingfragmenttransaction.adapters.WeekDayAndDateListAdapter;
import com.example.smoothslidingfragmenttransaction.adapters.WeeklySlotsAdapter;

import java.util.ArrayList;

public class Fragment2 extends Fragment {

    RecyclerView rvWeekDaysContainer, rvWeeklySlots;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        initilizeControls(view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            initilizeDayRecyclerView(container);
        }

        ArrayList<String> weeklySlotData = getWeekSlotsData();
        initilizeWeeklySlotRecyclerView(weeklySlotData);

        return view;
    }

    private void initilizeWeeklySlotRecyclerView(ArrayList<String> weeklySlotData) {
        WeeklySlotsAdapter weeklySlotsAdapter = new WeeklySlotsAdapter(weeklySlotData);
        rvWeeklySlots.setAdapter(weeklySlotsAdapter);
    }

    private void initilizeControls(View view) {
        rvWeekDaysContainer = view.findViewById(R.id.rvWeekDaysContainer);
        rvWeeklySlots = view.findViewById(R.id.rvWeeklySlots);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initilizeDayRecyclerView(ViewGroup container) {
        // Set Horizontal LinearLayout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvWeekDaysContainer.setLayoutManager(layoutManager);

        // Set Divider in Recycler View
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(container.getContext(), DividerItemDecoration.HORIZONTAL);
//        rvWeekDaysContainer.addItemDecoration(dividerItemDecoration);

        // Set Adapter
        WeekDayAndDateListAdapter weekDayAndDateListAdapter = new WeekDayAndDateListAdapter();
        rvWeekDaysContainer.setAdapter(weekDayAndDateListAdapter);
//        syncScrollListenersOfRecycleViews();
    }

    private ArrayList<String> getWeekSlotsData(){
        ArrayList<String> data = new ArrayList<String>();

        int daysInWeek = 7;
        int slotsInADay = 12;
        for(int slot=1; slot<=(daysInWeek*slotsInADay); slot++){
            data.add("");
        }

        return data;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void syncScrollListenersOfRecycleViews(){

        RecyclerView rvDayTimeSlot = getActivity().findViewById(R.id.rvDayTimeSlot);

        RecyclerView.OnScrollListener[] onScrollListeners = new RecyclerView.OnScrollListener[2];

        onScrollListeners[0] = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                rvWeeklySlots.removeOnScrollListener(onScrollListeners[1]);
                rvWeeklySlots.scrollBy(dx, dy);
//                rvWeeklySlots.addOnScrollListener(onScrollListeners[1]);
            }
        };

        Log.e("rv", "syncScrollListenersOfRecycleViews: "+(rvWeeklySlots==null)+" "+(rvDayTimeSlot==null));

        onScrollListeners[1] = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                rvDayTimeSlot.removeOnScrollListener(onScrollListeners[0]);
                rvDayTimeSlot.scrollBy(dx, dy);
//                rvDayTimeSlot.addOnScrollListener(onScrollListeners[1]);
            }
        };
        rvDayTimeSlot.addOnScrollListener(onScrollListeners[0]);
        rvWeeklySlots.addOnScrollListener(onScrollListeners[1]);
    }
}