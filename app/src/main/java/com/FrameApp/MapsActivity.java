package com.FrameApp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    private EditText ImieNazwisko, Email, Phone, Wiadomosc;
    private Button SendMessage;
    String ImionaStr, mailStr, PhoneStr, WiadomoscStr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_maps, container, false);
        ImieNazwisko = (EditText) view.findViewById(R.id.ImieNazwisko);
        Email = (EditText) view.findViewById(R.id.Email);
        Phone = (EditText) view.findViewById(R.id.Phone);
        Wiadomosc = (EditText) view.findViewById(R.id.Wiadomosc);
        SendMessage = (Button) view.findViewById(R.id.button);

        SendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImionaStr = String.valueOf(ImieNazwisko.getText());
                mailStr = String.valueOf(Email.getText());
                PhoneStr = String.valueOf(Phone.getText());
                WiadomoscStr = String.valueOf(Wiadomosc.getText());

                if(!isValidEmail(mailStr)) {
                    Toast.makeText(getActivity(),"Wprowadź poprawnego maila! ",Toast.LENGTH_SHORT).show();
                }
                else if(PhoneStr.length()!=9){
                    Toast.makeText(getActivity(),"Wprowadź poprawny nr telefonu! ",Toast.LENGTH_SHORT).show();
                }
                else
                Toast.makeText(getActivity(),"Od: " + ImionaStr + "\n" + "Numer: " + PhoneStr + "\n" + "Wiadomość: " + WiadomoscStr,Toast.LENGTH_SHORT).show();

            }
        });

        mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        if(mapFragment==null)
        {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.map,mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng frame = new LatLng(51.770344, 19.458596);
        mMap.addMarker(new MarkerOptions().position(frame).title("Marker in Lodz Frame"));
        mMap.setMinZoomPreference(12.0f);
        mMap.setMaxZoomPreference(30.0f);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(frame));
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;

        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }


}
