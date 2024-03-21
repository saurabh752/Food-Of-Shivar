package com.example.foodofshivar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.foodofshivar.LoginActivity;
import com.example.foodofshivar.R;
import com.google.firebase.auth.FirebaseAuth;


public class ProfileFragment extends Fragment {

    Button log_out;
    private FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);


        log_out = view.findViewById(R.id.log_out);
        firebaseAuth = FirebaseAuth.getInstance();
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logout the user
                firebaseAuth.signOut();

                // Redirect to the login activity
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish(); // Close the current activity (fragment)
            }
        });
        return view;
    }
}