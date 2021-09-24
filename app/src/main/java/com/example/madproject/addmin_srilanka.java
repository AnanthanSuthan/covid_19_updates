package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;


public class addmin_srilanka extends AppCompatActivity {
    EditText etConfirmed,etDeaths,etRecovered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmin_srilanka);

        etConfirmed = findViewById(R.id.et_confirmed);
        etDeaths = findViewById(R.id.et_deaths);
        etRecovered = findViewById(R.id.et_recovered);

    }



}