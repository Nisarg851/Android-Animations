package com.example.smoothslidingfragmenttransaction.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.smoothslidingfragmenttransaction.R;

public class Fragment2 extends Fragment {

    TextView tvText;
    Button btnMove;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        tvText = view.findViewById(R.id.tvText);
        btnMove = view.findViewById(R.id.btnMove);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        String[] DateTimeMonthBundle = this.getArguments().getStringArray("DateTimeMonthBundle");
        if(DateTimeMonthBundle!=null){
            String recievedDate = DateTimeMonthBundle[0]+"/"+DateTimeMonthBundle[1]+"/"+DateTimeMonthBundle[2];
            tvText.setText(recievedDate);
        }
        btnMove.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView, Fragment3.class, null);
            fragmentTransaction.commit();
        });

        return view;
    }
}