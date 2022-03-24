package com.example.smoothslidingfragmenttransaction.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smoothslidingfragmenttransaction.R;

import java.util.ArrayList;

public class WeeklySlotsAdapter extends RecyclerView.Adapter<WeeklySlotsAdapter.ViewHolder>{
    ArrayList<String> weeklySlotsData;

    public WeeklySlotsAdapter(ArrayList<String> weeklySlotsData) {
        this.weeklySlotsData = weeklySlotsData;
    }

    @Override
    public int getItemViewType(int position) {
        if(position<7)
            return 1;
        return 2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_week_day_slot_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeeklySlotsAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return weeklySlotsData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
