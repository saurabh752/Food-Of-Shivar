package com.example.foodofshivar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodofshivar.PayOutActivity;
import com.example.foodofshivar.R;
import com.example.foodofshivar.adapter.ModelCart;
import com.example.foodofshivar.adapter.MyAdapterCart;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class CartFragment extends Fragment {

    RecyclerView recyclerview_menu1;
    Button button_proceed;
    MyAdapterCart myAdapterCart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        recyclerview_menu1 = view.findViewById(R.id.recyclerview_menu1);
        recyclerview_menu1.setLayoutManager(new LinearLayoutManager(requireContext()));
            FirebaseRecyclerOptions<ModelCart> options =
                    new FirebaseRecyclerOptions.Builder<ModelCart>()
                            .setQuery(FirebaseDatabase.getInstance().getReference().child("carts"), ModelCart.class)
                            .build();
            myAdapterCart = new MyAdapterCart(options);
            recyclerview_menu1.setAdapter(myAdapterCart);


        button_proceed=view.findViewById(R.id.button_proceed);
        button_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), PayOutActivity.class);
                startActivity(intent);

            }
        });

        return view;

    }


public void onStart() {
    super.onStart();
    if(myAdapterCart != null){
        myAdapterCart.startListening();
    }

}

    @Override
    public void onStop() {
        super.onStop();
        if(myAdapterCart != null){
            myAdapterCart.stopListening();
        }
    }
}