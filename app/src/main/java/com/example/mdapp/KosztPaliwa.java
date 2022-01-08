package com.example.mdapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class KosztPaliwa extends AppCompatActivity {

    public static final String KOSZT1 = "KOSZT1";
    public static final String CENA1 = "CENA1";
    public static final String CO21 = "CO21";
    public static final String CO1 = "CO1";
    public static final String SO21 = "SO21";
    public static final String NOX1 = "NOX1";
    public static final String IZOLACJAG5 = "IZOLACJAG5";
    public static final String WODAIL3 = "WODAIL3";
    public static final String SPR1 = "SPR1";
    public static final String OPAL0 = "OPAL0";
    Button btnkwh, btnpaliwa, dalejOstatnieOkno;
    private TextView cenadomyslna, textkoszt;
    EditText cenapaliwa, cenakwh;
    private String koszt21, cena21, co221, coo21, so221, nox21, standard21,sprawnosc11, opal11, cenadomyslna1;
    double domyslnacena, cenakwh1, cenapaliwa1, sprawnosccena, opalcena, kosztjednostkowy;
    String valuecena1, valueco21, valueco1, valueso21, valuenox1, wodail41, paliwko, kosztjednostkowy1, kosztjednostkowy2, kosztjednostkowy3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koszt_paliwa);

        btnkwh = (Button) findViewById(R.id.btnkwh);
        btnpaliwa = (Button) findViewById(R.id.btnpaliwa);
        dalejOstatnieOkno = (Button) findViewById(R.id.dalejOstatnieOkno);
        cenadomyslna = (TextView) findViewById(R.id.cenadomyslna);
        cenapaliwa = (EditText) findViewById(R.id.cenapaliwa);
        cenakwh = (EditText) findViewById(R.id.cenakwh);
        textkoszt = (TextView) findViewById(R.id.textkoszt);

        Intent zrodlakoszty = getIntent();
        koszt21 = zrodlakoszty.getStringExtra(KOSZT1);
        cena21 = zrodlakoszty.getStringExtra(CENA1);
        co221 = zrodlakoszty.getStringExtra(CO21);
        coo21 = zrodlakoszty.getStringExtra(CO1);
        so221 = zrodlakoszty.getStringExtra(SO21);
        nox21 = zrodlakoszty.getStringExtra(NOX1);
        standard21 = zrodlakoszty.getStringExtra(IZOLACJAG5);
        wodail41 = zrodlakoszty.getStringExtra(WODAIL3);
        sprawnosc11 = zrodlakoszty.getStringExtra(SPR1);
        opal11 = zrodlakoszty.getStringExtra(OPAL0);

        domyslnacena = Double.parseDouble(cena21);
        cenadomyslna.setText(String.valueOf(domyslnacena + " kWh/zł"));
        kosztjednostkowy2 = Double.toString(domyslnacena);
        if(domyslnacena == 0.636)
        {
            paliwko = "pracę elektrycznego źródła grzewczego";

        }
        else if(domyslnacena == 0.287)
        {
            paliwko = "litr oleju opałowego";
        }
        else if(domyslnacena == 0.255)
        {
            paliwko = "litr płynnego gazu";
        }
        else if(domyslnacena == 0.207)
        {
            paliwko = "m3 gazu ziemnego";
        }
        else if(domyslnacena == 0.180){
            paliwko = "kilogram węgla";
        }
        else if(domyslnacena == 0.166){
            paliwko = "kilogram ekogroszku";
        }
        else if(domyslnacena == 0.265){
            paliwko = "kilogram pelletu";
        }
        else if(domyslnacena == 0.183){
            paliwko = "kilogram drewna";
        }
        else if(domyslnacena == 0.172){
            paliwko = "pracę pompy ciepła powietrznej";
        }
        else paliwko = "pracę pompy ciepła gruntowej";

        textkoszt.setText(String.valueOf("Cena za " + paliwko));

        btnkwh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cenakwh.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Proszę wpisać cenę za 1kWh", Toast.LENGTH_SHORT).show();
                }
                else{

                    cenakwh1 = Double.parseDouble(cenakwh.getText().toString());
                    cenadomyslna.setText(String.valueOf(cenakwh1 + " kWh/zł"));
                    kosztjednostkowy2 = Double.toString(cenakwh1);
                }

            }
        });

        btnpaliwa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cenapaliwa.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Proszę wpisać cenę jednostkową za paliwo", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(domyslnacena == 0.636){
                        opalcena =  1.0;
                        sprawnosccena = 99.0;

                    }
                    else if(domyslnacena == 0.287){
                        sprawnosccena = 90.0;
                        opalcena = 11.0;
                    }
                    else if(domyslnacena == 0.255){
                        sprawnosccena = 98.0;
                        opalcena = 7.0;
                    }
                    else if(domyslnacena == 0.207){
                        sprawnosccena = 98.0;
                        opalcena = 10.0;
                    }
                    else if(domyslnacena == 0.180){
                        sprawnosccena = 70.0;
                        opalcena = 7.0;
                    }
                    else if(domyslnacena == 0.166){
                        sprawnosccena = 75.0;
                        opalcena = 7.0;
                    }
                    else if(domyslnacena == 0.265){
                        sprawnosccena = 80.0;
                        opalcena = 5.0;
                    }
                    else if(domyslnacena == 0.183){
                        sprawnosccena = 60.0;
                        opalcena = 4.0;
                    }
                    else if(domyslnacena == 0.172){
                        sprawnosccena = 250.0;
                        opalcena = 1.0;
                    }
                    else{
                        sprawnosccena= 400.0;
                        opalcena = 1.0;
                    }


                    cenapaliwa1 = Double.parseDouble(cenapaliwa.getText().toString());
                    kosztjednostkowy = (1/((sprawnosccena/100) * opalcena)) * cenapaliwa1;
                    kosztjednostkowy1 = Double.toString(kosztjednostkowy);
                    kosztjednostkowy3 =String.format("%.3f", kosztjednostkowy);
                    cenadomyslna.setText(String.valueOf(kosztjednostkowy3 + " kWh/zł"));
                    kosztjednostkowy2 = kosztjednostkowy1;
                }

            }
        });
    }


    public void openRoczneKoszty(View view) {
        if (cenadomyslna.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(), "Wybierz paliwo używanego źródła grzewczego!", Toast.LENGTH_SHORT).show();

        } else {
            Intent zrodlakoszty = new Intent(this, RoczneKoszty.class);
            zrodlakoszty.putExtra(RoczneKoszty.KOSZT2, koszt21);
            zrodlakoszty.putExtra(RoczneKoszty.CENA2, cena21);
            zrodlakoszty.putExtra(RoczneKoszty.CO22, co221);
            zrodlakoszty.putExtra(RoczneKoszty.CO2, coo21);
            zrodlakoszty.putExtra(RoczneKoszty.SO22, so221);
            zrodlakoszty.putExtra(RoczneKoszty.NOX2, nox21);
            zrodlakoszty.putExtra(RoczneKoszty.IZOLACJAG6, standard21);
            zrodlakoszty.putExtra(RoczneKoszty.WODAIL4, wodail41);
            zrodlakoszty.putExtra(RoczneKoszty.PALIWOCENA1, kosztjednostkowy2);
            startActivity(zrodlakoszty);
        }
    }
}
