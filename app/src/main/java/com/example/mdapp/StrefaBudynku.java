package com.example.mdapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StrefaBudynku extends AppCompatActivity {


    ImageView helpstrefa;
    Dialog dialogstrefa;
    RadioGroup wyborStrefy;
    RadioButton strefa1, strefa2, strefa3, strefa4, strefa5;
    TextView strefaview;
    public String strefawartosc1;
    public String budynkuliczba;
    public String budynkuliczbavalue;
    public static final String LICZBUD0 = "LICZBUD0";
    String budliczba0;
    String budliczba1;
    Double strefawartosc;
    String strefawartosc2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strefa_budynku);
        strefaview = (TextView) findViewById(R.id.strefaview);
        helpstrefa = findViewById(R.id.helpstrefa);
        strefa1 = (RadioButton) findViewById(R.id.strefa1);
        strefa2 = (RadioButton) findViewById(R.id.strefa2);
        strefa3 = (RadioButton) findViewById(R.id.strefa3);
        strefa4 = (RadioButton) findViewById(R.id.strefa4);
        strefa5 = (RadioButton) findViewById(R.id.strefa5);
        Intent wymiary = getIntent();
        budliczba0 = wymiary.getStringExtra(LICZBUD0);
       dialogstrefa = new Dialog(this);

        helpstrefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openstrefa();

            }
        });

        strefa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strefaview.setText(String.valueOf("Strefa I"));
                strefawartosc = -16.0;
                String strefawartosc1 = Double.toString(strefawartosc);
            }
        });
        strefa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strefaview.setText(String.valueOf("Strefa II"));
                strefawartosc = -18.0;
                String strefawartosc1 = Double.toString(strefawartosc);
            }
        });
        strefa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strefaview.setText(String.valueOf("Strefa III"));
                strefawartosc = -20.0;
                String strefawartosc1 = Double.toString(strefawartosc);
            }
        });
        strefa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strefaview.setText(String.valueOf("Strefa IV"));
                strefawartosc = -22.0;
                String strefawartosc1 = Double.toString(strefawartosc);
            }
        });
        strefa5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strefaview.setText(String.valueOf("Strefa V"));
                strefawartosc = -24.0;
                String strefawartosc1 = Double.toString(strefawartosc);
            }
        });
    }

    private void openstrefa() {
        dialogstrefa.setContentView(R.layout.mapastref);
        dialogstrefa.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        Button closestrefa = dialogstrefa.findViewById(R.id.closestrefa);

        closestrefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogstrefa.dismiss();
            }
        });
        dialogstrefa.show();
    }

    public void openWymiaryBudynku(View view) {
        if (strefa1.isChecked() || strefa2.isChecked() || strefa3.isChecked() || strefa4.isChecked() || strefa5.isChecked()) {


            budliczba1 = budliczba0;
            strefawartosc2 = Double.toString(strefawartosc);

            Intent strefawymiary = new Intent(this, WymiaryBudynku.class);
            strefawymiary.putExtra(WymiaryBudynku.STREFA1,strefawartosc2);
            strefawymiary.putExtra(WymiaryBudynku.LICZBABUD1, budliczba1);
            startActivity(strefawymiary);


        }
        else {

            Toast.makeText(getApplicationContext(),"Brak wybranej strefy!", Toast.LENGTH_SHORT).show();
        }
    }

}