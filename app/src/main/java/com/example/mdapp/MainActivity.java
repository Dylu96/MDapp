package com.example.mdapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openLiczbaBudynku(View view) {
        Intent intent = new Intent(this, LiczbaBudynku.class);
        startActivity(intent);
    }
}




