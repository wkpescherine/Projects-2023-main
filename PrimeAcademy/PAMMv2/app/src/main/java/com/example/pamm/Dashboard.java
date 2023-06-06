package com.example.pamm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
    Data data = new Data();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        SharedPreferences sp = getSharedPreferences("PAMM", MODE_PRIVATE);
        Data.grade = sp.getString("grade", null);
        Data.tier = sp.getInt("tier", 0);
        Data.totalCorrect = sp.getInt("totalSolved", 0);
        Data.totalAsked = sp.getInt("totalAsked", 0);
        Data.q20HighestScore = sp.getInt("Q20HighScore", 0);
        Data.highestTier = sp.getInt("HighestTier", 0);
        setDashDataUI();

    }

    public void clickToChallenge(View v){
        Intent intent = new Intent(this, Challenge.class);
        startActivity(intent);
    }

    public void clickTo20Questions(View v){
        Data.challengeTier = "Q20";
        Intent intent = new Intent(this, ChallengeQ20.class);
        startActivity(intent);
    }

    public void clickToTimed(View v){
        Toast.makeText(getApplicationContext(),"Currently unavailble", Toast.LENGTH_SHORT).show();
    }

    public void clickPracticeQuestions(View v){
        //Toast.makeText(getApplicationContext(),"Currently unavailble", Toast.LENGTH_SHORT).show();
        Data.challengeTier = "Practice";
        Intent intent = new Intent(this, Practice.class);
        startActivity(intent);
    }

    public void clickToProfile(View v){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void setDashDataUI(){
        TextView dashDataUsername = findViewById(R.id.username);
        TextView dashDataGrade = findViewById(R.id.dgrade);
        TextView dashDataTier = findViewById(R.id.dtier);
        dashDataUsername.setText(data.username);
        dashDataTier.setText("Tier: "+ data.tier);
        dashDataGrade.setText("Grade: "+ data.grade);
    }

    public void clickToExit(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}