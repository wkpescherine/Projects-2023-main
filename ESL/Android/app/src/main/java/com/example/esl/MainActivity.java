package com.example.esl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    }

    public void Login(View v){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void Create(View v){
        Intent intent = new Intent(this, Create.class);
        startActivity(intent);
    }

    public void Guest(View v){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}