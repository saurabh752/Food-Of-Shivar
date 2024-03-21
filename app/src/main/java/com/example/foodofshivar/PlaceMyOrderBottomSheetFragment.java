package com.example.foodofshivar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class PlaceMyOrderBottomSheetFragment extends BottomSheetDialogFragment {

    Button Go_home_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_place_my_order_bottom_sheet, container, false);
        Go_home_btn =view.findViewById(R.id.Go_home_btn);
        Go_home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                dismiss();
            }
        });
        return view;
    }
}