package com.example.esl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class NBA_Sim extends AppCompatActivity {
    GameConfig config = new GameConfig();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nba_sim);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }

    public void playerNBA(View v){
        Intent intent = new Intent(this, PlayerSelection.class);
        startActivity(intent);
    }

    public void StartGame(){}

    public void BackToSelection(View v){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}