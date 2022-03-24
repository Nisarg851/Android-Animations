package com.example.smoothslidingfragmenttransaction.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smoothslidingfragmenttransaction.R;

public class WeekDayAndDateListAdapter extends RecyclerView.Adapter<WeekDayAndDateListAdapter.ViewHolder> {

    ViewGroup parent = null;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_header_week_day_and_date, parent, false);
        this.parent = parent;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeekDayAndDateListAdapter.ViewHolder holder, int position) {
        holder.itemView.getLayoutParams().width = (int) ((parent.getWidth())/7);
        holder.itemView.getLayoutParams().height = parent.getHeight();
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
