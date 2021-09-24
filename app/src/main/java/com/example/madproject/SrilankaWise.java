package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madproject.database.DBHelper;

public class SrilankaWise extends AppCompatActivity {
    TextView tvConfirmed,tvDeaths,tvRecovered,tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srilanka_wise);
        tvConfirmed=findViewById(R.id.tv_confirmedS);
        tvDeaths=findViewById(R.id.tv_deathsS);
        tvRecovered=findViewById(R.id.tv_recoveredS);
        tvDate=findViewById(R.id.tv_dateS);

        viewProvince();
    }
    public void openProvinces(View view){
        Intent intent= new Intent(this,provinces.class);
        startActivity(intent);
    }

    public void viewProvince(){
        DBHelper dbHelper = new DBHelper(this);
        String imageName = "Srilanka";

        Cursor cursor = dbHelper.readProvince(imageName);
        if(cursor==null){
            Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show();

        }else {
            cursor.moveToFirst();
            String province = cursor.getString(0);
            String confirmed = cursor.getString(1);
            String deaths = cursor.getString(2);
            String recovered = cursor.getString(3);
            String date = cursor.getString(4);

            tvConfirmed.setText(confirmed);
            tvDeaths.setText(deaths);
            tvRecovered.setText(recovered);
            tvDate.setText(date);
        }

    }
    //tyutuyututyu5
}