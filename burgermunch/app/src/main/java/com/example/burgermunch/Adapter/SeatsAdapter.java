package com.example.burgermunch.Adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.burgermunch.Object.Seats;
import com.example.burgermunch.R;

import java.util.ArrayList;

public class SeatsAdapter extends RecyclerView.Adapter<SeatsAdapter.ViewHolder> {
    ArrayList<Seats> SeatsDomains;

    public SeatsAdapter(ArrayList<Seats> SeatsDomains) {
        this.SeatsDomains = SeatsDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_seats, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.numSeatsTxt.setText(SeatsDomains.get(position).getNumSeats());
        holder.timeSeatstxt.setText(SeatsDomains.get(position).getTime());
        updateStatusBtn(holder , position);
        holder.confirmSeat.setOnClickListener(v -> {
            SeatsDomains.get(position).setStatus(2);
            updateStatusBtn(holder , position);
        });
        holder.rejectSeat.setOnClickListener(v -> {
            SeatsDomains.get(position).setStatus(0);
            updateStatusBtn(holder , position);
        });
    }

    private void updateStatusBtn(ViewHolder holder, int position) {
        int btnStatus = SeatsDomains.get(position).getStatus();
        if(btnStatus==0) holder.statusBtn.setImageDrawable(Drawable.createFromPath("burgermunch/app/src/main/res/drawable/status0.png"));
        if(btnStatus==1) holder.statusBtn.setImageDrawable(Drawable.createFromPath("burgermunch/app/src/main/res/drawable/status1.png"));
        if(btnStatus==2) holder.statusBtn.setImageDrawable(Drawable.createFromPath("burgermunch/app/src/main/res/drawable/status2.png"));
    }


    @Override
    public int getItemCount() {
        return SeatsDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView numSeatsTxt , timeSeatstxt , confirmSeat , rejectSeat;
        ImageView statusBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numSeatsTxt = itemView.findViewById(R.id.numSeatsTxt);
            timeSeatstxt = itemView.findViewById(R.id.timeSeatstxt);
            statusBtn = itemView.findViewById(R.id.statusBtn);
            confirmSeat = itemView.findViewById(R.id.confirmSeat);
            rejectSeat = itemView.findViewById(R.id.rejectSeat);
        }
    }
}
