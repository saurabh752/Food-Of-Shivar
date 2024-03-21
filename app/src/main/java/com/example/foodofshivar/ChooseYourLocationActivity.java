package com.example.foodofshivar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseYourLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_your_location);
        // Define your list of locations
        String[] locations = {"Pune", "Mumbai", "Solapur", "sangli", "Baramati"};

// Create an ArrayAdapter using the string array and a default layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, locations);

// Get reference to your AutoCompleteTextView
        AutoCompleteTextView locationTextView = findViewById(R.id.loction_of_name);

// Set the adapter to the AutoCompleteTextView
        locationTextView.setAdapter(adapter);
        Intent intent;
        intent=new Intent(ChooseYourLocationActivity.this,MainActivity.class);
        startActivity(intent);
        finish();






    }
}