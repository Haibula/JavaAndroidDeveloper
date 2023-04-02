package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button buttonMale = findViewById(R.id.buttonMale);
        Button buttonFemaly = findViewById(R.id.buttonFemaly);
        Button buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setClickable(false);

        buttonMale.setOnClickListener(view -> {
            buttonMale.setBackgroundColor(getResources().getColor(R.color.mantis));
            buttonFemaly.setBackgroundColor(getResources().getColor(R.color.balticsea));
            buttonNext.setBackgroundColor(getResources().getColor(R.color.mantis));
            buttonNext.setClickable(true);
        });
        buttonFemaly.setOnClickListener(view -> {
            buttonFemaly.setBackgroundColor(getResources().getColor(R.color.mantis));
            buttonMale.setBackgroundColor(getResources().getColor(R.color.balticsea));
            buttonNext.setBackgroundColor(getResources().getColor(R.color.mantis));
            buttonNext.setClickable(true);
        });


    }
    public void getPageThirdActivity(View v) {
        Intent i = new Intent(this, ThirdActivity.class);
        startActivity(i);
    }
}