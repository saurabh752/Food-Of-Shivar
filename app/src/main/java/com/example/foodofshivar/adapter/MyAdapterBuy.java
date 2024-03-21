package com.example.foodofshivar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodofshivar.R;

import java.util.List;

public class MyAdapterBuy extends RecyclerView.Adapter<MyViewHolderBuy> {

    Context context;
    List<MyItemBuy> myItemBuys;

    public MyAdapterBuy(Context context, List<MyItemBuy> myItemBuys) {
        this.context = context;
        this.myItemBuys = myItemBuys;
    }

    @NonNull
    @Override
    public MyViewHolderBuy onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new MyViewHolderBuy(LayoutInflater.from(context).inflate(R.layout.buy_again_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderBuy holder, int position) {
        holder.buy_again_name.setText(myItemBuys.get(position).getBuy_again_name());
        holder.buy_again_prise.setText(myItemBuys.get(position).getBuy_again_prise());
        holder.buy_again_btn.setText(myItemBuys.get(position).getBuy_again_btn());
        holder.buy_again_image.setImageResource(myItemBuys.get(position).getBuy_again_image());

    }

    @Override
    public int getItemCount() {
        return myItemBuys.size();
    }
}
