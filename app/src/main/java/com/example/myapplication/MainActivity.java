package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_Log = findViewById(R.id.buttonLogin);
        Button button_Sing_Up = findViewById(R.id.buttonSing);

        button_Log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switcher = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(switcher);
            }

        });

        button_Sing_Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switcher = new Intent(MainActivity.this, Reg.class );
                MainActivity.this.startActivity(switcher);
            }
        });


    }
}