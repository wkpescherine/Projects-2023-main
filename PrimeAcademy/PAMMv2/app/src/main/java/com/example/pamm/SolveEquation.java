package com.example.pamm;

public class SolveEquation {
    public double basicFormulas(String s, int n1, int n2){
        double value = 0;
        if(s.equals("+")){ value = n1+n2; }
        if(s.equals("-")){ value = n1-n2; }
        if(s.equals("*")){ value = n1*n2; }
        if(s.equals("/")){
            String tempValue = ""+ String.format("%.3f",(double)n1 / (double)n2);
            value = Double.valueOf(tempValue);
        }
        return value;
    }
}
