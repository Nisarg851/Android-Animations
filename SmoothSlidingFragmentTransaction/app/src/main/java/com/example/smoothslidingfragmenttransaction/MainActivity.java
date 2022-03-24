package com.example.smoothslidingfragmenttransaction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.smoothslidingfragmenttransaction.fragments.Fragment2;

public class MainActivity extends AppCompatActivity {

    ViewPager2 vpWeeklyCalander;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        vpWeeklyCalander = findViewById(R.id.vpWeeklyCalander);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainerView, Fragment2.class, null);
        fragmentTransaction.commit();
    }
}