package com.example.pamm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class ChallengeQ20 extends AppCompatActivity {
    Data data = new Data();
    SolveEquation solve = new SolveEquation();

    int points = 0;
    String answer = "";
    double solution = 0;
    String [] symbolArray = {"+","-","*","/"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_q2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        data.checkNextTier();
        setDataUI();
    }

    public void handleKeypadNum(View v){
        TextView t = (TextView) v;
        TextView clearResponse = findViewById(R.id.cresponse);
        clearResponse.setText("");
        String valueSelect = t.getText().toString();
        if(valueSelect.equals("DEL")){
            valueSelect = "";
            if(answer.length()>=1) {
                answer = answer.substring(0, answer.length()-1);
            }
        }
        answer += valueSelect;
        TextView answerText = findViewById(R.id.answer);
        answerText.setText(answer);
    }

    public void q20GameLogic (){
        TextView num1 = findViewById(R.id.number1);
        TextView num2 = findViewById(R.id.number2);
        TextView sym = findViewById(R.id.symbol);
        Random rnd = new Random();
        Integer symbolValue = rnd.nextInt(data.symbolBound);
        Data.symbolUsed = symbolArray[symbolValue];
        int boundValue = 0;
        if(symbolValue == 0){ boundValue = data.addBoundValue;}
        if(symbolValue == 1){ boundValue = data.subBoundValue;}
        if(symbolValue == 2){ boundValue = data.multiBoundValue;}
        if(symbolValue == 3){ boundValue = data.divBoundValue;}
        Integer rndNum1 = rnd.nextInt(boundValue)+1;
        Integer rndNum2 = rnd.nextInt(boundValue)+1;
        solution = solve.basicFormulas(Data.symbolUsed, rndNum1, rndNum2);
        setPoints(rndNum1, rndNum2);
        sym.setText(Data.symbolUsed);
        num1.setText(rndNum1.toString());
        num2.setText(rndNum2.toString());
    }

    public void setPoints(int number1 , int number2){
        if(Data.symbolUsed.equals("+")){points = (int) ((number1+number2)*.2);}
        if(Data.symbolUsed.equals("-")){points = (int) ((number1+number2)*.6);}
        if(Data.symbolUsed.equals("*")){points = (number1+number2)*2;}
        if(Data.symbolUsed.equals("/")){points = (number1+number2)*5;}
    }

    public void checkSolution(View v){
        Data.totalAsked += 1;
        TextView response = findViewById(R.id.cresponse);
        if(answer.equals("")){
            response.setText("No answer, the answer is "+solution);
            Data.q20Asked +=1;
        } else if(solution == Double.valueOf(answer)){
            response.setText("Correct");
            Data.q20Points += points;
            Data.totalCorrect += 1;
            Data.q20Asked += 1;
            Data.q20Solved +=1;
        } else {
            response.setText("Incorrect! The answer is " + solution);
            Data.q20Asked +=1;
        }
        saveData();
        setDataUI();
    }

    public void setDataUI(){
        TextView num1 = findViewById(R.id.number1);
        TextView num2 = findViewById(R.id.number2);
        TextView sym = findViewById(R.id.symbol);
        TextView dataQ20Asked = findViewById(R.id.q20Questions);
        TextView dataQ20Correct = findViewById(R.id.q20QuestionsCorrect);
        TextView dataQ20Points = findViewById(R.id.q20Points);
        TextView answerQ20String = findViewById(R.id.answer);
        dataQ20Asked.setText(Data.q20Asked+" of 20");
        dataQ20Correct.setText("Correct :"+ data.q20Solved);
        dataQ20Points.setText("Points: " + Data.q20Points);
        answerQ20String.setText("");
        answer="";
        if( Data.q20Asked < 20){q20GameLogic();}
        else {
            Button solveButton = findViewById(R.id.solveButton);
            LinearLayout layoutQ20Header = findViewById(R.id.q20Header);
            layoutQ20Header.setVisibility(View.GONE);
            num1.setVisibility(View.GONE);
            num2.setVisibility(View.GONE);
            solveButton.setVisibility(View.GONE);
            sym.setText("Score: " + Data.q20Points);
        }
    }

    public void saveData(){
        String filename = "PAMM";
        SharedPreferences sp = getSharedPreferences(filename,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("totalSolved", data.totalCorrect);
        editor.putInt("totalAsked", data.totalAsked);
        if(Data.q20Points > Data.q20HighestScore ){
            editor.putInt("Q20HighScore",  Data.q20Points);
        }
        editor.commit();
    }

    public void backToDashboard(View v){
        Data.q20Asked = 0;
        Data.q20Solved = 0;
        Data.challengeTier = "";
        Data.q20Points = 0;
        if( Data.q20Asked == 20){
            TextView num1 = findViewById(R.id.number1);
            TextView num2 = findViewById(R.id.number2);
            Button solveButton = findViewById(R.id.solveButton);
            LinearLayout layoutQ20Header = findViewById(R.id.q20Header);
            layoutQ20Header.setVisibility(View.VISIBLE);
            num1.setVisibility(View.VISIBLE);
            num2.setVisibility(View.VISIBLE);
            solveButton.setVisibility(View.VISIBLE);
        }
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}