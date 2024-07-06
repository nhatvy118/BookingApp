package com.example.bookingapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingapp.Flights;
import com.example.bookingapp.OnClickDateListener;
import com.example.bookingapp.OnClickTravellerListener;
import com.example.bookingapp.R;
import com.example.bookingapp.SelectedSeats;

import java.util.List;

public class TravellerAdapter extends RecyclerView.Adapter<TravellerAdapter.TravellerViewHolder> {

    private List<Traveller> travellerList;
    private static OnClickTravellerListener onClickTravellerListener;

    public static void registerOnClickTravellerListener(SeatAdapter context) {
        onClickTravellerListener = (OnClickTravellerListener) context;
    }


    public TravellerAdapter(List<Traveller> travellerList) {
        this.travellerList = travellerList;
    }

    @NonNull
    @Override
    public TravellerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.traveller, parent, false);
        return new TravellerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TravellerViewHolder holder, int position) {
        Traveller traveller = travellerList.get(position);
        holder.bind(traveller);
        holder.itemView.setSelected(traveller.getIsSelect());
        holder.itemView.setOnClickListener(v -> {
            for (Traveller item : travellerList) {
                item.setIsSelect(false);
            }
            traveller.setIsSelect(true);
            onClickTravellerListener.OnTravellerChange(position + 1);
            notifyDataSetChanged();
        });

    }

    @Override
    public int getItemCount() {
        return travellerList.size();
    }

    public class TravellerViewHolder extends RecyclerView.ViewHolder {
        TextView travellerTextView;

        public TravellerViewHolder(@NonNull View itemView) {
            super(itemView);
            travellerTextView = itemView.findViewById(R.id.traveller);
        }

        public void bind(Traveller traveller) {
            travellerTextView.setText(String.valueOf(traveller.getNumber()));
        }
    }
}
