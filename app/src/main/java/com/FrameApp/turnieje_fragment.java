package com.FrameApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.Fragment;

public class turnieje_fragment extends Fragment {

    private Button Ponranking2019,Ponranking2018,Czwranking2018,Czwranking2019,regulamin,regulamin2,Czwranking2017,Czwranking20171,Czwranking20172;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.turnieje_fragment, container, false);


        Ponranking2018 = (Button) view.findViewById(R.id.ponRanking2018);
        Ponranking2019 = (Button) view.findViewById(R.id.ponRanking2019);
        Czwranking2018 = (Button) view.findViewById(R.id.czwRanking2018);
        Czwranking2019 = (Button) view.findViewById(R.id.czwRanking2019);

        Czwranking2017 = (Button) view.findViewById(R.id.button2);
        Czwranking20171 = (Button) view.findViewById(R.id.button3);
        Czwranking20172 = (Button) view.findViewById(R.id.button4);

        regulamin = (Button) view.findViewById(R.id.regulaminId);
        regulamin2 = (Button) view.findViewById(R.id.regulamin2);


        Ponranking2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getFragmentManager().beginTransaction().replace(R.id.Fragment_container,new ranking2018Poniedzialek()).commit();
            }
        });


        Ponranking2019.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.Fragment_container,new ranking2019Poniedzialek()).commit();
            }
        });

        Czwranking2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.Fragment_container,new ranking2018Czwartek()).commit();
            }
        });

        Czwranking2019.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.Fragment_container,new ranking2019Czwartek()).commit();
            }
        });

        regulamin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.Fragment_container,new regulamin_fragment()).commit();
            }
        });


        Czwranking2017.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.Fragment_container,new ranking2018Czwartek()).commit();
            }
        });

        Czwranking20171.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.Fragment_container,new ranking2018Czwartek()).commit();
            }
        });

        Czwranking20172.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.Fragment_container,new ranking2018Czwartek()).commit();
            }
        });
        regulamin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.Fragment_container,new regulamin_fragment()).commit();
            }
        });


        return view;
    }
}
