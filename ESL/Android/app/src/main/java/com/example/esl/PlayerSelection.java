package com.example.esl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class PlayerSelection extends AppCompatActivity {
    GameConfig config = new GameConfig();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_selection);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setPlayers();
    }

    public void setPlayers(){
        if(config.League.equals("NBA")){ buildUI();}
    }

    public void BackButton(View v){
        Intent intent = new Intent(this, NBA_Sim.class);
        startActivity(intent);
    }

    public void buildUI(){

    }
}