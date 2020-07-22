package com.pioneeralpha.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valueOfL, valueOfW, valueOfH;
    private Button cmToSq, inchToSq;
    private TextView resultText;
    private double l, w, h, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueOfH = findViewById(R.id.value_h);
        valueOfL = findViewById(R.id.value_l);
        valueOfW = findViewById(R.id.value_w);

        resultText = findViewById(R.id.result);

        cmToSq = findViewById(R.id.cm_to_sq);
        inchToSq = findViewById(R.id.inch_to_sq);

        cmToSq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCmToSq();
            }
        });
        inchToSq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertInchToSq();
            }
        });
    }

    private boolean areNumericalValues() {
        try {
            l = Double.parseDouble(valueOfL.getText().toString());
            h = Double.parseDouble(valueOfH.getText().toString());
            w = Double.parseDouble(valueOfW.getText().toString());
        } catch (NumberFormatException nfe) {
            Toast.makeText(this, "All values should be integer", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void convertCmToSq() {
        if(areNumericalValues()) {
            result = (l+w+6)*(w+h+4)*2/10000;
            resultText.setText(String.format("%.02f", result));
            resultText.setBackgroundResource(R.drawable.border_red);
        }
    }

    private void convertInchToSq() {
        if(areNumericalValues()) {
            result = (l+w+2.36)*(w+h+1.57)*12.90/10000;
            resultText.setText(String.format("%.02f", result));
            resultText.setBackgroundResource(R.drawable.border_green);
        }
    }

}