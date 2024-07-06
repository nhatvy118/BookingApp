package com.example.bookingapp.Adapter;

import static com.example.bookingapp.Adapter.TravellerAdapter.registerOnClickTravellerListener;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingapp.Flights;
import com.example.bookingapp.OnClickDateListener;
import com.example.bookingapp.OnClickTravellerListener;
import com.example.bookingapp.OnSeatClickListener;
import com.example.bookingapp.R;
import com.example.bookingapp.SelectedSeats;

import java.util.List;

public class SeatAdapter extends RecyclerView.Adapter<SeatAdapter.SeatViewHolder> implements OnClickTravellerListener  {
    private Context mContext;
    private List<Seat> mSeatList;
    private int mcurrentTraveller = 1;
    private static OnSeatClickListener onSeatClickListener;

    public static void registerOnClickSeatListener(SelectedSeats context) {
        onSeatClickListener = (OnSeatClickListener) context;
    }


    public SeatAdapter(Context context, List<Seat> seatList) {
        mContext = context;
        mSeatList = seatList;
    }

    @NonNull
    @Override
    public SeatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_seat, parent, false);
        registerOnClickTravellerListener(this);
        return new SeatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeatViewHolder holder, int position) {
        Seat seat = mSeatList.get(position);
        TextView[] tmp = new TextView[4];
        tmp[0] = holder.view1;
        tmp[1] = holder.view2;
        tmp[2] = holder.view3;
        tmp[3] = holder.view4;
        seat.setSeats(tmp);
        if (seat.getStatus1() == Seat.BOOKED){
            holder.view1.setEnabled(false);
            holder.view1.setEnabled(false);
        }
        if (seat.getStatus2() == Seat.BOOKED){
            holder.view2.setEnabled(false);
        }
        if (seat.getStatus3() == Seat.BOOKED){
            holder.view3.setEnabled(false);
        }
        if (seat.getStatus4() == Seat.BOOKED){
            holder.view4.setEnabled(false);
            }
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
        }
        holder.view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seat.getStatus1() == Seat.BOOKED) {
                    Toast.makeText(mContext, "This seat is already chosen", Toast.LENGTH_SHORT).show();
                }else
                if (seat.getStatus1() == Seat.AVAILABLE){
                    setDefaultSeat();
                    String index = position + "A";
                    onSeatClickListener.onSeatClick(index,mcurrentTraveller);
                    resetSeat(holder.view2, seat, 2,mcurrentTraveller);
                    resetSeat(holder.view3, seat, 3,mcurrentTraveller);
                    resetSeat(holder.view4, seat, 4,mcurrentTraveller);
                    holder.view1.setSelected(true);
                    seat.setStatus1(Seat.SELECTED);
                    seat.setmTraveller1(mcurrentTraveller);
                    holder.view1.setText(String.valueOf(mcurrentTraveller));
                }else
                if (seat.getStatus1() == Seat.SELECTED){
                    holder.view1.setSelected(false);
                    seat.setStatus1(Seat.AVAILABLE);
                    holder.view1.setText("");
                }
            }

        });

        holder.view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seat.getStatus2() == Seat.BOOKED) {
                    Toast.makeText(mContext, "This seat is already chosen", Toast.LENGTH_SHORT).show();
                }else
                if (seat.getStatus2() == Seat.AVAILABLE){
                    setDefaultSeat();
                    String index = position + "B";
                    onSeatClickListener.onSeatClick(index,mcurrentTraveller);
                    resetSeat(holder.view1, seat, 1,mcurrentTraveller);
                    resetSeat(holder.view3, seat, 3,mcurrentTraveller);
                    resetSeat(holder.view4, seat, 4,mcurrentTraveller);
                    holder.view2.setSelected(true);
                    seat.setStatus2(Seat.SELECTED);
                    seat.setmTraveller2(mcurrentTraveller);
                    holder.view2.setText(String.valueOf(mcurrentTraveller));

                }else
                if (seat.getStatus2() == Seat.SELECTED){
                    holder.view2.setSelected(false);
                    seat.setStatus2(Seat.AVAILABLE);
                    holder.view2.setText("");
                }
            }
        });
        holder.view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seat.getStatus3() == Seat.BOOKED) {
                    Toast.makeText(mContext, "This seat is already chosen", Toast.LENGTH_SHORT).show();
                }else
                if (seat.getStatus3() == Seat.AVAILABLE){
                    setDefaultSeat();
                    String index = position + "C";
                    onSeatClickListener.onSeatClick(index,mcurrentTraveller);
                    resetSeat(holder.view1, seat, 1,mcurrentTraveller);
                    resetSeat(holder.view2, seat, 2,mcurrentTraveller);
                    resetSeat(holder.view4, seat, 4,mcurrentTraveller);
                    holder.view3.setSelected(true);
                    seat.setStatus3(Seat.SELECTED);
                    seat.setmTraveller3(mcurrentTraveller);
                    holder.view3.setText(String.valueOf(mcurrentTraveller));
                }else
                if (seat.getStatus3() == Seat.SELECTED){
                    holder.view3.setSelected(false);
                    seat.setStatus3(Seat.AVAILABLE);
                    holder.view3.setText("");
                }

            }
        });
        holder.view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (seat.getStatus4() == Seat.BOOKED) {
                    Toast.makeText(mContext, "This seat is already chosen", Toast.LENGTH_SHORT).show();
                }else
                if (seat.getStatus4() == Seat.AVAILABLE){
                    setDefaultSeat();
                    String index = position + "D";
                    onSeatClickListener.onSeatClick(index,mcurrentTraveller);
                    resetSeat(holder.view1, seat, 1,mcurrentTraveller);
                    resetSeat(holder.view2, seat, 2,mcurrentTraveller);
                    resetSeat(holder.view3, seat, 3,mcurrentTraveller);
                    holder.view4.setSelected(true);
                    seat.setStatus4(Seat.SELECTED);
                    holder.view4.setText(String.valueOf(mcurrentTraveller));
                    seat.setmTraveller4(mcurrentTraveller);
                }else
                if (seat.getStatus4() == Seat.SELECTED){
                    holder.view4.setSelected(false);
                    seat.setStatus4(Seat.AVAILABLE);
                    holder.view4.setText("");
                }
            }

        });

    }

    private void setDefaultSeat() {
        for (Seat s : mSeatList){
            if (s.getStatus1() == Seat.SELECTED && s.getmTraveller1() == mcurrentTraveller){
                TextView view1 = s.getSeats()[0];
                view1.setSelected(false);
                view1.setText("");
                s.setStatus1(Seat.AVAILABLE);
            }
            if (s.getStatus2() == Seat.SELECTED && s.getmTraveller2() == mcurrentTraveller){
                TextView view2 = s.getSeats()[1];
                view2.setSelected(false);
                view2.setText("");
                s.setStatus2(Seat.AVAILABLE);
            }
            if (s.getStatus3() == Seat.SELECTED && s.getmTraveller3() == mcurrentTraveller){
                TextView view3 = s.getSeats()[2];
                view3.setSelected(false);
                view3.setText("");
                s.setStatus3(Seat.AVAILABLE);
            }
            if (s.getStatus4() == Seat.SELECTED && s.getmTraveller4() == mcurrentTraveller){
                TextView view4 = s.getSeats()[3];
                view4.setSelected(false);
                view4.setText("");
                s.setStatus4(Seat.AVAILABLE);
            }
        }

    }

    private void resetSeat(TextView v, Seat seat, int num, int Traveller) {
        if (num == 1 && seat.getStatus1()== Seat.SELECTED) {
            if (seat.getmTraveller1() != Traveller) return;
            seat.setStatus1(Seat.AVAILABLE);
            v.setSelected(false);
            v.setText("");
        }
        if (num == 2 && seat.getStatus2()== Seat.SELECTED) {
            if (seat.getmTraveller2() != Traveller) return;
            seat.setStatus2(Seat.AVAILABLE);
            v.setSelected(false);
            v.setText("");
        }
        if (num == 3 && seat.getStatus3()== Seat.SELECTED) {
            if (seat.getmTraveller3() != Traveller) return;
            seat.setStatus3(Seat.AVAILABLE);
            v.setSelected(false);
            v.setText("");
        }
        if (num == 4 && seat.getStatus4()== Seat.SELECTED) {
            if (seat.getmTraveller4() != Traveller) return;
            seat.setStatus4(Seat.AVAILABLE);
            v.setSelected(false);
            v.setText("");
        }
    }



    @Override
    public int getItemCount() {
        return mSeatList.size();
    }

    @Override
    public void OnTravellerChange(int num) {
        mcurrentTraveller = num;
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

    }

}