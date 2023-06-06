package com.example.pamm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class Challenge extends AppCompatActivity {
    Data data = new Data();
    SolveEquation solve = new SolveEquation();

    String answer = "";
    double solution = 0;
    String [] symbolArray = {"+","-","*","/"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
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

    public void setDataUI(){
        TextView dataGrade = findViewById(R.id.cgrade);
        TextView dataTier = findViewById(R.id.ctier);
        TextView answersSolved = findViewById(R.id.csolve);
        TextView answerString = findViewById(R.id.answer);
        data.checkNextTier();
        dataTier.setText("Tier: "+ data.tier);
        dataGrade.setText("Grade: "+ data.grade);
        answersSolved.setText("Solved: "+ data.solvedAnswers + " of "+ data.nextTier);
        answerString.setText("");
        answer="";
        standardGameLogic();

    }

    public void checkSolution(View v){
        data.totalAsked += 1;
        TextView response = findViewById(R.id.cresponse);
        if(answer.equals("")){
            response.setText("No answer, the answer is " + solution);
            data.solvedAnswers -= 1;
        } else if(solution == Double.valueOf(answer)){
            response.setText("Correct");
            data.totalCorrect += 1;
            data.solvedAnswers += 1;
        } else {
            response.setText("Incorrect! The answer is " + solution);
            data.solvedAnswers -= 1;
        }
        checkTier();
        setDataUI();
    }

    public void standardGameLogic (){
        TextView num1 = findViewById(R.id.number1);
        TextView num2 = findViewById(R.id.number2);
        TextView sym = findViewById(R.id.symbol);
        Random rnd = new Random();
        int symbolValue = rnd.nextInt(data.symbolBound);
        String symbolUsed = symbolArray[symbolValue];
        int boundValue = 0;
        if(symbolValue == 0){ boundValue = data.addBoundValue;}
        if(symbolValue == 1){ boundValue = data.subBoundValue;}
        if(symbolValue == 2){ boundValue = data.multiBoundValue;}
        if(symbolValue == 3){ boundValue = data.divBoundValue;}
        int rndNum1 = rnd.nextInt(boundValue)+1;
        int rndNum2 = rnd.nextInt(boundValue)+1;
        solution = solve.basicFormulas(symbolUsed, rndNum1, rndNum2);
        sym.setText(symbolUsed);
        num1.setText(String.valueOf(rndNum1));
        num2.setText(String.valueOf(rndNum2));
    }

    public void checkTier(){
        if(Data.solvedAnswers == Data.nextTier){
            if(Data.tier < 70){
                Data.tier += 1;
                Data.solvedAnswers = 0;
            }
        }
        if(Data.solvedAnswers == -1 && Data.tier > 1){
            Data.tier -= 1;
            Data.solvedAnswers = 0;
        }
        data.checkGrade();
        if(Data.tier > Data.highestTier){ Data.highestTier = Data.tier;}
        saveData();
    }

    public void saveData(){
        String filename = "PAMM";
        SharedPreferences sp = getSharedPreferences(filename,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("grade", data.grade);
        editor.putInt("tier", data.tier);
        editor.putInt("totalSolved", data.totalCorrect);
        editor.putInt("totalAsked", data.totalAsked);
        editor.putInt("HighestTier", Data.highestTier);
        editor.commit();
    }

    public void backToDashboard(View v){
        data.solvedAnswers = 0;
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}