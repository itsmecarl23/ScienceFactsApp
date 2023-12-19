package com.example.sciencefacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Intro extends AppCompatActivity {
    private static final int INTRO_DURATION = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity after the intro duration
                Intent mainIntent = new Intent(Intro.this, Home.class);
                startActivity(mainIntent);
                finish();
            }
        }, INTRO_DURATION);
    }

}