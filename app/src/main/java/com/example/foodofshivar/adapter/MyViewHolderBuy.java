package com.example.foodofshivar.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.foodofshivar.R;

public class MyViewHolderBuy extends ViewHolder{

    ImageView buy_again_image;
    TextView buy_again_name,buy_again_prise,buy_again_btn;

    public MyViewHolderBuy(@NonNull View itemView) {
        super(itemView);
        buy_again_image=itemView.findViewById(R.id.buy_again_image);
        buy_again_name=itemView.findViewById(R.id.buy_again_name);
        buy_again_prise=itemView.findViewById(R.id.buy_again_prise);
        buy_again_btn=itemView.findViewById(R.id.buy_again_btn);

    }


}
