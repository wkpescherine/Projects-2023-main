package com.example.pamm;

import java.util.Random;

public class FormulaBuilder {
    //Data data = new Data();
    public int builder(){
        Random rnd = new Random();
        int symbolValue = rnd.nextInt(Data.symbolBound);
        //String symbolUsed = Data.symbolArray[symbolValue];
        int boundValue = 0;
        if(symbolValue == 0){ boundValue = Data.addBoundValue;}
        if(symbolValue == 1){ boundValue = Data.subBoundValue;}
        if(symbolValue == 2){ boundValue = Data.multiBoundValue;}
        if(symbolValue == 3){ boundValue = Data.divBoundValue;}
        int rndNum1 = rnd.nextInt(boundValue)+1;
        int rndNum2 = rnd.nextInt(boundValue)+1;
        if(symbolValue == 0){
            Data.formulaString = rndNum1+"+"+rndNum2;
            Data.solution = rndNum1+rndNum2;
        }
        if(symbolValue == 1){
            Data.formulaString = rndNum1+"-"+rndNum2;
            Data.solution = rndNum1-rndNum2;
        }
        if(symbolValue == 2){
            Data.formulaString = rndNum1+"x"+rndNum2;
            Data.solution = rndNum1*rndNum2;
        }
        if(symbolValue == 3){
            Data.formulaString = rndNum1+"/"+rndNum2;
            Data.solution = rndNum1/rndNum2;
        }
        return 0;
    }
}
