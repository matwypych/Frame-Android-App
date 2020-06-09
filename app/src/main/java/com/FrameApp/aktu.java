package com.FrameApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class aktu extends Fragment {


   public static Integer[] obrazki = new Integer[10];
   public static String[] opisy = new String[9];

    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.aktualnosci_fragment, container, false);

        for (int i = 0; i < obrazki.length; i++) {
            obrazki[i] = getResources().getIdentifier
                    ("a" + i, "drawable", getActivity().getPackageName());

            imageView = (ImageView) view.findViewById(R.id.imageView);
            final GridView gridView = (GridView) view.findViewById(R.id.gridView);

            opisy[0] = "W związku z przerwą świąteczną ogłaszamy dni zamknięcia klubu." + "\n" + "Wesołych Świąt!";
            opisy[1] = "Rozpoczynamy sezon Lódzkiej ligi bilardowej. Wszelkie informacje zawarte są na plakacie." + "\n" + "Zapraszmy do wzięcia udziału";
            opisy[2] = "Zapraszamy na turniej amatorski. Będzie on trwać od maja do września." + "\n" + " Co tydzień inna odmiana. Przewidziane są nagrody !";
            opisy[3] = "Zapraszamy na Eliminacje do Mistrzostw Polski Amatorów !!!\n" +
                    "\n" +
                    "Klub otwarty od g.11 start g.12 .";
            opisy[4] = "UWAGA!!!! 11 stycznia zaczynamy eliminacji do Europool Amateur Championship - Summer Masters 9-ball !\n" +
                    "\n" +
                    "Jak co czwartek gramy od 19, zapisy do 18:45!!!\n" +
                    "Prowadzone będą 2 rankingi-jeden dla turnieju, który trwa już od października i nowy od 11 stycznia!!\n" +
                    "\n" +
                    "Zapraszamy!!!!!!!\n" +
                    "\n";
            opisy[5]="Zapraszamy na Eliminacje do Mistrzostw Polski Amatorów 2018 !!!!!!!\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "18.03.2018\n" +
                    "15.04.2018\n" +
                    "27.05.2018\n" +
                    "10.06.2018\n" +
                    "16.09.2018 UWAGA ZMIANA TERMINU!!!!!!!";
            opisy[6]="Sezon Old Boya rozpoczęty!!!\n" +
                    "\n" +
                    "W miniony weekend w klubie Frame zakończyły się pierwsze tegoroczne występy „starszaków”.\n" +
                    "\n" +
                    "Na starcie stanęło 25 par z apetytem na zgarnięcie puli , która wyniosła okrągłe 2500 zł!!!!\n"+
                    "Dziękujemy wszystkim uczestnikom za wyśmienitą atmosferę i sportową rywalizacje na najwyższym poziomie!!!\n"+
                    "Mamy nadzieję, że w jeszcze szerszym gronie spotkamy się na kolejnych zawodach w klubie Frame!!!";
            opisy[7]="W niedzielę poznaliśmy nowy mistrzowski duet Oldboya. Po bardzo wyrównanym pojedynku, tuż przed północą złoty puchar trafił do Tomasza Młodzińskiego i Jacka Wrzosa. Wicemistrzami zostali faworyzowani tego dnia Roman Wasilewski i Jakub Mokosa.\n" +
                    "\n" +
                    "Z brązowego krążka cieszyli się Filip Kraupe i Rafał Stępnik oraz Tomasz Wendicki i Remigiusz Warpas.";
            opisy[8]="WCZORAJ ZAWODNIK NASZEGO KLUBU RAFAŁ OLBROMSKI WYWALCZYŁ BRĄZOWY MEDAL W MISTRZOSTWACH POLSKI OLD BOYS!!!\n" + "GRATULUJEMY!!!!!!";

            gridView.setAdapter(new ImageAdapter());
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    Bundle bundle = new Bundle();

                    bundle.putInt("obrazek",position);
                    bundle.putInt("opis",position);
                    System.out.println("pozycja w aktu " + position);
                    aktualnosci2 ak = new aktualnosci2(position,position);
                    ak.setArguments(bundle);

                   getFragmentManager().beginTransaction().replace(R.id.Fragment_container,new aktualnosci2(position,position)).commit();


            }
            });

        }
        return view;
    }

    private class ImageAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return obrazki.length;
        }

        @Override
        public Object getItem(int position) {
            return obrazki[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ImageView imageView;
            if(convertView==null)
            {
                imageView=new ImageView(getActivity().getApplicationContext());
                imageView.setLayoutParams(new GridView.LayoutParams(400,400));
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setPadding(1,1,1,1);
            }
            else
            {
                imageView=(ImageView) convertView;
            }
            imageView.setImageResource(obrazki[position]);
            return imageView;
        }
    }

}