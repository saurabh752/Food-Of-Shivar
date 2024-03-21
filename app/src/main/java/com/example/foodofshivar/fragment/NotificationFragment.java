package com.example.foodofshivar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodofshivar.R;
import com.example.foodofshivar.adapter.MyAdapterNotification;
import com.example.foodofshivar.adapter.MyItemNotification;

import java.util.ArrayList;
import java.util.List;


public class NotificationFragment extends Fragment {
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_notification);
        setupRecyclerView();
        return view;  }

    private void setupRecyclerView() {
        List<MyItemNotification> myItemNotifications = new ArrayList<>();
        myItemNotifications.add(new MyItemNotification("Your order has been Canceled Successfully", R.drawable.path290));
        myItemNotifications.add(new MyItemNotification("Your order has been Canceled Successfully", R.drawable.path290));
        myItemNotifications.add(new MyItemNotification("Your order has been Canceled Successfully", R.drawable.path290));

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);
        MyAdapterNotification adapter = new MyAdapterNotification(requireContext(), myItemNotifications);
        recyclerView.setAdapter(adapter);

    }
}