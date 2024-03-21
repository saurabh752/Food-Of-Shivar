package com.example.foodofshivar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodofshivar.adapter.Model;
import com.example.foodofshivar.adapter.MyAdapterMenu;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class MenuButtonActivity extends AppCompatActivity {
    RecyclerView recyclerview_menu;
    MyAdapterMenu myAdapterMenu;
    ImageButton back_btn;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_button);
        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        user = FirebaseAuth.getInstance().getCurrentUser();
        recyclerview_menu = findViewById(R.id.recyclerview_menu);
        recyclerview_menu.setLayoutManager(new LinearLayoutManager(this));
        if (user != null) {
            FirebaseRecyclerOptions<Model> options =
                    new FirebaseRecyclerOptions.Builder<Model>()
                            .setQuery(FirebaseDatabase.getInstance().getReference().child("Menu"), Model.class)
                            .build();
            myAdapterMenu = new MyAdapterMenu(options);
            recyclerview_menu.setAdapter(myAdapterMenu);

        }
    }
    protected void onStart() {
        super.onStart();
        if(myAdapterMenu != null){
            myAdapterMenu.startListening();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(myAdapterMenu != null){
            myAdapterMenu.stopListening();
        }
    }

}
