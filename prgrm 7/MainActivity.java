package com.example.toggle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    Button btn;

    int images[] = {
            R.drawable.img,
            R.drawable.img_1
    };

    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.imgv1);
        btn = findViewById(R.id.btn);
    }

    public void Click(View view) {

        if (currentIndex == 0) {
            iv.setImageResource(images[1]);
            currentIndex = 1;

        } else {
            iv.setImageResource(images[0]);
            currentIndex = 0;
        }
    }
}
