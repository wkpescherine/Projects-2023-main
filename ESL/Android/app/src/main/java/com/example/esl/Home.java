package com.example.esl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Home extends AppCompatActivity {
    GameConfig gameConfig=  new GameConfig();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }

    public void LogOut(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void nbaSim(View v){
        gameConfig.League = "NBA";
        Intent intent = new Intent(this, NBA_Sim.class);
        startActivity(intent);
    }

    public void nflSim(View v){
        gameConfig.League = "NBA";
        Intent intent = new Intent(this, NFL_Sim.class);
        startActivity(intent);
    }
}