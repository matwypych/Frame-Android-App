package com.FrameApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class aktualnosci2 extends Fragment {

    ImageView imageView;
    TextView textView;
   private int obrazek1;
   private int opis1;

    public aktualnosci2(int op, int ob){
        this.obrazek1 = ob;
        this.opis1 = op;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.aktualnosci2_fragment, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);

       // Bundle bundle =  this.getArguments();


            //int obrazek = bundle.getInt("obrazek");
            //int opis = bundle.getInt("opis");

            imageView.setImageResource(aktu.obrazki[obrazek1]);
            textView.setText(aktu.opisy[obrazek1]);

        return view;
    }



}
