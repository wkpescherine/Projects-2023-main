package com.example.pamm;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        checkPref();
    }

    public void checkPref(){
        String filename = "PAMM";
        SharedPreferences sp = getSharedPreferences(filename,MODE_PRIVATE);
        if(filename.isEmpty()){
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("grade", "k");
            editor.putInt("tier", 1);
            editor.putInt("totalSolved", 0);
            editor.putInt("totalAsked", 0);
            editor.putInt("Q20HighScore", 0);
            editor.putInt("HighestTier", 1);
            editor.commit();
        }
    }

    public void clickToStart(View v){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}