package com.example.bookingapp.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bookingapp.R;
import java.util.List;

public class SeatAdapter extends RecyclerView.Adapter<SeatAdapter.SeatViewHolder> {

    private Context mContext;
    private List<Seat> mSeatList;

    public SeatAdapter(Context context, List<Seat> seatList) {
        mContext = context;
        mSeatList = seatList;
    }

    @NonNull
    @Override
    public SeatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_seat, parent, false);
        return new SeatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeatViewHolder holder, int position) {
        Seat seat = mSeatList.get(position);

        if (position == 0) {
            // Header row setup
            holder.view1.setBackgroundColor(Color.TRANSPARENT);
            holder.view2.setBackgroundColor(Color.TRANSPARENT);
            holder.view3.setBackgroundColor(Color.TRANSPARENT);
            holder.view4.setBackgroundColor(Color.TRANSPARENT);
            holder.numTextView.setBackgroundColor(Color.TRANSPARENT);
            holder.view1.setText("A");
            holder.view2.setText("B");
            holder.view3.setText("C");
            holder.view4.setText("D");
            holder.numTextView.setText("");
        } else {
            // Seat row setup
            holder.numTextView.setBackgroundColor(Color.TRANSPARENT);
            holder.numTextView.setText(String.valueOf(seat.getNum()));

            // Set click listeners for seat views
            holder.bind(seat, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int clickedViewId = view.getId();

                    // Update seat status based on the clicked view
                    if (clickedViewId == R.id.seatView1) {
                        seat.setStatus1(getNextStatus(seat.getStatus1()));
                    } else if (clickedViewId == R.id.seatView2) {
                        seat.setStatus2(getNextStatus(seat.getStatus2()));
                    } else if (clickedViewId == R.id.seatView3) {
                        seat.setStatus3(getNextStatus(seat.getStatus3()));
                    } else if (clickedViewId == R.id.seatView4) {
                        seat.setStatus4(getNextStatus(seat.getStatus4()));
                    }

                    // Notify the adapter about the data change
                    notifyItemChanged(holder.getAdapterPosition());
                }
            });
        }
    }

    // Helper method to cycle through seat statuses
    private int getNextStatus(int currentStatus) {
        if (currentStatus == Seat.AVAILABLE) {
            return Seat.SELECTED;
        } else if (currentStatus == Seat.SELECTED) {
            return Seat.AVAILABLE;
        }
        return currentStatus; // No change for BOOKED seats
    }

    @Override
    public int getItemCount() {
        return mSeatList.size();
    }

    public static class SeatViewHolder extends RecyclerView.ViewHolder {
        TextView numTextView;
        TextView view1;
        TextView view2;
        TextView view3;
        TextView view4;

        public SeatViewHolder(@NonNull View itemView) {
            super(itemView);
            numTextView = itemView.findViewById(R.id.num);
            view1 = itemView.findViewById(R.id.seatView1);
            view2 = itemView.findViewById(R.id.seatView2);
            view3 = itemView.findViewById(R.id.seatView3);
            view4 = itemView.findViewById(R.id.seatView4);
        }

        // Bind data to the view holder and apply styles
        public void bind(Seat seat, View.OnClickListener clickListener) {
            // Set click listeners for each seat view
            view1.setOnClickListener(clickListener);
            view2.setOnClickListener(clickListener);
            view3.setOnClickListener(clickListener);
            view4.setOnClickListener(clickListener);


            // Set the selected and enabled states of the seat views
            view1.setSelected(seat.getStatus1() == Seat.SELECTED);
            view1.setEnabled(seat.getStatus1() != Seat.BOOKED);

            view2.setSelected(seat.getStatus2() == Seat.SELECTED);
            view2.setEnabled(seat.getStatus2() != Seat.BOOKED);

            view3.setSelected(seat.getStatus3() == Seat.SELECTED);
            view3.setEnabled(seat.getStatus3() != Seat.BOOKED);

            view4.setSelected(seat.getStatus4() == Seat.SELECTED);
            view4.setEnabled(seat.getStatus4() != Seat.BOOKED);
        }
    }
}