package com.example.mdapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IzolacjaBudynku extends AppCompatActivity {

    private RadioGroup numerizo;
    private RadioButton izo1, izo2, izo3, izo4;
    public TextView IzolacjaView;
    public static final String WYNIKWB1 = "WYNIKWB1";
    public static final String WYSOKOSC1 = "WYSOKOSC1";
    public static final String STREFA11 = "STREFA11";
    public String wynikwb000, budrodzaj000, wysokosc000, strefa000;
    Double gizolacja;
    public String gizolacja0;
    public String wynikwb001, budrodzaj001, wysokosc001;
    public String gizolacja1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izolacja_budynku);

        IzolacjaView =(TextView) findViewById(R.id.IzolacjaView);
        izo1 = (RadioButton) findViewById(R.id.izo1);
        izo2 = (RadioButton) findViewById(R.id.izo2);
        izo3 = (RadioButton) findViewById(R.id.izo3);
        izo4 = (RadioButton) findViewById(R.id.izo4);
        Intent rodzajizolacja = getIntent();
        wynikwb000 = rodzajizolacja.getStringExtra(WYNIKWB1);
        wysokosc000 = rodzajizolacja.getStringExtra(WYSOKOSC1);
        strefa000 = rodzajizolacja.getStringExtra(STREFA11);

        izo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IzolacjaView.setText(String.valueOf("Okna z podwójnymi szybami, grube izolowane ściany, izolowany dach, sufity, podłoga i drzwi."));
                gizolacja = 0.75;
                String gizolacja0 = Double.toString(gizolacja);
            }
        });

        izo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IzolacjaView.setText(String.valueOf("Grube ściany, izolowany sufit, niezbyt wiele okien."));
                gizolacja = 0.9;
                String gizolacja0 = Double.toString(gizolacja);
            }
        });

        izo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IzolacjaView.setText(String.valueOf("Budynki ze słabą izolacją, ściany z pojedyńczej warstwy cegieł, okna oraz dach bez izolacji."));
                gizolacja = 1.2;
                String gizolacja0 = Double.toString(gizolacja);
            }
        });

        izo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IzolacjaView.setText(String.valueOf("Budynki nie izolowane, o konstrukcji drewnianej lub metalowej."));
                gizolacja = 1.5;
                String gizolacja0 = Double.toString(gizolacja);
            }
        });


    }

    public void openTemperaturaBudynku(View view) {
        if (izo1.isChecked() || izo2.isChecked() || izo3.isChecked() || izo4.isChecked() ){

            gizolacja1 = Double.toString(gizolacja);

            wynikwb001 = wynikwb000;
            wysokosc001 = wysokosc000;
            Intent izolacjatemperatura = new Intent(this, TemperaturaBudynku.class);
            izolacjatemperatura.putExtra(TemperaturaBudynku.WYNIKWB2,wynikwb001);
            izolacjatemperatura.putExtra(TemperaturaBudynku.WYSOKOSC2,wysokosc001);
            izolacjatemperatura.putExtra(TemperaturaBudynku.IZOLACJAG,gizolacja1);
            izolacjatemperatura.putExtra(TemperaturaBudynku.STREFA12,strefa000);
            startActivity(izolacjatemperatura);
        }
        else {
            Toast.makeText(getApplicationContext(),"Brak zaznaczonej izolacji budynku!", Toast.LENGTH_SHORT).show();
        }
    }
}