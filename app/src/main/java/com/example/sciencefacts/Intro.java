package com.example.sciencefacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Intro extends AppCompatActivity {
    private static final int INTRO_DURATION = 2000;
    private static final String PREF_KEY_HAS_VISITED_INTRO = "hasVisitedIntro";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

               /* Intent mainIntent = new Intent(Intro.this, Home.class);
                startActivity(mainIntent);
                finish();*/
                SharedPreferences preferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);

                if (preferences.getBoolean(PREF_KEY_HAS_VISITED_INTRO, false)) {
                    // Intro has been visited before, start Main activity
                    startActivity(new Intent(Intro.this, MainActivity.class));
                } else {
                    // Intro is being visited for the first time, start Home activity
                    startActivity(new Intent(Intro.this, Home.class));
                }

                // Set flag to true to indicate that Intro has been visited
                preferences.edit().putBoolean(PREF_KEY_HAS_VISITED_INTRO, true).apply();

                finish();
            }
        }, INTRO_DURATION);
    }

}