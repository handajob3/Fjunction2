package com.example.handa.fjunction2;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Home extends Fragment {


    FloatingActionButton fab1;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        View view =  inflater.inflate(R.layout.activity_home, container, false);

       fab1 = (FloatingActionButton) view.findViewById(R.id.fab);
        fab1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getActivity(), Tabupload.class);
                startActivity(intent);
            }
        });
return view ;
    }
}

