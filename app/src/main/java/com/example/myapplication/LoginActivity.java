package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    ImageButton myImageButton;
    Button loginButton;
    EditText editText, editPassword;


    static String login = "jaroslpa@yandex.ru";
    static String password = "qwe";



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myImageButton = (ImageButton) findViewById(R.id.imageButtonBac);

        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent vac = new Intent(LoginActivity.this, MainActivity.class);
             startActivity(vac);
            }
        });

        loginButton = findViewById(R.id.buttonLog);
        editText = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editPassword = (EditText) findViewById(R.id.editTextTextPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = editText.getText().toString();
                String add_password = editPassword.getText().toString();

                BDWhelp mdb = new BDWhelp(LoginActivity.this);
                mdb.search(Email,add_password);



            }
        });




    }
}
