package com.example.mdapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RodzajZrodla extends AppCompatActivity {

    private RadioGroup roznerodzaje;
    private RadioButton radioPrad, radioOlejOpal, radioGazPlyn, radioGazZiemny, radioWegielOrzech, radioEkogroszek, radioPellet, radioDrewno, radioPompaPow, radioPompaGrunt;
    public TextView pokazRodzaj;
    public static final String KOSZT0 = "KOSZT0";
    public static final String WODAIL2 = "WODAIL2";
    public static final String IZOLACJAG4 = "IZOLACJAG4";
    Double cenapal;
    Double emisjaCO2;
    Double emisjaCO;
    Double emisjaSO2;
    Double sprawnosc;
    Double emisjaNOX;
    Double opal;
    String budowastandard;
    String wodail3;

    String cenapal1;
    String emisjaCO21;
    String emisjaCO1;
    String emisjaSO21;
    String emisjaNOX1;
    String kosztpaliwa1;
    String budowastandard1;
    String sprawnosc1;
    String opal1;

    public String kosztpaliwa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodzaj_zrodla);

        pokazRodzaj = (TextView)findViewById(R.id.pokazRodzaj);
        radioPrad = (RadioButton) findViewById(R.id.radioPrad);
        radioOlejOpal = (RadioButton) findViewById(R.id.radioOlejOpal);
        radioGazPlyn = (RadioButton) findViewById(R.id.radioGazPlyn);
        radioGazZiemny = (RadioButton) findViewById(R.id.radioGazZiemny);
        radioWegielOrzech = (RadioButton) findViewById(R.id.radioWegielOrzech);
        radioEkogroszek = (RadioButton) findViewById(R.id.radioEkogroszek);
        radioPellet = (RadioButton) findViewById(R.id.radioPellet);
        radioDrewno = (RadioButton) findViewById(R.id.radioDrewno);
        radioPompaPow = (RadioButton) findViewById(R.id.radioPompaPow);
        radioPompaGrunt =(RadioButton) findViewById(R.id.radioPompaGrunt);
        Intent zrodlorodzaj = getIntent();
        kosztpaliwa = zrodlorodzaj.getStringExtra(KOSZT0);
        budowastandard = zrodlorodzaj.getStringExtra(IZOLACJAG4);
        wodail3 = zrodlorodzaj.getStringExtra(WODAIL2);


        radioPrad.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pokazRodzaj.setText(String.valueOf("Prąd"));
                cenapal = 0.636;
                emisjaCO2 = 0.0;
                emisjaCO = 0.0;
                emisjaSO2 = 0.0;
                emisjaNOX = 0.0;
                sprawnosc = 0.99;
                opal = 1.0;

            }
        });

        radioOlejOpal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pokazRodzaj.setText(String.valueOf("Olej opałowy"));
                cenapal =0.287;
                emisjaCO2 =0.280;
                emisjaCO = 0.000168;
                emisjaSO2 =0.000566;
                emisjaNOX =0.00020004;
                sprawnosc = 0.90;
                opal = 11.0;

            }
        });

        radioGazPlyn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pokazRodzaj.setText(String.valueOf("Gaz płynny"));
                cenapal = 0.255;
                emisjaCO2 =0.218;
                emisjaCO = 0.000128;
                emisjaSO2 =0.00000346;
                emisjaNOX =0.0000948;
                sprawnosc = 0.98;
                opal = 7.0;
            }
        });

        radioGazZiemny.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pokazRodzaj.setText(String.valueOf("Gaz ziemny"));
                cenapal = 0.207;
                emisjaCO2 =0.214;
                emisjaCO = 0.000126;
                emisjaSO2 =0.00000346;
                emisjaNOX =0.0000925;
                sprawnosc = 0.98;
                opal = 10.0;
            }
        });

        radioWegielOrzech.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pokazRodzaj.setText(String.valueOf("Węgiel orzech"));
                cenapal = 0.180;
                emisjaCO2 =0.679;
                emisjaCO = 0.02797;
                emisjaSO2 =0.00384;
                emisjaNOX =0.0005597;
                sprawnosc = 0.70;
                opal = 7.0;
            }
        });

        radioEkogroszek.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pokazRodzaj.setText(String.valueOf("Węgiel ekogroszek"));
                cenapal = 0.166;
                emisjaCO2 =0.605;
                emisjaCO = 0.0249;
                emisjaSO2 =0.00342;
                emisjaNOX =0.0004984;
                sprawnosc = 0.75;
                opal = 7.0;
            }
        });

        radioPellet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pokazRodzaj.setText(String.valueOf("Pellet drzewny"));
                cenapal = 0.265;
                emisjaCO2 =0.079;
                emisjaCO = 0.00233;
                emisjaSO2 =0.000239;
                emisjaNOX =0.000231;
                sprawnosc = 0.8;
                opal = 5.0;

            }
        });

        radioDrewno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pokazRodzaj.setText(String.valueOf("Drewno opałowe"));
                cenapal = 0.183;
                emisjaCO2 =0.029;
                emisjaCO = 0.0177;
                emisjaSO2 =0.00879;
                emisjaNOX =0.000288;
                sprawnosc = 0.6;
                opal = 4.0;
            }
        });

        radioPompaPow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pokazRodzaj.setText(String.valueOf("Pompa ciepła powietrzna"));
                cenapal = 0.172;
                emisjaCO2 =0.0;
                emisjaCO = 0.0;
                emisjaSO2 =0.0;
                emisjaNOX =0.0;
                sprawnosc = 2.5;
                opal = 1.0;
            }
        });

        radioPompaGrunt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pokazRodzaj.setText(String.valueOf("Pompa ciepła gruntowa"));
                cenapal = 0.158;
                emisjaCO2 =0.0;
                emisjaCO = 0.0;
                emisjaSO2 =0.0;
                emisjaNOX =0.0;
                sprawnosc = 4.0;
                opal = 1.0;
            }
        });
    }

    public void openKosztPaliwa(View view) {
        if (pokazRodzaj.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(),"Wybierz paliwo używanego źródła grzewczego!", Toast.LENGTH_SHORT).show();

        }
        else {

            cenapal1 = Double.toString(cenapal).trim();
            emisjaCO21 = Double.toString(emisjaCO2).trim();
            emisjaCO1 = Double.toString(emisjaCO).trim();
            emisjaSO21 = Double.toString(emisjaSO2).trim();
            emisjaNOX1 = Double.toString(emisjaNOX).trim();
            sprawnosc1 = Double.toString(sprawnosc).trim();
            opal1 = Double.toString(opal).trim();
            kosztpaliwa1 = kosztpaliwa;
            budowastandard1 = budowastandard;

            Intent zrodlapaliwo = new Intent(this, KosztPaliwa.class);
            zrodlapaliwo.putExtra(KosztPaliwa.KOSZT1, kosztpaliwa1);
            zrodlapaliwo.putExtra(KosztPaliwa.CENA1, cenapal1);
            zrodlapaliwo.putExtra(KosztPaliwa.CO21, emisjaCO21);
            zrodlapaliwo.putExtra(KosztPaliwa.CO1,emisjaCO1);
            zrodlapaliwo.putExtra(KosztPaliwa.SO21,emisjaSO21);
            zrodlapaliwo.putExtra(KosztPaliwa.NOX1,emisjaNOX1);
            zrodlapaliwo.putExtra(KosztPaliwa.IZOLACJAG5,budowastandard1);
            zrodlapaliwo.putExtra(KosztPaliwa.WODAIL3, wodail3);
            zrodlapaliwo.putExtra(KosztPaliwa.SPR1, sprawnosc1);
            zrodlapaliwo.putExtra(KosztPaliwa.OPAL0, opal1);
            startActivity(zrodlapaliwo);
        }
    }
}