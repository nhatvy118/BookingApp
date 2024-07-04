package com.example.bookingapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingapp.R;

import java.util.List;

public class TravellerAdapter extends RecyclerView.Adapter<TravellerAdapter.TravellerViewHolder> {

    private List<Integer> travellerList; // Assuming travellerList contains numbers

    public TravellerAdapter(List<Integer> travellerList) {
        this.travellerList = travellerList;
    }

    @NonNull
    @Override
    public TravellerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.traveller, parent, false); // Replace with your actual item layout
        return new TravellerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TravellerViewHolder holder, int position) {
        int travellerNumber = travellerList.get(position);
        holder.bind(travellerNumber);
    }

    @Override
    public int getItemCount() {
        return travellerList.size();
    }

    public class TravellerViewHolder extends RecyclerView.ViewHolder {
        TextView travellerTextView;

        public TravellerViewHolder(@NonNull View itemView) {
            super(itemView);
            travellerTextView = itemView.findViewById(R.id.traveller); // Replace with your actual TextView ID
        }

        public void bind(int travellerNumber) {
            travellerTextView.setText(String.valueOf(travellerNumber));
        }
    }
}

