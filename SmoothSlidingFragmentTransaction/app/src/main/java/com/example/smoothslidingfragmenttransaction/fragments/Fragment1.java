package com.example.smoothslidingfragmenttransaction.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.smoothslidingfragmenttransaction.R;

public class Fragment1 extends Fragment {

    Button btnMove;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        btnMove = view.findViewById(R.id.btnMove);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        btnMove.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentContainerView, Fragment2.class, null);
            fragmentTransaction.commit();
        });

        return view;
    }
}