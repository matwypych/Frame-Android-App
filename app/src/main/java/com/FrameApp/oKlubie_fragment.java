package com.FrameApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class oKlubie_fragment extends Fragment implements View.OnClickListener {

    ImageView imageView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_galeria_fragment, container, false);


        LinearLayout linearLayout= (LinearLayout) view.findViewById(R.id.linearLayout);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        for(int i=0;i<7;i++) {
            ImageView localView = new ImageView(getActivity());
            localView.setLayoutParams(new ViewGroup.LayoutParams(300,300));
            localView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int resId = getResources().getIdentifier("r"+i,"drawable",getActivity().getPackageName());
            localView.setImageResource(resId);
            localView.setOnClickListener(this);
            linearLayout.addView(localView);
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        ImageView localView = (ImageView) v;
        imageView.setImageDrawable(localView.getDrawable());
    }


}
