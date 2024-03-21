package com.example.foodofshivar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class PayOutActivity extends AppCompatActivity {
    ImageButton back_btn2;
    Button Place_my_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_out);
        back_btn2 = findViewById(R.id.back_btn2);
        Place_my_order =findViewById(R.id.Place_my_order);
        back_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Place_my_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlaceMyOrderBottomSheetFragment placeMyOrderBottomSheetFragment=new PlaceMyOrderBottomSheetFragment();
                placeMyOrderBottomSheetFragment.show(getSupportFragmentManager(),placeMyOrderBottomSheetFragment.getTag());
            }
        });
    }
}