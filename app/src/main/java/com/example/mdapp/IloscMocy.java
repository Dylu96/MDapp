package com.example.mdapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IloscMocy extends AppCompatActivity {

    Button oblicziloscmocy;
    private TextView ogrzewaniesuma, cwusuma, sumasuma, zapotrzebowanie1;
    double sumacwu, sumasumasuma, sumaogrzewanie, caloscwodavalue, metrazvalue, wspolczynnik;
    public static final String WODAIL1 = "WODAIL1";
    public static final String WODACALOSC = "WODACALOSC";
    public static final String WYNIKWB4 = "WYNIKWB4";
    public static final String WYSOKOSC4 = "WYSOKOSC4";
    public static final String IZOLACJAG3 = "IZOLACJAG3";
    public static final String STOPNIE2 = "STOPNIE2";
    public static final String STREFA15 = "STREFA15";
    public static final String IZOL4 = "IZOL4";
     String caloscwoda;
     String budrodzajo;
     String metrazb;
    String kosztpaliwa;
    String budrodzajo1;
    String wodail2;
    String wysokoscb, izolacjab, strefaklim, stopnieb, izolb;
    Double wysokoscbvalue, izolacjabvalue, stopniebvalue, strefaklimvalue, izolbvalue;
    String sumaogrzewanie3, zapotrzebowaniesuma, sumasumasuma1;
    String cwusuma3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilosc_mocy);
        ogrzewaniesuma = (TextView) findViewById(R.id.ogrzewaniesuma);
        cwusuma = (TextView) findViewById(R.id.cwusuma);
        sumasuma = (TextView) findViewById(R.id.sumasuma);
        zapotrzebowanie1 = (TextView) findViewById(R.id.zapotrzebowanie1);
        oblicziloscmocy = (Button) findViewById(R.id.oblicziloscmocy);

        Intent wodamoc = getIntent();
        wodail2 = wodamoc.getStringExtra(WODAIL1);
        caloscwoda = wodamoc.getStringExtra(WODACALOSC);
        metrazb = wodamoc.getStringExtra(WYNIKWB4);
        wysokoscb = wodamoc.getStringExtra(WYSOKOSC4);
        izolacjab = wodamoc.getStringExtra(IZOLACJAG3);
        strefaklim = wodamoc.getStringExtra(STREFA15);
        stopnieb = wodamoc.getStringExtra(STOPNIE2);
        izolb = wodamoc.getStringExtra(IZOL4);

        caloscwodavalue = Double.parseDouble(caloscwoda);
        metrazvalue = Double.parseDouble(metrazb);
        wysokoscbvalue = Double.parseDouble(wysokoscb);
        izolacjabvalue = Double.parseDouble(izolacjab);
        stopniebvalue = Double.parseDouble(stopnieb);
        strefaklimvalue =Double.parseDouble(strefaklim);
        izolbvalue = Double.parseDouble(izolb);

        oblicziloscmocy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                wspolczynnik = (metrazvalue * wysokoscbvalue * izolacjabvalue * (stopniebvalue - strefaklimvalue));
                zapotrzebowaniesuma = String.format("%.3f",wspolczynnik);
                zapotrzebowanie1.setText(String.valueOf(zapotrzebowaniesuma + " (W)"));


                sumaogrzewanie = (izolbvalue * metrazvalue);
                sumaogrzewanie3 = String.format("%.3f",sumaogrzewanie);
                ogrzewaniesuma.setText(String.valueOf(sumaogrzewanie3 + " (kWh/rok)"));

                sumacwu = ((caloscwodavalue * 4190 * 45) / (1000 * 3600));
                cwusuma3 = String.format("%.3f",sumacwu);
                cwusuma.setText(String.valueOf(cwusuma3 + " (kWh/rok)"));

                sumasumasuma = sumaogrzewanie + sumacwu;
                sumasumasuma1 = String.format("%.3f", sumasumasuma);
                sumasuma.setText(String.valueOf(sumasumasuma1 + " (kWh/rok)"));

            }
        });
    }

    public void openRodzajZrodla(View view) {
        if (sumasuma.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(),"Wciśnij przycisk 'POKAŻ' aby kontynować.", Toast.LENGTH_SHORT).show();

        }
        else {

           kosztpaliwa = Double.toString(sumasumasuma).trim();
           Intent zrodlorodzaj = new Intent(this, RodzajZrodla.class);
            zrodlorodzaj.putExtra(RodzajZrodla.KOSZT0, kosztpaliwa);
            zrodlorodzaj.putExtra(RodzajZrodla.IZOLACJAG4,izolacjab);
            zrodlorodzaj.putExtra(RodzajZrodla.WODAIL2, wodail2);
            startActivity(zrodlorodzaj);
        }
    }
}