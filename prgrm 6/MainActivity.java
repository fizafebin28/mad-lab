package com.example.gridcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText display;
    String first = "";
    String operator = "";
    String second = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        int[] ids = {
                R.id.b1, R.id.b2, R.id.b3, R.id.b4,
                R.id.b5, R.id.b6, R.id.b7, R.id.b8,
                R.id.b9, R.id.b10, R.id.b11, R.id.b12,
                R.id.b13, R.id.b14, R.id.b15, R.id.b16
        };

        for (int id : ids) {
            Button button = findViewById(id);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String value = button.getText().toString();

                    if (value.equals("C")) {
                        first = "";
                        second = "";
                        operator = "";
                        display.setText("");

                    } else if (value.equals("=")) {
                        calculate();

                    } else if (value.equals("+") ||
                            value.equals("-") ||
                            value.equals("*") ||
                            value.equals("/")) {

                        if (!operator.isEmpty() || display.getText().toString().isEmpty()) {
                            return;
                        }

                        first = display.getText().toString();
                        operator = value;
                        display.append(" " + operator + " ");

                    } else {
                        if (operator.isEmpty()) {
                            display.append(value);
                        } else {
                            second += value;
                            display.append(value);
                        }
                    }
                }
            });
        }
    }

    void calculate() {
        try {
            if (first.isEmpty() || operator.isEmpty() || second.isEmpty()) {
                return;
            }

            double a = Double.parseDouble(first);
            double b = Double.parseDouble(second);
            double result = 0;

            switch (operator) {
                case "+":
                    result = a + b;
                    break;

                case "-":
                    result = a - b;
                    break;

                case "*":
                    result = a * b;
                    break;

                case "/":
                    if (b == 0) {
                        Toast.makeText(this,
                                "Cannot divide by zero",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = a / b;
                    break;
            }

            if (result == (long) result) {
                display.setText(String.valueOf((long) result));
            } else {
                display.setText(String.valueOf(result));
            }

            first = "";
            second = "";
            operator = "";

        } catch (Exception e) {
            Toast.makeText(this,
                    "Enter valid numbers",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
