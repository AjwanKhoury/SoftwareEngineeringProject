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

import com.example.burgermunch.Object.Customer;
import com.example.burgermunch.Object.Order;
import com.example.burgermunch.Object.Seats;
import com.example.burgermunch.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.O)
public class OrderAdapterManagement extends Adapter<OrderAdapterManagement.ViewHolder>{
    ArrayList<Order> OrdersDomains;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;

    public OrderAdapterManagement(ArrayList<Order> OrdersDomains) { this.OrdersDomains = OrdersDomains; }

    @NonNull
    @Override
    public OrderAdapterManagement.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_order_management, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapterManagement.ViewHolder holder, int pos) {
        holder.date.setText(OrdersDomains.get(pos).getDate());
        holder.statustxt.setText(OrdersDomains.get(pos).getStatus());
        holder.phone.setText(OrdersDomains.get(pos).getCusPhone());
        holder.pricetxt.setText(Integer.toString(OrdersDomains.get(pos).getTotalPrice())+" שח");
        updateStatusBtn(holder , pos);
        this.databaseReference = db.getReference();
        String cusPhone = OrdersDomains.get(pos).getCusPhone();
        holder.wentDelivery.setOnClickListener(v -> {
            OrdersDomains.get(pos).setStatus("יצא למשלוח");
            updateStatusBtn(holder , pos);
           //TODO update the status on firebase.
        });
    }

    private void updateStatusBtn(ViewHolder holder, int pos) {
        String btnStatus = OrdersDomains.get(pos).getStatus();
        if(btnStatus.equals("נשלח למסעדה")) holder.statusBtn.setImageResource(R.drawable.status1);
        if(btnStatus.equals("יצא למשלוח")) holder.statusBtn.setImageResource(R.drawable.status2);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView date , statustxt  ,phone ,  pricetxt , wentDelivery;
        ImageView statusBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.orderDate);
            statustxt = itemView.findViewById(R.id.statustxt);
            phone = itemView.findViewById(R.id.addtxt2);
            pricetxt = itemView.findViewById(R.id.fee);
            statusBtn = itemView.findViewById(R.id.statusIMG);
            wentDelivery = itemView.findViewById(R.id.addtxt3);
        }
    }
}
