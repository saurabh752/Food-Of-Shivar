package com.example.foodofshivar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodofshivar.R;
import com.example.foodofshivar.adapter.MyAdapterBuy;
import com.example.foodofshivar.adapter.MyItemBuy;

import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView RecyclerView_buy_again;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView= view.findViewById(R.id.RecyclerView_buy_again);
        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {
        List<MyItemBuy> myItemBuys = new ArrayList<>();
        myItemBuys.add(new MyItemBuy("Herbal Pancake", "$8","Add To Cart" ,R.drawable.menu1));
        myItemBuys.add(new MyItemBuy("Herbal Pancake", "$8","Add To Cart" ,R.drawable.menu1));
        myItemBuys.add(new MyItemBuy("Herbal Pancake", "$8","Add To Cart" ,R.drawable.menu1));

        myItemBuys.add(new MyItemBuy("Herbal Pancake", "$8","Add To Cart" ,R.drawable.menu1));

        myItemBuys.add(new MyItemBuy("Herbal Pancake", "$8","Add To Cart" ,R.drawable.menu1));

        myItemBuys.add(new MyItemBuy("Herbal Pancake", "$8","Add To Cart" ,R.drawable.menu1));

        myItemBuys.add(new MyItemBuy("Herbal Pancake", "$8","Add To Cart" ,R.drawable.menu1));




        // Set RecyclerView layout manager and adapter
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);
        MyAdapterBuy adapter = new MyAdapterBuy(requireContext(), myItemBuys);
        recyclerView.setAdapter(adapter);
    }
}