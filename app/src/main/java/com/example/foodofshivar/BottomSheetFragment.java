package com.example.foodofshivar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodofshivar.adapter.MyAdapterNotification;
import com.example.foodofshivar.adapter.MyItemNotification;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetFragment extends BottomSheetDialogFragment {
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_notification);
        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {
        List<MyItemNotification> myItemNotifications = new ArrayList<>();
        myItemNotifications.add(new MyItemNotification("Your order has been Canceled Successfully", R.drawable.sademoji));
        myItemNotifications.add(new MyItemNotification("Order has been taken by the driver", R.drawable.icon__5_));
        myItemNotifications.add(new MyItemNotification("Congrats Your Order Placed", R.drawable.congratulation));

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);
        MyAdapterNotification adapter = new MyAdapterNotification(requireContext(), myItemNotifications);
        recyclerView.setAdapter(adapter);
    }
}
