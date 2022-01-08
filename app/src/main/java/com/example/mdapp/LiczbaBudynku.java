package com.example.mdapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LiczbaBudynku extends AppCompatActivity {
    private RadioGroup liczbabudynkow;
    private RadioButton liczbaparter, liczbapietro;
    public TextView wynikliczbabudynku;
    public Double budynkuliczba;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liczba_budynku);


        wynikliczbabudynku = (TextView) findViewById(R.id.wynikliczbabudynku);
        liczbaparter = (RadioButton) findViewById(R.id.liczbaparter);
        liczbapietro = (RadioButton) findViewById(R.id.liczbapietro);

        liczbaparter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                wynikliczbabudynku.setText(String.valueOf("Budynek parterowy"));
                budynkuliczba = 1.0;
            }
        });

        liczbapietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                wynikliczbabudynku.setText(String.valueOf("Budynek jednopiętrowy"));
                budynkuliczba = 2.0;

            }
        });



    }


    public void openStrefaBudynku(View view) {
        if (liczbaparter.isChecked() || liczbapietro.isChecked())
        {
            String budynkuliczba1 = Double.toString(budynkuliczba);
            Intent wymiary = new Intent(this, StrefaBudynku.class);
            wymiary.putExtra(StrefaBudynku.LICZBUD0,budynkuliczba1);
            startActivity(wymiary);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Proszę wybrać rodzaj budynku!", Toast.LENGTH_SHORT).show();
        }

    }
}
