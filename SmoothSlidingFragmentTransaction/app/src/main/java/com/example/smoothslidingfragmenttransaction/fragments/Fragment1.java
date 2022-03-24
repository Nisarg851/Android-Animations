package com.example.smoothslidingfragmenttransaction.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.smoothslidingfragmenttransaction.R;
import com.example.smoothslidingfragmenttransaction.adapters.CalanderAdapter;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Fragment1 extends Fragment implements CalanderAdapter.onItemListener, View.OnClickListener {

    private TextView tvCalanderMonth;
    private Button btnCalanderNextMonth, btnCalanderPrevMonth;
    private RecyclerView rvCalanderDates;
    private LocalDate selectedDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_1, container, false);
//        initializeControls(view);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            selectedDate = LocalDate.now();
//            setMonthView();
//        }
//        return view;
        return null;
    }

    private void setMonthView(){
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
//            String monthYear = selectedDate.format(formatter);
//            tvCalanderMonth.setText(monthYear);
//            ArrayList<String> daysInMonth = daysInMonthArray(selectedDate);
//            Log.e("cal", "setMonthView: "+daysInMonth.toString());
//            CalanderAdapter calanderAdapter = new CalanderAdapter(daysInMonth, this);
//            rvCalanderDates.setAdapter(calanderAdapter);
//        }
    }

//    @RequiresApi(api = Build.VERSION_CODES.O)
//    private ArrayList<String> daysInMonthArray(LocalDate selectedDate) {
//        ArrayList<String> daysInMonthArray = new ArrayList();
//        YearMonth yearMonth = YearMonth.from(selectedDate);
//
//        int month = yearMonth.getMonthValue();
//        int year = yearMonth.getYear();
//
//        int daysInMonth = yearMonth.lengthOfMonth();
//        LocalDate firstOfMonth = selectedDate.withDayOfMonth(1);
//        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue()%7;
//
//        Log.e("date", "daysInMonthArray: daysInMonth: "+daysInMonth+" dayOfWeek: "+dayOfWeek);
//
//        for(int day=0; day<42; day++){
//            if(day<dayOfWeek || day>daysInMonth)
//                daysInMonthArray.add("");
//            else
//                daysInMonthArray.add(String.valueOf(day-dayOfWeek+1)+"/"+month+"/"+year);
//        }
//
//        return  daysInMonthArray;
//    }

    private void initializeControls(View view) {
//        tvCalanderMonth = view.findViewById(R.id.tvCalanderMonth);
//        rvCalanderDates = view.findViewById(R.id.rvCalanderDates);
//        btnCalanderNextMonth = view.findViewById(R.id.btnCalanderNextMonth);
//        btnCalanderPrevMonth = view.findViewById(R.id.btnCalanderPrevMonth);
//
//        btnCalanderNextMonth.setOnClickListener(this);
//        btnCalanderPrevMonth.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.btnCalanderNextMonth:
//                selectedDate = selectedDate.plusMonths(1);
//                setMonthView();
//                break;
//            case R.id.btnCalanderPrevMonth:
//                selectedDate = selectedDate.minusMonths(1);
//                setMonthView();
//                break;
//        }
    }

    @Override
    public void onItemClick(int position, String[] DayMonthYear) {
//        if(DayMonthYear!=null && DayMonthYear.length>1) {
//            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//            Bundle DateTimeMonthBundle = new Bundle();
//            DateTimeMonthBundle.putStringArray("DateTimeMonthBundle",DayMonthYear);
//
//            fragmentTransaction.replace(R.id.fragmentContainerView, Fragment2.class, DateTimeMonthBundle);
//            fragmentTransaction.addToBackStack("MoveToDaycalander");
//            fragmentTransaction.commit();
//        }
    }
}