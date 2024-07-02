package com.example.bookingapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingapp.R;

import java.util.List;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateViewHolder> {

    private List<DateItem> dateList;
    private Context context;
    private int selectedPosition = -1;

    public DateAdapter(List<DateItem> dateList, Context context) {
        this.dateList = dateList;
        this.context = context;
    }

    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.date_item, parent, false);
        return new DateViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull DateViewHolder holder, int position) {
        DateItem dateItem = dateList.get(position);
        holder.day.setText(dateItem.getDay());
        holder.date.setText(dateItem.getDate());
        // Set background and other properties as needed
        // Change the background color of the selected item
        if (position == selectedPosition) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.btn));
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent));
        }

        holder.itemView.setOnClickListener(v -> {
            selectedPosition = holder.getAdapterPosition();
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return dateList.size();
    }
    public void setSelectedDate(String date) {
        for (int i = 0; i < dateList.size(); i++) {
            if (dateList.get(i).getDate().equals(date)) {
                selectedPosition = i;
                notifyDataSetChanged();
                break;
            }
        }
    }

    public static class DateViewHolder extends RecyclerView.ViewHolder {
        TextView day;
        TextView date;

        public DateViewHolder(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.day);
            date = itemView.findViewById(R.id.date);
        }
    }
}

