package com.example.mdapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TemperaturaBudynku extends AppCompatActivity {

    public static final String WYNIKWB2 = "WYNIKWB2";
    public static final String WYSOKOSC2 = "WYSOKOSC2";
    public static final String IZOLACJAG = "IZOLACJAG";
    public static final String STREFA12 = "STREFA12";
    public static final String IZOL1 = "IZOL1";
    private RadioGroup ilestopni;
    private RadioButton stopni17,stopni18, stopni19, stopni20, stopni21,stopni22, stopni23, stopni24;
    public TextView stopnieView;
    public String wynikwb0000, wysokosc0000, budrodzaj0000, izolacja0000, strefa0000, izol0000;
    public String wynikwb0001, wysokosc0001, budrodzaj0001, izolacja0001;
    public double stopniedom;
    public String stopniedom0;
    String stopniedom1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura_budynku);

        stopnieView = (TextView) findViewById(R.id.stopnieView);
        stopni17 = (RadioButton) findViewById(R.id.stopni17);
        stopni18 = (RadioButton) findViewById(R.id.stopni18);
        stopni19 = (RadioButton) findViewById(R.id.stopni19);
        stopni20 = (RadioButton) findViewById(R.id.stopni20);
        stopni21 = (RadioButton)findViewById(R.id.stopni21);
        stopni22 = (RadioButton) findViewById(R.id.stopni22);
        stopni23 = (RadioButton) findViewById(R.id.stopni23);
        stopni24 = (RadioButton) findViewById(R.id.stopni24);
        Intent izolacjatemperatura = getIntent();
        wynikwb0000 = izolacjatemperatura.getStringExtra(WYNIKWB2);
        wysokosc0000 = izolacjatemperatura.getStringExtra(WYSOKOSC2);
        izolacja0000 = izolacjatemperatura.getStringExtra(IZOLACJAG);
        strefa0000 = izolacjatemperatura.getStringExtra(STREFA12);
        izol0000 = izolacjatemperatura.getStringExtra(IZOL1);

        stopni17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopniedom = 17.0;
                stopnieView.setText(String.valueOf("Wybrana wartość to " + stopniedom + "°C"));
                String stopniedom0 = Double.toString(stopniedom);
            }
        });
        stopni18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopniedom = 18.0;
                stopnieView.setText(String.valueOf("Wybrana wartość to " + stopniedom + "°C"));
                String stopniedom0 = Double.toString(stopniedom);
            }
        });
        stopni19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopniedom = 19.0;
                stopnieView.setText(String.valueOf("Wybrana wartość to " + stopniedom + "°C"));
                String stopniedom0 = Double.toString(stopniedom);
            }
        });
        stopni20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopniedom = 20.0;
                stopnieView.setText(String.valueOf("Wybrana wartość to " + stopniedom + "°C"));
                String stopniedom0 = Double.toString(stopniedom);
            }
        });
        stopni21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopniedom = 21.0;
                stopnieView.setText(String.valueOf("Wybrana wartość to " + stopniedom + "°C"));
                String stopniedom0 = Double.toString(stopniedom);
            }
        });
        stopni22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopniedom = 22.0;
                stopnieView.setText(String.valueOf("Wybrana wartość to " + stopniedom + "°C"));
                String stopniedom0 = Double.toString(stopniedom);
            }
        });
        stopni23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopniedom = 23.0;
                stopnieView.setText(String.valueOf("Wybrana wartość to " + stopniedom + "°C"));
                String stopniedom0 = Double.toString(stopniedom);
            }
        });
        stopni24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopniedom = 24.0;
                stopnieView.setText(String.valueOf("Wybrana wartość to " + stopniedom + "°C"));
                String stopniedom0 = Double.toString(stopniedom);
            }
        });
    }

    public void openLiczbaMieszkancow(View view) {
        if (stopni17.isChecked() || stopni18.isChecked() || stopni19.isChecked()  || stopni20.isChecked() || stopni21.isChecked() || stopni22.isChecked() || stopni23.isChecked() || stopni24.isChecked()){

            stopniedom1 = Double.toString(stopniedom);
            wynikwb0001 = wynikwb0000;
            budrodzaj0001 = budrodzaj0000;
            wysokosc0001 = wysokosc0000;
            izolacja0001 = izolacja0000;
            Intent temperaturamieszkancy = new Intent(this, LiczbaMieszkancow.class);
            temperaturamieszkancy.putExtra(LiczbaMieszkancow.WYNIKWB3,wynikwb0001);
            temperaturamieszkancy.putExtra(LiczbaMieszkancow.WYSOKOSC3,wysokosc0001);
            temperaturamieszkancy.putExtra(LiczbaMieszkancow.IZOLACJAG1,izolacja0001);
            temperaturamieszkancy.putExtra(LiczbaMieszkancow.STOPNIE1,stopniedom1);
            temperaturamieszkancy.putExtra(LiczbaMieszkancow.STREFA13, strefa0000);
            temperaturamieszkancy.putExtra(LiczbaMieszkancow.IZOL2, izol0000);
            startActivity(temperaturamieszkancy);
        }
        else {
            Toast.makeText(getApplicationContext(),"Brak zaznaczonej izolacji budynku!", Toast.LENGTH_SHORT).show();
        }
    }
}