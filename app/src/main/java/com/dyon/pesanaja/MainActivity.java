package com.dyon.pesanaja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.button);

        btnStart.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, RetrieveActivity.class);
            startActivity(intent);
        });
    }
}
