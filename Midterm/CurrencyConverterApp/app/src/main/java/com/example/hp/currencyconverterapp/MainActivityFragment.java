package com.example.hp.currencyconverterapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container,false);
        Button convertBnt = (Button) view.findViewById(R.id.button);
        final EditText usdollar = (EditText) view.findViewById(R.id.editText);
        final TextView tv = (TextView)view.findViewById(R.id.textView3);


        convertBnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double us = Double.valueOf(usdollar.getText().toString());
                double francs = us*586.84;

                tv.setText(String.valueOf(francs));

            }
        });
        return view;
    }
}
