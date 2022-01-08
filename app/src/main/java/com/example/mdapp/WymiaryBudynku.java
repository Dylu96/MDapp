package com.example.mdapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WymiaryBudynku extends AppCompatActivity {

    private TextView wynikwymiarybudynku;
    private EditText wbnumber1, wbnumber2, wbnumber3;
    Button wbwynik;
    public static final String STREFA1 = "STREFA1";
    public static final String LICZBABUD1 = "LICZBABUD1";
    public double wb_wynik;
    public String wynik_wb;
    public String strefa2, budliczba1;
    public String metraz;
    double wbx;
    double wby;
    double wbz;
    double budlicz;
    public String wysokosc;

    ImageView helpX, helpY;
    Dialog dialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wymiary_budynku);
        helpX = findViewById(R.id.helpX);
        helpY = findViewById(R.id.helpY);
        dialog = new Dialog(this);
        Intent strefawymiary = getIntent();
        strefa2 = strefawymiary.getStringExtra(STREFA1);
        budliczba1 = strefawymiary.getStringExtra(LICZBABUD1);
        budlicz = Double.parseDouble(budliczba1);
        wynikwymiarybudynku = (TextView)findViewById(R.id.wynikwymiarybudynku);
        wbnumber1 = (EditText)findViewById(R.id.wbnumber1);
        wbnumber2 = (EditText)findViewById(R.id.wbnumber2);
        wbnumber3 = (EditText)findViewById(R.id.wbnumber3);
        wbwynik = (Button)findViewById(R.id.wbwynik);



        helpX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openXdialog();

            }
        });

        helpY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openYdialog();

            }
        });


        wbwynik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(wbnumber1.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Proszę wpisać długość budynku!", Toast.LENGTH_SHORT).show();
                }
                else if (wbnumber2.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Proszę wpisać szerokość budynku!", Toast.LENGTH_SHORT).show();
                }
                else if (wbnumber3.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Proszę wpisać wysokość w pomieszczeniu!", Toast.LENGTH_SHORT).show();
                }
                else{
                    wbx = Double.parseDouble(wbnumber1.getText().toString());
                    wby = Double.parseDouble(wbnumber2.getText().toString());
                    wbz = Double.parseDouble(wbnumber3.getText().toString());
                    if(wbx == 0)
                    {
                        Toast.makeText(getApplicationContext(), "Proszę wpisać wartość większą od 0!", Toast.LENGTH_SHORT).show();
                    }
                    else if(wby == 0)
                    {
                        Toast.makeText(getApplicationContext(), "Proszę wpisać wartość większą od 0!", Toast.LENGTH_SHORT).show();
                    }
                    else if(wbz == 0)
                    {
                        Toast.makeText(getApplicationContext(), "Proszę wpisać wartość większą od 0!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                    wb_wynik = wbx * wby * budlicz;
                    wynik_wb = Double.toString(wb_wynik);
                    wynikwymiarybudynku.setText(String.valueOf(wb_wynik + " m²"));
                    wysokosc = Double.toString(wbz);
                }
                }

            }
        });
        
    }


    private void openYdialog() {
        dialog.setContentView(R.layout.wby_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        Button helpybtn = dialog.findViewById(R.id.helpybtn);

        helpybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void openXdialog() {

        dialog.setContentView(R.layout.wbx_layout_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        Button helpxbtn = dialog.findViewById(R.id.helpxbtn);

        helpxbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }



    public void openRodzajBudynku(View view) {
        if (wynikwymiarybudynku.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(),"Brak obliczonej powierzchni ogrzewanej!", Toast.LENGTH_SHORT).show();

        }
        else {

            String metraz = Double.toString(wb_wynik).trim();

            Intent wymiaryrodzaj = new Intent(this, RodzajBudynku.class);
            wymiaryrodzaj.putExtra(RodzajBudynku.WYNIKWB1,metraz);
            wymiaryrodzaj.putExtra(RodzajBudynku.WYSOKOSC1,wysokosc);
            wymiaryrodzaj.putExtra(RodzajBudynku.STREFA11,strefa2);
            startActivity(wymiaryrodzaj);
        }
    }
}