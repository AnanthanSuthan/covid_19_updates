package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madproject.database.DBHelper;

public class provinceWise extends AppCompatActivity {
    public static final String TAG = "provinceWise";

    TextView tvProvince,tvConfirmed,tvDeaths,tvRecovered,tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_province_wise);
        Log.d(TAG,"onCreate: started");
        tvProvince = findViewById(R.id.province_name);
        tvConfirmed=findViewById(R.id.tv_confirmedS);
        tvDeaths=findViewById(R.id.tv_deathsS);
        tvRecovered=findViewById(R.id.tv_recoveredS);
        tvDate=findViewById(R.id.tv_dateS);

        getIncomingIntent();
    }

    public void getIncomingIntent(){
        Log.d(TAG,"getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_name")) {
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageName = getIntent().getStringExtra("image_name");

            setNameToView(imageName);
            viewProvince();
        }
    }

    private void setNameToView(String imageName){
        tvProvince.setText(imageName);


    }

    public void viewProvince(){
        DBHelper dbHelper = new DBHelper(this);
        String imageName = getIntent().getStringExtra("image_name");

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

}
