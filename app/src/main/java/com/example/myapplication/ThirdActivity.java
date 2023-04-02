package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ThirdActivity extends AppCompatActivity implements TextWatcher {
    private static final int RESULT_LOAD_IMG = 0;
    TextView text_field_1;
    TextView text_field_2;
    Button buttonConfirm;
    ImageButton imageButton;
    String firstName;
    String lastName;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        text_field_1 = findViewById(R.id.text_field_1);
        text_field_2 = findViewById(R.id.text_field_2);
        buttonConfirm = findViewById(R.id.buttonConfirm);
        imageButton = findViewById(R.id.imageAddButton);
        buttonConfirm.setClickable(false);
        text_field_1.addTextChangedListener(this);
        text_field_2.addTextChangedListener(this);


        imageButton.setOnClickListener(view -> {
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imageButton.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(ThirdActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(ThirdActivity.this, "You haven't picked Image", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
        firstName = text_field_1.getText().toString();
        lastName = text_field_2.getText().toString();
        if (!firstName.isEmpty() && !lastName.isEmpty()) {
            buttonConfirm.setBackgroundColor(getResources().getColor(R.color.mantis));
            buttonConfirm.setClickable(true);

        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    public void getPageFourthActivity(View v) {
        imageButton.buildDrawingCache();
        Bitmap bitmap = imageButton.getDrawingCache();
        Intent i = new Intent(this, FourthActivity.class);
        i.putExtra("firstName", firstName);
        i.putExtra("lastName", lastName);
        i.putExtra("BitmapImage", bitmap);
        startActivity(i);


    }

}
