package com.example.pfs_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        checkPref();
        checkStatus();
    }

    public void checkPref(){
        String filename = "PFS";
        SharedPreferences sp = getSharedPreferences(filename,MODE_PRIVATE);
        if(filename.isEmpty()){
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("status", "inactive");
            editor.putString("username", "");
            editor.putString("password", "");
            editor.putString("education", "");
            editor.putString("state", "");
            editor.putInt("age", 0);
            editor.putInt("cashOnHand", 0);
            editor.putInt("timeSpeed", 24);
            editor.commit();
        }
    }

    public void checkStatus(){
        SharedPreferences sp = getSharedPreferences("PFS", MODE_PRIVATE);
        String currentStatus = sp.getString("status", null);
        LinearLayout login = findViewById(R.id.loginInfo);
        Button create = findViewById(R.id.create);
        Button enter = findViewById(R.id.login);
        if( currentStatus.equals("active")){
            login.setVisibility(View.VISIBLE);
            create.setVisibility(View.GONE);
            enter.setVisibility(View.VISIBLE);
        }else {
            login.setVisibility(View.GONE);
            create.setVisibility(View.VISIBLE);
            enter.setVisibility(View.GONE);
        }
    }

    public void createAccount(View v){
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

    public void login(View v){
        SharedPreferences sp = getSharedPreferences("PFS",MODE_PRIVATE);
        String userName = sp.getString("username", null);
        String userPass = sp.getString("password", null);
        EditText user = findViewById(R.id.username);
        EditText pass = findViewById(R.id.password);
        String enteredUsername = user.getText().toString();
        String enteredPassword = pass.getText().toString();
        if(userName.equals(enteredUsername) && userPass.equals(enteredPassword)){
            Intent intent = new Intent(this, dashboard.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Incorrect username or password", Toast.LENGTH_SHORT).show();
        }

    }
}