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

import com.example.burgermunch.Object.Order;
import com.example.burgermunch.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.O)
public class OrderAdapter extends Adapter<OrderAdapter.ViewHolder> {
    ArrayList<Order> OrderDomains;

    public OrderAdapter(ArrayList<Order> OrderDomains) {
        this.OrderDomains = OrderDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_lastorder, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int pos) {
        holder.date.setText(OrderDomains.get(pos).getDate());
        holder.statustxt.setText(OrderDomains.get(pos).getStatus());
        //holder.address.setText(OrderDomains.get(pos).getAddress());
        holder.pricetxt.setText(Integer.toString(OrderDomains.get(pos).getTotalPrice())+" שח");
        updateStatusBtn(holder , pos);
    }

    private void updateStatusBtn(OrderAdapter.ViewHolder holder, int position) {
        String btnStatus = OrderDomains.get(position).getStatus();
        if(btnStatus.equals("נשלח למסעדה")) holder.statusBtn.setImageResource(R.drawable.status1);
        if(btnStatus.equals("יצא למשלוח")) holder.statusBtn.setImageResource(R.drawable.status2);
    }

    @Override
    public int getItemCount() {return OrderDomains.size();}

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView date , statustxt ,address ,  pricetxt;
        ImageView statusBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.orderDate);
            statustxt = itemView.findViewById(R.id.statustxt);
            address = itemView.findViewById(R.id.addtxt);
            pricetxt = itemView.findViewById(R.id.fee);
            statusBtn = itemView.findViewById(R.id.statusIMG);
        }
    }

}
