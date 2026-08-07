package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText firstnumber,secondnumber;
    Button add,sub,mul,div;
    private TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstnumber = findViewById(R.id.firstnumber);
        secondnumber = findViewById(R.id.secondnumber);
        add = findViewById(R.id.btnadd);
        sub = findViewById(R.id.btnsub);
        mul = findViewById(R.id.btnmul);
        div = findViewById(R.id.btndiv);
        Result = findViewById(R.id.result);

        add.setOnClickListener(view -> calculate('+'));
        sub.setOnClickListener(view -> calculate('-'));
        mul.setOnClickListener(view -> calculate('*'));
        div.setOnClickListener(view -> calculate('/'));

    }

        private void calculate(char op){
            double a = Double.parseDouble(firstnumber.getText().toString());
            double b = Double.parseDouble(secondnumber.getText().toString());
            double ans = 0;

            switch (op) {
                case '+':
                    ans = a + b;
                    break;
                case '-':
                    ans = a - b;
                    break;
                case '*':
                    ans = a * b;
                    break;
                case '/':
                    if(b==0){
                        Result.setText("Cannot divide by zero");
                        return;
                    }
                    ans = a / b;
                    break;

                default:
                    Result.setText("Invalid Operation");
                    return;
            }

            Result.setText("Result : " + ans);
        }
}