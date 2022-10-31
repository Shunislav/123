package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Reg extends AppCompatActivity {


    EditText input_login, input_password, input_email;
    Button add_button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

      input_login = findViewById(R.id.editTextInputLogin);
      input_password = findViewById(R.id.editTextInputPassword);
        input_email = findViewById(R.id.editTextInputEmail);

      add_button = findViewById(R.id.buttonReg);

      add_button.setOnClickListener(v -> {
          BDWhelp mdb = new BDWhelp(Reg.this);
          mdb.add_users(input_login.getText().toString().trim(),
                  input_password.getText().toString().trim(),
                  input_email.getText().toString().trim());
      });
    }
}