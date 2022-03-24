package com.example.smoothslidingfragmenttransaction.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.smoothslidingfragmenttransaction.R;

import java.util.ArrayList;

public class CalanderAdapter extends RecyclerView.Adapter<CalanderAdapter.ViewHolder> {

    private final ArrayList<String> datesOfCalander;
    private final onItemListener listener;
    private String[] DayMonthYear;

    public CalanderAdapter(ArrayList<String> datesOfCalander, onItemListener listener) {
        this.datesOfCalander = datesOfCalander;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_calander_layout, parent, false);
//        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//        layoutParams.height = (int)(parent.getHeight()*0.166666666);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DayMonthYear = datesOfCalander.get(position).split("/");
        Log.e("bundle", "onBindViewHolder: "+datesOfCalander.get(position));
        holder.tvCalanderDate.setText(DayMonthYear[0]);
    }

    @Override
    public int getItemCount() {
        return datesOfCalander.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvCalanderDate;
        CalanderAdapter.onItemListener listener;

        public ViewHolder(View itemView, CalanderAdapter.onItemListener listener) {
            super(itemView);
            tvCalanderDate = itemView.findViewById(R.id.tvCalanderDate);
            this.listener = listener;
            tvCalanderDate.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            DayMonthYear = datesOfCalander.get(position).split("/");
            listener.onItemClick(position, DayMonthYear);
        }
    }

    public interface onItemListener{
        void onItemClick(int position, String[] DayMonthYear);
    }
}
