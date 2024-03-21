package com.example.foodofshivar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
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

public class MyAdapterMenu extends FirebaseRecyclerAdapter<Model,MyAdapterMenu.MyviewHolderMenu> {
    public MyAdapterMenu(@NonNull FirebaseRecyclerOptions<Model> options) {
        super(options);
    }



//    // Add a method to set the filter based on search query
//    public void setFilter(String searchText, LifecycleOwner viewLifecycleOwner) {
//        FirebaseRecyclerOptions<Model> filteredOptions = new FirebaseRecyclerOptions.Builder<Model>()
//                .setQuery(FirebaseDatabase.getInstance().getReference().child("Menu").orderByChild("name").startAt(searchText).endAt(searchText + ""), Model.class)
//                .setLifecycleOwner((LifecycleOwner) this)
//                .build();
//
//        // Update the adapter with the filtered options
//        updateOptions(filteredOptions);
//    }
    @Override
    protected void onBindViewHolder(@NonNull MyviewHolderMenu holder, int position, @NonNull Model model) {
        holder.name_menu_item.setText(model.getName());
        holder.price_menu_item.setText(model.getPrice());
        Glide.with(holder.image_menu_item.getContext()).load(model.getImage()).into(holder.image_menu_item);

        holder.menu_item_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call a method to add the item to the user's cart
                addToCart(model,position);
            }
        });

    }



    private void addToCart(Model model,int position) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {

            // Assume you have a "cart" node in your Firebase database
            DatabaseReference cartRef = FirebaseDatabase.getInstance().getReference().child("carts");


            // Get the selected item's key from the adapter using the provided position


            String selectedItemKey = getRef(position).getKey();

            // Create a HashMap to store item details
            Map<String, Object> cartItem = new HashMap<>();
            cartItem.put("name", model.getName());
            cartItem.put("price", model.getPrice());
            cartItem.put("image", model.getImage());

            // Add the item to the user's cart using the key and item details
            cartRef.child(selectedItemKey).setValue(cartItem);
        }
    }




    @NonNull
    @Override
    public MyviewHolderMenu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
        return new MyviewHolderMenu(view);
    }

    class MyviewHolderMenu extends RecyclerView.ViewHolder {
        ImageView image_menu_item;
        TextView name_menu_item ,price_menu_item,menu_item_add_to_cart;
        public MyviewHolderMenu(@NonNull View itemView) {
            super(itemView);
            image_menu_item=itemView.findViewById(R.id.image_menu_item);
            name_menu_item=itemView.findViewById(R.id.name_menu_item);
            price_menu_item=itemView.findViewById(R.id.price_menu_item);
            menu_item_add_to_cart=itemView.findViewById(R.id.menu_item_add_to_cart);

        }
    }
}
