package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class FourthActivity extends AppCompatActivity {

    ImageButton imageButtonHome;
    ImageView imageAvatarView;
    TextView userText;
    ConstraintLayout quote1Panel;
    ConstraintLayout quote2Panel;
    ConstraintLayout quote3Panel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        imageButtonHome = findViewById(R.id.imageButtonHome);
        imageAvatarView = findViewById(R.id.imageAvatarView);
        userText = findViewById(R.id.usernameText);
        quote1Panel = findViewById(R.id.quote1Panel);
        quote2Panel = findViewById(R.id.quote2Panel);
        quote3Panel = findViewById(R.id.quote3Panel);

        randomQuote();
        setUserData();

    }

    public void CloseQuote1(View v) {
        quote1Panel.setVisibility(View.INVISIBLE);
    }

    public void CloseQuote2(View v) {
        quote2Panel.setVisibility(View.INVISIBLE);
    }

    public void CloseQuote3(View v) {
        quote3Panel.setVisibility(View.INVISIBLE);
    }

    public void returnToHome(View v) {
        imageButtonHome.setForegroundTintList(getColorStateList(R.color.mantis));
        Intent i = new Intent(this, FourthActivity.class);
        startActivity(i);
    }

    public void randomQuote() {
        int a = (int) (Math.random() * 3);
        try {
            switch (a) {
                case (0):
                    quote1Panel.setVisibility(View.VISIBLE);
                    break;
                case (1):
                    quote2Panel.setVisibility(View.VISIBLE);
                    break;
                case (2):
                    quote3Panel.setVisibility(View.VISIBLE);
                    break;
            }
        } catch (Exception ignored) {

        }
    }

    public void setUserData() {
        //"try"-Иначе приложение закрывается, если не передавать данные в ThirdActivity
        try {
            String firsName = getIntent().getStringExtra("firstName").toUpperCase(Locale.ROOT);
            String lastName = getIntent().getStringExtra("lastName").toUpperCase(Locale.ROOT);
            String firsNAndLastn = "HI,\n" + firsName + " " + lastName;
            Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("BitmapImage");
            imageAvatarView.setImageBitmap(bitmap);
            userText.setText(firsNAndLastn);
        } catch (Exception ignore) {

        }
    }


}