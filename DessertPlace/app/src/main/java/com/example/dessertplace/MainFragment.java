package com.example.dessertplace;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


public class MainFragment extends Fragment {
//    declare variables
    String personName;
    EditText perName;
    Button submitClick;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
//        describe person name view
        perName = view.findViewById(R.id.personName);
//        get string from EditText
        personName = perName.getText().toString();

//        define submit button to set onclick
        submitClick = view.findViewById(R.id.button);
        submitClick.setOnClickListener(view1 -> {

//                define an intent
            Intent intent = new Intent(getActivity(), SecondActivity.class);

//                put personName in intent
            intent.putExtra("personName", personName);

//                send the intent to secondActivity
            startActivity(intent);
        });
        return view;
    }

}