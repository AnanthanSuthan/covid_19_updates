package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openSrilanka(View view){
        Intent intent = new Intent(this,SrilankaWise.class);
        startActivity(intent);
    }
    public void openAdmin(View view){
        Intent intent = new Intent(this,CovidUpdatesAdmin.class);
        startActivity(intent);
    }
}