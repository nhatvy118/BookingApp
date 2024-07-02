package com.example.bookingapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.bookingapp.R;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {

    private List<TicketItem> ticketList;
    private Context context;

    public TicketAdapter(List<TicketItem> ticketList, Context context) {
        this.ticketList = ticketList;
        this.context = context;
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ticket_item, parent, false);
        return new TicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder holder, int position) {
        TicketItem ticketItem = ticketList.get(position);
        holder.dateValue.setText(ticketItem.getDate());
        holder.departureValue.setText(ticketItem.getDepartureTime());
        holder.priceValue.setText(ticketItem.getPrice());
        holder.numberValue.setText(ticketItem.getFlightNumber());
    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }

    public static class TicketViewHolder extends RecyclerView.ViewHolder {
        TextView dateValue;
        TextView departureValue;
        TextView priceValue;
        TextView numberValue;

        public TicketViewHolder(@NonNull View itemView) {
            super(itemView);
            dateValue = itemView.findViewById(R.id.dateValue);
            departureValue = itemView.findViewById(R.id.departureValue);
            priceValue = itemView.findViewById(R.id.priceValue);
            numberValue = itemView.findViewById(R.id.numberValue);
        }
    }
}
