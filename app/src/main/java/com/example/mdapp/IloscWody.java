package com.example.mdapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IloscWody extends AppCompatActivity {

    private TextView calkowitezuzyciewartosc;
    private EditText wartosciloscwody;
    Button liczwode;

    double wodail;
    double wodacalosc;
    double wodelicz;

    String metraz2;
    String budrodzaj1;
    String metraz3;
    String budrodzaj2;
    String wodail1;

    public static final String WYNIKWB4 = "WYNIKWB4";
    public static final String LUDZIE1 = "LUDZIE1";
    public static final String WYSOKOSC4 = "WYSOKOSC4";
    public static final String IZOLACJAG2 = "IZOLACJAG2";
    public static final String STOPNIE2 = "STOPNIE2";
    public static final String STREFA14 = "STREFA14";
    public static final String IZOL3 = "IZOL3";

    public String wynikwb000000, wysokosc000000, izolacja000000, stopniedom000000, budrodzaj000000, ludzie000000, strefa000000, izol000000;
    public String wynikwb000001, wysokosc000001, izolacja000001, stopniedom000001,  ludzie000001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilosc_wody);

        calkowitezuzyciewartosc = (TextView)findViewById(R.id.calkowitezyzuciewartosc);
        wartosciloscwody = (EditText)findViewById(R.id.wartosciloscwody);
        liczwode = (Button)findViewById(R.id.liczwode);
        Intent woda = getIntent();
        wynikwb000000 = woda.getStringExtra(WYNIKWB4);
        wysokosc000000 = woda.getStringExtra(WYSOKOSC4);
        izolacja000000 = woda.getStringExtra(IZOLACJAG2);
        stopniedom000000 = woda.getStringExtra(STOPNIE2);
        ludzie000000 = woda.getStringExtra(LUDZIE1);
        strefa000000 = woda.getStringExtra(STREFA14);
        izol000000 = woda.getStringExtra(IZOL3);






        liczwode.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            if(wartosciloscwody.getText().toString().isEmpty())
            {
                Toast.makeText(getApplicationContext(), "Proszę wpisać ilość zużywanej wody!", Toast.LENGTH_SHORT).show();
            }

            else{

               wodail = Double.parseDouble(wartosciloscwody.getText().toString());
               wodelicz = Double.parseDouble(ludzie000000);
               wodacalosc = wodail * wodelicz * 330;
               calkowitezuzyciewartosc.setText(String.valueOf(wodacalosc + "(l)"));


            }

        }
    });

    }
    public void openIloscMocy(View view) {

        if(calkowitezuzyciewartosc.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Wprowadź zużycie wody.", Toast.LENGTH_SHORT).show();
        }
        else
            {
            String caloscwoda = Double.toString(wodacalosc).trim();
            String wodail1 = Double.toString(wodail).trim();
            wynikwb000001 = wynikwb000000;
            wysokosc000001 = wysokosc000000;
            izolacja000001 = izolacja000000;
            stopniedom000001 = stopniedom000000;
            Intent wodamoc = new Intent(IloscWody.this, IloscMocy.class);
            wodamoc.putExtra(IloscMocy.WODAIL1, wodail1);
            wodamoc.putExtra(IloscMocy.WODACALOSC, caloscwoda);
            wodamoc.putExtra(IloscMocy.WYNIKWB4, wynikwb000001);
            wodamoc.putExtra(IloscMocy.WYSOKOSC4, wysokosc000001);
            wodamoc.putExtra(IloscMocy.IZOLACJAG3, izolacja000001);
            wodamoc.putExtra(IloscMocy.STOPNIE2, stopniedom000001);
            wodamoc.putExtra(IloscMocy.STREFA15, strefa000000);
            wodamoc.putExtra(IloscMocy.IZOL4, izol000000);
            startActivity(wodamoc);
             }
    }
}

