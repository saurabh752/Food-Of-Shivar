package com.example.foodofshivar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodofshivar.R;

import java.util.List;

public class MyAdapterNotification extends RecyclerView.Adapter<MyViewHolderNotification>{

    Context context;
    List<MyItemNotification> myItemNotifications;

    public MyAdapterNotification(Context context, List<MyItemNotification> myItemNotifications) {
        this.context = context;
        this.myItemNotifications = myItemNotifications;
    }

    @NonNull
    @Override
    public MyViewHolderNotification onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolderNotification(LayoutInflater.from(context).inflate(R.layout.notification_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderNotification holder, int position) {
        holder.notification_textView.setText(myItemNotifications.get(position).getNotification_textView());
        holder.notification_imageView.setImageResource(myItemNotifications.get(position).getNotification_imageView());

    }

    @Override
    public int getItemCount() {
        return myItemNotifications.size();
    }
}
