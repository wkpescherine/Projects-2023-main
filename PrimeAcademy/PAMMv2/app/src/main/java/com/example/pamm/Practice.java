package com.example.pamm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class Practice extends AppCompatActivity {
    String answer = "";

    Data pracData = new Data();
    FormulaBuilder pracFormulaBuilder = new FormulaBuilder();

    //int practiceTier = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        practiceGameLogic();
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

    public void practiceGameLogic(){
        TextView pracFormula = findViewById(R.id.pracFormulaString);
        TextView pracTierValue = findViewById(R.id.practiceTier);
        pracTierValue.setText("Tier: " +Data.practiceTier);
        pracData.checkNextTier();
        pracFormulaBuilder.builder();
        pracFormula.setText(Data.formulaString);
    }
    public void checkPracSolution(View v){
        TextView response = findViewById(R.id.cresponse);
        TextView pAnswer = findViewById(R.id.answer);
        if(Data.solution == Double.valueOf(answer)){
            response.setText("Correct");
        } else {
            response.setText("Incorrect! The answer is " + Data.solution);
        }
        answer="";
        pAnswer.setText("");
        practiceGameLogic();
    }

    public void decreaseTier(View v){
        if(Data.practiceTier > 1){
            Data.practiceTier -= 1;
            practiceGameLogic();
        }else {
            Toast.makeText(getApplicationContext(),"Your are at the lowest possible Tier", Toast.LENGTH_SHORT).show();
        }
    }

    public void increaseTier(View v){
        if(Data.highestTier == 0){
            Toast.makeText(getApplicationContext(),"Current Tier is 0 unable to raise it", Toast.LENGTH_SHORT).show();
        } else if(Data.practiceTier < Data.highestTier){
            Data.practiceTier +=1;
            practiceGameLogic();

        } else {
            Toast.makeText(getApplicationContext(),"Your Practice Tier is at the highest possible", Toast.LENGTH_SHORT).show();
        }
    }

    public void backToDashboard(View v){
        Data.challengeTier = "";
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}