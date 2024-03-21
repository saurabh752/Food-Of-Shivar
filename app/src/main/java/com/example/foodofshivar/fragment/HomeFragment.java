package com.example.foodofshivar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.foodofshivar.R;
import com.example.foodofshivar.adapter.Modelpop;
import com.example.foodofshivar.adapter.MyAdapterPopu;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    RecyclerView recyclerview_menu1;
    TextView Menu_btn;
  MyAdapterPopu myAdapterPopu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerview_menu1 = view.findViewById(R.id.recyclerview_menu1);
        recyclerview_menu1.setLayoutManager(new LinearLayoutManager(requireContext()));
        try {
            FirebaseRecyclerOptions<Modelpop> options = new FirebaseRecyclerOptions.Builder<Modelpop>()
                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Menu"), Modelpop.class)
                    .build();
            myAdapterPopu = new MyAdapterPopu(options);
            recyclerview_menu1.setAdapter(myAdapterPopu);
            myAdapterPopu = new MyAdapterPopu(options);
            recyclerview_menu1.setAdapter(myAdapterPopu);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception, show a toast, or log an error message.
        }

//        Menu_btn = view.findViewById(R.id.Menu_btn);
//        Menu_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), MenuButtonActivity.class);
//                startActivity(intent);
//            }
//        });


        return view;
    }


    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list
        imageList.add(new SlideModel(R.drawable.banner1, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2, ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3, ScaleTypes.FIT));
        ImageSlider imageSlider = view.findViewById(R.id.image_slider1);
        imageSlider.setImageList(imageList);
    }
    public void onStart() {
        super.onStart();
        if (myAdapterPopu != null) {
            myAdapterPopu.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (myAdapterPopu != null) {
            myAdapterPopu.stopListening();
        }
    }


}