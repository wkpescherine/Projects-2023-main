package com.example.pamm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    Data pdata = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setProfileUI();
    }

    public void setProfileUI(){
        TextView proDataUsername = findViewById(R.id.pusername);
        TextView proDataSolved = findViewById(R.id.pSolved);
        TextView proDataAsked = findViewById(R.id.pAsked);
        TextView proDataPercent = findViewById(R.id.pPercent);
        TextView proDataQ20HS = findViewById(R.id.q20High);
        TextView proDataHighestTier = findViewById(R.id.pHighestTier);
        proDataUsername.setText(pdata.username);
        double solvedPercent = 0;
        if( Data.totalAsked != 0) {
            solvedPercent = ((double)Data.totalCorrect / (double)Data.totalAsked)*100;
        }
        proDataSolved.setText("Total Correct Answers: "+ Data.totalCorrect);
        proDataAsked.setText("Total Questions Asked: "+ Data.totalAsked);
        //proDataPercent.setText("Percent Correct Answers : "+ String.format("%2.f",solvedPercent) + "%");
        proDataPercent.setText("Percent Correct Answers : "+ solvedPercent + "%");
        proDataQ20HS.setText("20 Questions High Score: " + Data.q20HighestScore);
        proDataHighestTier.setText("Highest Tier: " + Data.highestTier);
    }

    public void resetData(View v){
        String filename = "PAMM";
        SharedPreferences sp = getSharedPreferences(filename,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("grade", "k");
        editor.putInt("tier", 1);
        editor.putInt("totalSolved", 0);
        editor.putInt("totalAsked", 0);
        editor.putInt("Q20HighScore", 0);
        editor.putInt("HighestTier", 1);
        editor.commit();
        Data.grade = sp.getString("grade", null);
        Data.tier = sp.getInt("tier", 0);
        Data.totalCorrect = sp.getInt("totalSolved", 0);
        Data.totalAsked = sp.getInt("totalAsked", 0);
        Data.q20HighestScore = sp.getInt("Q20HighScore", 0);
        Data.highestTier = sp.getInt("HighestTier", 0);
        setProfileUI();
    }

    public void backToDashboard(View v){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}