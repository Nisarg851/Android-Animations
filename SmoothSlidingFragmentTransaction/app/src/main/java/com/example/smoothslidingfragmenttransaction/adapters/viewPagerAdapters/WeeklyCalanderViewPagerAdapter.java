package com.example.smoothslidingfragmenttransaction.adapters.viewPagerAdapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.smoothslidingfragmenttransaction.fragments.Fragment2;

public class WeeklyCalanderViewPagerAdapter extends FragmentStateAdapter {
    public WeeklyCalanderViewPagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    public Fragment createFragment(int position) {
        return new Fragment2();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
