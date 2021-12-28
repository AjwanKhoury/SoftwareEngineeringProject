package com.example.burgermunch.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.burgermunch.Domain.OrderDetails;
import com.example.burgermunch.Helper.ManagementCart;
import com.example.burgermunch.Helper.ChangeNumberItemsListener;
import com.example.burgermunch.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    ArrayList<OrderDetails> listFoodSelected;
    private ManagementCart managementCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartListAdapter(ArrayList<OrderDetails> listFoodSelected, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.listFoodSelected = listFoodSelected;
        managementCart = new ManagementCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(listFoodSelected.get(position).getTitle());
        holder.feeEachItem.setText(listFoodSelected.get(position).getFee()+" ש״ח");
        holder.description.setText(listFoodSelected.get(position).getDescription());
        holder.minusItem.setOnClickListener(v -> managementCart.minusNumberFood(listFoodSelected, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.changed();
        }));

        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(listFoodSelected.get(position).getPic(), "drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.pic);

    }


    @Override
    public int getItemCount() {
        return listFoodSelected.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, feeEachItem,description;
        ImageView pic, minusItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            pic = itemView.findViewById(R.id.pic);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            minusItem = itemView.findViewById(R.id.minusCardBtn);
            description = itemView.findViewById(R.id.Description);
        }
    }
}
