package com.example.mdapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LiczbaMieszkancow extends AppCompatActivity {

   private RadioGroup calalista;
   private RadioButton listam1, listam2, listam3, listam4, listam5, listam6, listam7, listam8, listam9, listam10;
   public TextView wyswietlliczbemieszkancow;
    public static final String WYNIKWB3 = "WYNIKWB3";
    public static final String WYSOKOSC3 = "WYSOKOSC3";
    public static final String IZOLACJAG1 = "IZOLACJAG1";
    public static final String STOPNIE1 = "STOPNIE1";
    public static final String STREFA13 = "STREFA13";
    public static final String IZOL2 = "IZOL2";
    public String wynikwb00000, wysokosc00000, budrodzaj00000, izolacja00000, stopniedom00000, strefa00000, izol00000;
    public String wynikwb00001, wysokosc00001, budrodzaj00001, izolacja00001, stopniedom00001;
   Double iloscludzi;
   String iloscludzi0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liczba_mieszkancow);

        wyswietlliczbemieszkancow = (TextView) findViewById(R.id.wyswietliczbemieszkancow);
        listam1 = (RadioButton)findViewById(R.id.listam1);
        listam2 = (RadioButton)findViewById(R.id.listam2);
        listam3 = (RadioButton)findViewById(R.id.listam3);
        listam4 = (RadioButton)findViewById(R.id.listam4);
        listam5 = (RadioButton)findViewById(R.id.listam5);
        listam6 = (RadioButton)findViewById(R.id.listam6);
        listam7 = (RadioButton)findViewById(R.id.listam7);
        listam8 = (RadioButton)findViewById(R.id.listam8);
        listam9 = (RadioButton)findViewById(R.id.listam9);
        listam10 = (RadioButton)findViewById(R.id.listam10);
        Intent temperaturamieszkancy = getIntent();
        wynikwb00000 = temperaturamieszkancy.getStringExtra(WYNIKWB3);
        wysokosc00000 = temperaturamieszkancy.getStringExtra(WYSOKOSC3);
        izolacja00000 = temperaturamieszkancy.getStringExtra(IZOLACJAG1);
        stopniedom00000 = temperaturamieszkancy.getStringExtra(STOPNIE1);
        strefa00000 = temperaturamieszkancy.getStringExtra(STREFA13);
        izol00000 = temperaturamieszkancy.getStringExtra(IZOL2);


        listam1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                wyswietlliczbemieszkancow.setText(String.valueOf("1 osoba"));
                iloscludzi = 1.0;
            }
        });

        listam2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                wyswietlliczbemieszkancow.setText(String.valueOf("2 osoby"));
                iloscludzi = 2.0;
            }
        });

        listam3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                wyswietlliczbemieszkancow.setText(String.valueOf("3 osoby"));
                iloscludzi = 3.0;
            }
        });

        listam4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                wyswietlliczbemieszkancow.setText(String.valueOf("4 osoby"));
                iloscludzi = 4.0;
            }
        });

        listam5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                wyswietlliczbemieszkancow.setText(String.valueOf("5 osób"));
                iloscludzi = 5.0;
            }
        });

        listam6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                wyswietlliczbemieszkancow.setText(String.valueOf("6 osób"));
                iloscludzi = 6.0;
            }
        });

        listam7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                wyswietlliczbemieszkancow.setText(String.valueOf("7 osób"));
                iloscludzi = 7.0;
            }
        });

        listam8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                wyswietlliczbemieszkancow.setText(String.valueOf("8 osób"));
                iloscludzi = 8.0;
            }
        });

        listam9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                wyswietlliczbemieszkancow.setText(String.valueOf("9 osób"));
                iloscludzi = 9.0;
            }
        });

        listam10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                wyswietlliczbemieszkancow.setText(String.valueOf("10 osób"));
                iloscludzi = 10.0;
            }
        });
    }

    public void openIloscWody(View view) {
        if (listam1.isChecked() || listam2.isChecked() || listam3.isChecked() || listam4.isChecked() || listam5.isChecked() || listam6.isChecked() || listam7.isChecked() || listam8.isChecked() || listam9.isChecked() || listam10.isChecked()){
            iloscludzi0 = Double.toString(iloscludzi);
            wynikwb00001 = wynikwb00000;
            wysokosc00001 = wysokosc00000;
            izolacja00001 = izolacja00000;
            stopniedom00001 = stopniedom00000;
            Intent woda = new Intent(this, IloscWody.class);
            woda.putExtra(IloscWody.LUDZIE1, iloscludzi0);
            woda.putExtra(IloscWody.WYNIKWB4, wynikwb00001);
            woda.putExtra(IloscWody.WYSOKOSC4, wysokosc00001);
            woda.putExtra(IloscWody.IZOLACJAG2, izolacja00001);
            woda.putExtra(IloscWody.STOPNIE2, stopniedom00001);
            woda.putExtra(IloscWody.STREFA14, strefa00000);
            woda.putExtra(IloscWody.IZOL3, izol00000);
            startActivity(woda);
        }
        else {
            Toast.makeText(getApplicationContext(),"Brak zaznaczonej liczby osób!", Toast.LENGTH_SHORT).show();
        }
    }
}