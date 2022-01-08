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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RodzajBudynku extends AppCompatActivity {
    private RadioGroup gruparodzajbudynku;
    private RadioButton rodzajbudynku1, rodzajbudynku2, rodzajbudynku3, rodzajbudynku4, rodzajbudynku5, rodzajbudynku6, rodzajbudynku7;
    Button zaakceptujrodzaj;
    public TextView wynikrodzajbudynku;
    public ImageView rodzaj1, rodzaj2, rodzaj3, rodzaj4, rodzaj5, rodzaj6, rodzaj7;
    public EditText wartoscbudynku;
    Dialog dialogrodzajbudynku;
    public int rodzajbud;
    public TextView IzolacjaView;
    public static final String WYNIKWB1 = "WYNIKWB1";
    public static final String WYSOKOSC1 = "WYSOKOSC1";
    public static final String STREFA11 = "STREFA11";
    public String wynikwb000, budrodzaj000, wysokosc000, strefa000;
    Double gizolacja;
    public String gizolacja0;
    public String wynikwb001, budrodzaj001, wysokosc001;
    public String gizolacja1;
    public String metraz;
    String metraz1;
    public String wysokosc01;
    public String wysokosc02;
    public String strefa01;
    Double izobudynku;
    Double standardizo;
    String standardizo1;
    String izobudynku1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rodzaj_budynku);

        wynikrodzajbudynku = (TextView) findViewById(R.id.wynikrodzajbudynku);
        zaakceptujrodzaj = (Button) findViewById(R.id.zaakceptujrodzaj);
        rodzajbudynku1 = (RadioButton) findViewById(R.id.rodzajbudynku1);
        rodzajbudynku2 = (RadioButton) findViewById(R.id.rodzajbudynku2);
        rodzajbudynku3 = (RadioButton) findViewById(R.id.rodzajbudynku3);
        rodzajbudynku4 = (RadioButton) findViewById(R.id.rodzajbudynku4);
        rodzajbudynku5 = (RadioButton) findViewById(R.id.rodzajbudynku5);
        rodzajbudynku6 = (RadioButton) findViewById(R.id.rodzajbudynku6);
        rodzajbudynku7 = (RadioButton) findViewById(R.id.rodzajbudynku7);
        wartoscbudynku = (EditText) findViewById(R.id.wartoscbudynku);
        rodzaj1 = findViewById(R.id.rodzaj1);
        rodzaj2 = findViewById(R.id.rodzaj2);
        rodzaj3 = findViewById(R.id.rodzaj3);
        rodzaj4 = findViewById(R.id.rodzaj4);
        rodzaj5 = findViewById(R.id.rodzaj5);
        rodzaj6 = findViewById(R.id.rodzaj6);
        rodzaj7 = findViewById(R.id.rodzaj7);
        Intent wymiaryrodzaj = getIntent();
        wynikwb000 = wymiaryrodzaj.getStringExtra(WYNIKWB1);
        wysokosc000 = wymiaryrodzaj.getStringExtra(WYSOKOSC1);
        strefa000 = wymiaryrodzaj.getStringExtra(STREFA11);


        dialogrodzajbudynku = new Dialog(this);

        rodzaj1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openrodzaj1dialog();
            }
                                   }
        );

        rodzaj2.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           openrodzaj2dialog();
                                       }
                                   }
        );

        rodzaj3.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           openrodzaj3dialog();
                                       }
                                   }
        );

        rodzaj4.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           openrodzaj4dialog();
                                       }
                                   }
        );

        rodzaj5.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           openrodzaj5dialog();
                                       }
                                   }
        );

        rodzaj6.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           openrodzaj6dialog();
                                       }
                                   }
        );

        rodzaj7.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           openrodzaj7dialog();
                                       }
                                   }
        );

        zaakceptujrodzaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(wartoscbudynku.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Proszę wpisać długość budynku!", Toast.LENGTH_SHORT).show();
                }

                else{
                    izobudynku = Double.parseDouble(wartoscbudynku.getText().toString());
                    if(izobudynku < 5.01)
                    {
                        Toast.makeText(getApplicationContext(), "Proszę wpisać wartość większą od 5!", Toast.LENGTH_SHORT).show();
                    }
                    else if(izobudynku > 5.02 && izobudynku < 16.01)
                    {
                        wynikrodzajbudynku.setText(String.valueOf(("Wybrana wartość to " + izobudynku)));
                    standardizo = 0.75;
                    }
                    else if(izobudynku > 16.02 && izobudynku < 41.01)
                    {
                        wynikrodzajbudynku.setText(String.valueOf(("Wybrana wartość to " + izobudynku)));
                    standardizo = 0.9;
                    }
                    else if(izobudynku > 41.02 && izobudynku < 51.01)
                    {
                        wynikrodzajbudynku.setText(String.valueOf(("Wybrana wartość to " + izobudynku)));
                    standardizo = 1.2;
                    }
                    else if(izobudynku > 51.02 && izobudynku < 61.01)
                    {
                        wynikrodzajbudynku.setText(String.valueOf(("Wybrana wartość to " + izobudynku)));
                    standardizo = 1.3;
                    }
                    else if(izobudynku > 61.02 && izobudynku < 91.01)
                    {
                        wynikrodzajbudynku.setText(String.valueOf(("Wybrana wartość to " + izobudynku)));
                    standardizo = 1.5;
                    }
                    else if(izobudynku > 91.02 && izobudynku < 101.01)
                    {
                        wynikrodzajbudynku.setText(String.valueOf(("Wybrana wartość to " + izobudynku)));
                    standardizo = 1.7;
                    }
                    else if(izobudynku > 101.02 && izobudynku < 150.01)
                    {
                        wynikrodzajbudynku.setText(String.valueOf(("Wybrana wartość to " + izobudynku)));
                    standardizo = 2.5;
                    }


                    else{
                        Toast.makeText(getApplicationContext(), "Proszę wpisać wartość mniejszą od 150!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }

    private void openrodzaj1dialog() {
        dialogrodzajbudynku.setContentView(R.layout.rodzajbudynku1);
        dialogrodzajbudynku.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        Button rodzaj1button = dialogrodzajbudynku.findViewById(R.id.rodzaj1button);
        rodzaj1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogrodzajbudynku.dismiss();
            }
        });
        dialogrodzajbudynku.show();
    }

    private void openrodzaj2dialog() {
        dialogrodzajbudynku.setContentView(R.layout.rodzajbudynku2);
        dialogrodzajbudynku.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        Button rodzaj1button = dialogrodzajbudynku.findViewById(R.id.rodzaj2button);
        rodzaj1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogrodzajbudynku.dismiss();
            }
        });
        dialogrodzajbudynku.show();
    }

    private void openrodzaj3dialog() {
        dialogrodzajbudynku.setContentView(R.layout.rodzajbudynku3);
        dialogrodzajbudynku.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        Button rodzaj1button = dialogrodzajbudynku.findViewById(R.id.rodzaj3button);
        rodzaj1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogrodzajbudynku.dismiss();
            }
        });
        dialogrodzajbudynku.show();
    }

    private void openrodzaj4dialog() {
        dialogrodzajbudynku.setContentView(R.layout.rodzajbudynku4);
        dialogrodzajbudynku.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        Button rodzaj1button = dialogrodzajbudynku.findViewById(R.id.rodzaj4button);
        rodzaj1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogrodzajbudynku.dismiss();
            }
        });
        dialogrodzajbudynku.show();
    }

    private void openrodzaj5dialog() {
        dialogrodzajbudynku.setContentView(R.layout.rodzajbudynku5);
        dialogrodzajbudynku.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        Button rodzaj1button = dialogrodzajbudynku.findViewById(R.id.rodzaj5button);
        rodzaj1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogrodzajbudynku.dismiss();
            }
        });
        dialogrodzajbudynku.show();
    }

    private void openrodzaj6dialog() {
        dialogrodzajbudynku.setContentView(R.layout.rodzajbudynku6);
        dialogrodzajbudynku.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        Button rodzaj1button = dialogrodzajbudynku.findViewById(R.id.rodzaj6button);
        rodzaj1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogrodzajbudynku.dismiss();
            }
        });
        dialogrodzajbudynku.show();
    }

    private void openrodzaj7dialog() {
        dialogrodzajbudynku.setContentView(R.layout.rodzajbudynku7);
        dialogrodzajbudynku.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        Button rodzaj1button = dialogrodzajbudynku.findViewById(R.id.rodzaj7button);
        rodzaj1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogrodzajbudynku.dismiss();
            }
        });
        dialogrodzajbudynku.show();
    }


    public void openTemperaturaBudynku(View view) {
        if (wynikrodzajbudynku.getText().toString().isEmpty()){

            Toast.makeText(getApplicationContext(),"Brak zaznaczonej izolacji budynku!", Toast.LENGTH_SHORT).show();
        }
        else {
            standardizo1 = Double.toString(standardizo);
            izobudynku1 = Double.toString(izobudynku);

            wynikwb001 = wynikwb000;
            wysokosc001 = wysokosc000;
            Intent izolacjatemperatura = new Intent(this, TemperaturaBudynku.class);
            izolacjatemperatura.putExtra(TemperaturaBudynku.WYNIKWB2,wynikwb001);
            izolacjatemperatura.putExtra(TemperaturaBudynku.WYSOKOSC2,wysokosc001);
            izolacjatemperatura.putExtra(TemperaturaBudynku.IZOLACJAG,standardizo1);
            izolacjatemperatura.putExtra(TemperaturaBudynku.STREFA12,strefa000);
            izolacjatemperatura.putExtra(TemperaturaBudynku.IZOL1,izobudynku1);
            startActivity(izolacjatemperatura);
        }
    }
}