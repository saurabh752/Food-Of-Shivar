package com.example.foodofshivar.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodofshivar.R;

public class MyViewHolderNotification extends RecyclerView.ViewHolder{
    ImageView notification_imageView;
    TextView notification_textView;
    public MyViewHolderNotification(@NonNull View itemView) {
        super(itemView);
        notification_imageView=itemView.findViewById(R.id.notification_imageView);
        notification_textView=itemView.findViewById(R.id.notification_textView);
    }
}
