package com.example.bookingapp.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingapp.Flights;
import com.example.bookingapp.OnClickDateListener;
import com.example.bookingapp.R;

import java.util.List;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateViewHolder> {
    private List<DateItem> dateList;
    private Context context;
    private String departureDatetime; // Updated to datetime
    private static OnClickDateListener onClickDateListener;

    public static void registerOnClickDateListener(Flights context) {
        onClickDateListener = (OnClickDateListener) context;
    }

    public DateAdapter(List<DateItem> dateList, Context context) {
        this.dateList = dateList;
        this.context = context;
    }
    public DateAdapter(List<DateItem> dateList, Context context, String departureDate) {
        this.dateList = dateList;
        this.context = context;
        this.departureDatetime = departureDate; // Initialize departureDate
        // Set initial selection based on departureDatetime
        for (DateItem item : dateList) {
            if (item.getDatetime().equals(departureDatetime)) {
                item.setSelected(true);
                break;
            }
        }
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

        // Set background color based on selection or other criteria
        // Example: Change background color if date matches departure date

        holder.itemView.setSelected(dateItem.getSelected());

        if (dateItem.getSelected()) {
            onClickDateListener.onClickDate(dateItem.getDatetime());
            //holder.itemView.setBackgroundColor(Color.parseColor("#FFDDA2")); // Yellow color when selected
        }
//        else {
//            //holder.itemView.setBackgroundColor(Color.TRANSPARENT); // Default (transparent) color when not selected
//        }

        // Handle item click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update the selected item
                for (DateItem item : dateList) {
                    item.setSelected(false); // Reset all items
                }
                dateItem.setSelected(true); // Set clicked item as selected
                notifyDataSetChanged(); // Notify adapter of data change
            }

        });




    }

    @Override
    public int getItemCount() {
        return dateList.size();
    }

    public void setDepartureDatetime(String departureDatetime) {
        this.departureDatetime = departureDatetime;
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
