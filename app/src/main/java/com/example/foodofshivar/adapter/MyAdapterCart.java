package com.example.foodofshivar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodofshivar.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class MyAdapterCart extends FirebaseRecyclerAdapter<ModelCart, MyAdapterCart.MyviewHolderCart> {


    public MyAdapterCart(@NonNull FirebaseRecyclerOptions<ModelCart> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyviewHolderCart holder, int position, @NonNull ModelCart modelCart) {
        holder.name_item_cart.setText(modelCart.getName());
        holder.Food_price.setText(modelCart.getPrice());
        Glide.with(holder.image_cart.getContext()).load(modelCart.getImage()).into(holder.image_cart);
        // Set click listeners for buttons
        holder.button_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle remove button click
                int currentCount = Integer.parseInt(holder.count_item.getText().toString());
                if (currentCount > 0) {
                    currentCount--;
                    holder.count_item.setText(String.valueOf(currentCount));
                }
            }
        });

        holder.button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle add button click
                int currentCount = Integer.parseInt(holder.count_item.getText().toString());
                currentCount++;
                holder.count_item.setText(String.valueOf(currentCount));
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentCount = Integer.parseInt(holder.count_item.getText().toString());
                if (currentCount > 0) {
                    // If count is greater than 0, decrement the count
                    currentCount--;
                    holder.count_item.setText(String.valueOf(currentCount));

                    // Update the count in the real-time database
                    FirebaseDatabase.getInstance().getReference()
                            .child("carts") // replace with your actual node
                            .child(getRef(position).getKey()) // getRef(position).getKey() gets the item key
                            .child("count")
                            .setValue(currentCount);

                    // If count becomes 0, remove the item from the list
                    if (currentCount == 0) {
                        getRef(position).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    // Item removed from the real-time database, you can also update your UI if needed
                                } else {
                                    // Handle removal failure
                                    Toast.makeText(holder.itemView.getContext(), "Failed to remove item", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        holder.count_item.setText(String.valueOf(currentCount));
                    }
                }
            }
        });
    }




    @NonNull
    @Override
    public MyviewHolderCart onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);
        return new MyAdapterCart.MyviewHolderCart(view);
    }

    class MyviewHolderCart extends RecyclerView.ViewHolder {
        ImageView image_cart,button_remove,button_add,button_delete;
        TextView name_item_cart,Food_price,count_item;
        public MyviewHolderCart(@NonNull View itemView) {
            super(itemView);
            image_cart=itemView.findViewById(R.id.image_cart);
            button_remove=itemView.findViewById(R.id.button_remove);
            button_add=itemView.findViewById(R.id.button_add);
            button_delete=itemView.findViewById(R.id.button_delete);
            name_item_cart=itemView.findViewById(R.id.name_item_cart);
            Food_price=itemView.findViewById(R.id.Food_price);
            count_item=itemView.findViewById(R.id.count_item);
        }
    }
}
