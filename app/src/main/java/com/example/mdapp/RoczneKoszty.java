package com.example.mdapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RoczneKoszty extends AppCompatActivity {

    public static final String KOSZT2 = "KOSZT2";
    public static final String CENA2 = "CENA2";
    public static final String CO22 = "CO22";
    public static final String CO2 = "CO2";
    public static final String SO22 = "SO22";
    public static final String NOX2 = "NOX2";
    public static final String IZOLACJAG6 = "IZOLACJAG6";
    public static final String WODAIL4 = "WODAIL4";
    public static final String PALIWOCENA1 = "PALIWOCENA1";
    Button caleZestawienie;
    private TextView wyswietlKoszty, wyswietlEmisjaCO2, wyswietlEmisjaCO, wyswietlEmisjaSO2, wyswietlEmisjaNOx;
    private String koszt2, cena2, co22, co2, so22, nox2, standard2, paliwocena1;
    double kosztvalue, cenavalue, co2value, covalue, so2value, noxvalue, standardvalue;
    double valuecena, valueco2, valueco, valueso2, valuenox, wodavalue;
    String valuecena1 , valueco21, valueco1, valueso21, valuenox1, wodail4, cenapaliwo111;
    TextView opisStandard, opisWoda, opisZrodlo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roczne_koszty);
        wyswietlKoszty = (TextView) findViewById(R.id.wyswietlKoszty);
        wyswietlEmisjaCO2 = (TextView) findViewById(R.id.wyswietlEmisjaCO2);
        wyswietlEmisjaCO = (TextView) findViewById(R.id.wyswietlEmisjaCO);
        wyswietlEmisjaSO2 = (TextView) findViewById(R.id.wyswietlEmisjaSO2);
        wyswietlEmisjaNOx = (TextView) findViewById(R.id.wyswietlEmisjaNOx);
        caleZestawienie = (Button) findViewById(R.id.caleZestawienie);
        Intent zrodlakoszty = getIntent();
        koszt2 = zrodlakoszty.getStringExtra(KOSZT2);
        cena2 = zrodlakoszty.getStringExtra(CENA2);
        co22 = zrodlakoszty.getStringExtra(CO22);
        co2 = zrodlakoszty.getStringExtra(CO2);
        so22 = zrodlakoszty.getStringExtra(SO22);
        nox2 = zrodlakoszty.getStringExtra(NOX2);
        standard2 =zrodlakoszty.getStringExtra(IZOLACJAG6);
        wodail4 = zrodlakoszty.getStringExtra(WODAIL4);
        cenapaliwo111 = zrodlakoszty.getStringExtra(PALIWOCENA1);

        kosztvalue = Double.parseDouble(koszt2);
        cenavalue = Double.parseDouble(cenapaliwo111);
        co2value = Double.parseDouble(co22);
        covalue = Double.parseDouble(co2);
        so2value = Double.parseDouble(so22);
        noxvalue = Double.parseDouble(nox2);
        standardvalue = Double.parseDouble(standard2);
        wodavalue = Double.parseDouble(wodail4);
        opisStandard = (TextView)findViewById(R.id.opisStandard);
        opisWoda = (TextView)findViewById(R.id.opisWoda);
        opisZrodlo = (TextView)findViewById(R.id.opisZrodlo);

        caleZestawienie.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                valuecena = kosztvalue * cenavalue;
                valueco2 = kosztvalue * co2value;
                valueco = kosztvalue * covalue;
                valueso2 = kosztvalue * so2value;
                valuenox = kosztvalue * noxvalue;
                valuecena1 = String.format("%.2f",valuecena);
                valueco21 = String.format("%.3f",valueco2);
                valueco1 = String.format("%.3f",valueco);
                valueso21 = String.format("%.3f",valueso2);
                valuenox1 = String.format("%3.3f",valuenox);
                wyswietlKoszty.setText(String.valueOf(valuecena1 + " (zł/rok)"));
                wyswietlEmisjaCO2.setText(String.valueOf(valueco21 + " (kg/rok)"));
                wyswietlEmisjaCO.setText(String.valueOf(valueco1 + " (kg/rok)"));
                wyswietlEmisjaSO2.setText(String.valueOf(valueso21 + " (kg/rok)"));
                wyswietlEmisjaNOx.setText(String.valueOf(valuenox1 + " (kg/rok)"));

                ///////////TERMOMODERNIZACJA//////////
                if(standardvalue > 100000) {
                    opisStandard.setTextColor(Color.parseColor("#FC0300"));
                    opisStandard.setText(String.valueOf("Wymagana termomodernizacja budynku, znacząco zredukuje to  koszty eksploatacyjne oraz emisję gazów."));
                }
                else if(standardvalue < 100000 && standardvalue > 90000) {
                        opisStandard.setTextColor(Color.parseColor("#C73C07"));
                        opisStandard.setText(String.valueOf("Warto zastanowić się nad przeprowadzeniem termomodernizacji budynku, zredukje ona koszty eksploatacyjne oraz emisję gazów."));
                    }
                else if (standardvalue < 100000 && standardvalue < 90000 && standardvalue > 60000) {
                        opisStandard.setTextColor(Color.parseColor("#FFC000"));
                        opisStandard.setText(String.valueOf("Zalecana termomodernizacja w celu zmniejszenia kosztów eksploatacyjnych oraz emisji gazów."));
                    }
                else {
                        opisStandard.setTextColor(Color.parseColor("#008000"));
                        opisStandard.setText(String.valueOf("Termomodernizacja jest zbędna."));
                    }

                ///////////WODA/////////////
                if(wodavalue > 80) {
                    opisWoda.setTextColor(Color.parseColor("#FC0300"));
                    opisWoda.setText(String.valueOf("Wymagane oszczędzenie CWU, znacząco zredukuje to koszty eksploatacyjne oraz emisję gazów."));
                }
                else if(wodavalue < 80 && wodavalue >= 60) {
                    opisWoda.setTextColor(Color.parseColor("#C73C07"));
                    opisWoda.setText(String.valueOf("Warto zastanowić się nad oszczędzeniem CWU, zredukje to koszty eksploatacyjne oraz emisję gazów."));
                }
                else if (wodavalue < 80 && wodavalue < 60 && wodavalue > 40) {
                    opisWoda.setTextColor(Color.parseColor("#FFC000"));
                    opisWoda.setText(String.valueOf("Zalecane oszczędzanie CWU w celu zmniejszenia kosztów eksploatacyjnych oraz emisji gazów."));
                }
                else if (wodavalue == 0) {
                    opisWoda.setTextColor(Color.parseColor("#000000"));
                    opisWoda.setText(String.valueOf("Twoje urządzenie grzewcze nie zasila CWU."));
                }
                else {
                    opisWoda.setTextColor(Color.parseColor("#008000"));
                    opisWoda.setText(String.valueOf("Oszczędnie korzystasz z CWU."));
                }

                ///////////ZRODLO/////////////
                if(cenavalue > 0.5) {
                    opisZrodlo.setTextColor(Color.parseColor("#FC0300"));
                    opisZrodlo.setText(String.valueOf("Wymagana zmiana urządzenia grzewczego, znacząco zredukuje to koszty związane z eksploatacją."));
                }
                else if(covalue > 0.027) {
                    opisZrodlo.setTextColor(Color.parseColor("#FC0300"));
                    opisZrodlo.setText(String.valueOf("Wymagana zmiana urządzenia grzewczego, znacząco zredukuje to emisję gazów cieplarnianych."));
                }
                else if(cenavalue < 0.5 && cenavalue > 0.25 ) {
                    opisZrodlo.setTextColor(Color.parseColor("#FFC000"));
                    opisZrodlo.setText(String.valueOf("Warto zastanowić się nad zmianą urządzenia grzewczego zredukje to koszty eksploatacyjne."));
                }
                else if (covalue < 0.027 && covalue > 0.01) {
                    opisZrodlo.setTextColor(Color.parseColor("#FFC000"));
                    opisZrodlo.setText(String.valueOf("Warto zastanowić się nad zmianą urządzenia grzewczego zredukje to emisję gazów cieplarnianych."));
                }
                else {
                    opisZrodlo.setTextColor(Color.parseColor("#008000"));
                    opisZrodlo.setText(String.valueOf("Wymiana urządzenia grzewczego jest zbędna."));
                }


                }
        });


    }
}