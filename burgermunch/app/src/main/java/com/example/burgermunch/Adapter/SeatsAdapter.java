package com.example.burgermunch.Adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.burgermunch.Object.Seats;
import com.example.burgermunch.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.O)
public class SeatsAdapter extends Adapter<SeatsAdapter.ViewHolder> {
    ArrayList<Seats> SeatsDomains;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;

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
        String temp = Integer.toString(SeatsDomains.get(position).getNumSeats());
        holder.numSeatsTxt.setText(temp);
        holder.timeSeatstxt.setText(SeatsDomains.get(position).getTime());
        holder.name.setText(SeatsDomains.get(position).getFullName());
        updateStatusBtn(holder , position);
        this.databaseReference = db.getReference();
        String key = SeatsDomains.get(position).getPhoneNumber();
        holder.confirmSeat.setOnClickListener(v -> {
            SeatsDomains.get(position).setStatus(2);
            updateStatusBtn(holder , position);
            databaseReference.child("Seats").child(key).setValue(SeatsDomains.get(position));
        });
        holder.rejectSeat.setOnClickListener(v -> {
            SeatsDomains.get(position).setStatus(0);
            updateStatusBtn(holder , position);
            databaseReference.child("Seats").child(key).setValue(SeatsDomains.get(position));
        });
    }

    private void updateStatusBtn(ViewHolder holder, int position) {
        int btnStatus = SeatsDomains.get(position).getStatus();
        if(btnStatus==0) holder.statusBtn.setImageResource(R.drawable.status0);
        if(btnStatus==1) holder.statusBtn.setImageResource(R.drawable.status1);
        if(btnStatus==2) holder.statusBtn.setImageResource(R.drawable.status2);
    }


    @Override
    public int getItemCount() {
        return SeatsDomains.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView numSeatsTxt , timeSeatstxt ,name ,  confirmSeat , rejectSeat;
        ImageView statusBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numSeatsTxt = itemView.findViewById(R.id.numSeatsTxt);
            timeSeatstxt = itemView.findViewById(R.id.timeSeatstxt);
            name = itemView.findViewById(R.id.nameTxt);
            statusBtn = itemView.findViewById(R.id.statusBtn);
            confirmSeat = itemView.findViewById(R.id.confirmSeat);
            rejectSeat = itemView.findViewById(R.id.rejectSeat);
        }
    }
}
