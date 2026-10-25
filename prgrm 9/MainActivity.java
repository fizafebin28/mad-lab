package com.example.registrationform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, name1;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        name1 = findViewById(R.id.name1);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = name.getText().toString();
                String s2 = name1.getText().toString();

                Intent intent = new Intent(
                        MainActivity.this,
                        MainActivity2.class
                );

                intent.putExtra("name", s1);
                intent.putExtra("name1", s2);

                startActivity(intent);
            }
        });
    }
}