package com.example.zahuy;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CurrencyConvert extends AppCompatActivity {

    RadioGroup fromCurRadioGroup;
    RadioGroup toCurRadioGroup;
    TextView enterNumber;
    TextView resultNumber;
    RadioButton fromCurrency;
    RadioButton toCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency_converter);

        enterNumber = findViewById(R.id.numberToConvert);
        resultNumber = findViewById(R.id.resultNumber);



        findViewById(R.id.buttonConvert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCurrency();
            }
        });

        findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterNumber.setText("");
                resultNumber.setText("");
            }
        });

        findViewById(R.id.buttonOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void changeCurrency(){

    }

    public void convertCurrency(){
        String numberToConvert = enterNumber.toString();
        int number = Integer.parseInt(numberToConvert);
        number *= 25000;
    }
}
