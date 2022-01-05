package com.example.reto2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.example.reto2.MainActivity;
import com.example.reto2.R;

public class Splash extends AppCompatActivity {
    private int time = 5000;
    private ProgressBar progressBar, progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progressBar2.incrementProgressBy(20);
            }
        };
        for(int i=0; i<5; i++){
            new Handler().postDelayed(runnable,(i+1)*1000);
        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },time);
    }
}