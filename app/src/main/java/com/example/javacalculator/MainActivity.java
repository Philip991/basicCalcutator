package com.example.javacalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView edTxt;
    boolean isNewOp = true;
    String op = "+";
    String oldNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edTxt= findViewById(R.id.textView);
    }

    public void numberEvent(View view) {
        if(isNewOp)
            edTxt.setText("");
        isNewOp=false;
        String number = edTxt.getText().toString();
        switch (view.getId()){
            case R.id.bu0:
                number+="0";
                break;
            case R.id.bu1:
                number+="1";
                break;
            case R.id.bu2:
                number+="2";
                break;
            case R.id.bu3:
                number+="3";
                break;
            case R.id.bu4:
                number+="4";
                break;
            case R.id.bu5:
                number += "5";
                break;
            case R.id.bu6:
                number+= "6";
                break;
            case R.id.bu7:
                number+="7";
                break;
            case R.id.bu8:
                number+="8";
                break;
            case R.id.bu9:
                number+="9";
                break;
            case R.id.buDot:
                number +=".";
                break;
            case R.id.buPlusMinus:
                number ="-"+ number;
                break;
        }
        edTxt.setText(number);
    }


    public void operatorEvent(View view) {
        isNewOp= true;
        oldNumber= edTxt.getText().toString();
        switch(view.getId()){
            case R.id.buPlus:
                op = "+";
                break;
            case R.id.buMinus:
                op = "-";
                break;
            case R.id.buMultiply:
                op = "x";
                break;
            case R.id.buDivide:
                op = "/";
                break;
        }


    }
    public void equalsEvent(View view) {
        String newNumber = edTxt.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result=Double.parseDouble(oldNumber)+ Double.parseDouble(newNumber);
                break;
            case "-":
                result= Double.parseDouble(oldNumber)- Double.parseDouble(newNumber);
                break;
            case "x":
                result=Double.parseDouble(oldNumber)* Double.parseDouble(newNumber);
                break;
            case "/":
                result=Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);
                break;
        }
        edTxt.setText(result+"");

    }

    public void cancelEvent(View view) {
        edTxt.setText("0");
        isNewOp=true;
    }

    public void percentEvent(View view) {
        double num = Double.parseDouble(edTxt.getText().toString())/100;
        edTxt.setText(num+"");
        isNewOp=true;
    }
}