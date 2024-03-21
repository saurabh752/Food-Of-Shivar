package com.example.foodofshivar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodofshivar.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MyAdapterPopu extends FirebaseRecyclerAdapter<Modelpop,MyAdapterPopu.MyviewHolderPopu> {

    public MyAdapterPopu(@NonNull FirebaseRecyclerOptions<Modelpop> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyAdapterPopu.MyviewHolderPopu holder, int position, @NonNull Modelpop modelpop) {
        holder.name_Pop_item.setText(modelpop.getName());
        holder.price_Pop_item.setText(modelpop.getPrice());
        Glide.with(holder.image_Pop_item.getContext()).load(modelpop.getImage()).into(holder.image_Pop_item);
        holder.Pop_item_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call a method to add the item to the user's cart
                addToCart(modelpop, position);
            }
        });


    }

    private void addToCart(Modelpop modelpop, int position) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {

            // Assume you have a "cart" node in your Firebase database
            DatabaseReference cartRef = FirebaseDatabase.getInstance().getReference().child("carts");

            // Get the selected item's key from the adapter using the provided position

            String selectedItemKey = getRef(position).getKey();
            // Create a HashMap to store item details
            Map<String, Object> cartItem = new HashMap<>();
            cartItem.put("name", modelpop.getName());
            cartItem.put("price", modelpop.getPrice());
            cartItem.put("image", modelpop.getImage());

            // Add the item to the user's cart using the key and item details
            cartRef.child(selectedItemKey).setValue(cartItem);
        }

    }


    @NonNull
    @Override
    public MyAdapterPopu.MyviewHolderPopu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item,parent,false);
        return new MyAdapterPopu.MyviewHolderPopu(view);
    }

    class MyviewHolderPopu extends RecyclerView.ViewHolder{

        ImageView image_Pop_item;
        TextView name_Pop_item ,price_Pop_item,Pop_item_add_to_cart;

        public MyviewHolderPopu(@NonNull View itemView) {
            super(itemView);
            image_Pop_item=itemView.findViewById(R.id.image_Pop_item);
            name_Pop_item=itemView.findViewById(R.id.name_Pop_item);
            price_Pop_item=itemView.findViewById(R.id.price_Pop_item);
            Pop_item_add_to_cart=itemView.findViewById(R.id.Pop_item_add_to_cart);
        }
    }
}
