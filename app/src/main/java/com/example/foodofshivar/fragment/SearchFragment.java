package com.example.foodofshivar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodofshivar.R;
import com.example.foodofshivar.adapter.Model;
import com.example.foodofshivar.adapter.MyAdapterMenu;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class SearchFragment extends Fragment {
    RecyclerView recyclerView;
    SearchView searchView;
    MyAdapterMenu myAdapterMenu;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = view.findViewById(R.id.recyclerview_menu1);
        searchView=view.findViewById(R.id.searchView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Menu"), Model.class)
                        .build();
        myAdapterMenu = new MyAdapterMenu(options);

        recyclerView.setAdapter(myAdapterMenu);
//        // Initialize the SearchView
//        searchView = view.findViewById(R.id.searchView);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                // Handle the submit event if needed
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                // Update the adapter with the filtered data based on the search query
//                setFilter(newText);
//                return true;
//            }
//        });
//        // Initialize the adapter with an empty query initially
//        myAdapterMenu.setFilter("",getViewLifecycleOwner());
        return view;

    }

    private void setFilter(String s) {
    }


    public void onStart() {
        super.onStart();
        myAdapterMenu.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        myAdapterMenu.stopListening();
    }


}