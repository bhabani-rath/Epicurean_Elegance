package com.cutm.foodorderapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class splash_screen_app_logo extends AppCompatActivity {
    private static final int SPLASH_DISPLAY_LENGTH = 1500;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the status bar color to yellow
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(Color.parseColor("#FFCC00")); // This sets the color to yellow
        setContentView(R.layout.activity_splash_screen_app_logo);
        // Use a Handler to delay the start of the next activity
        new Handler().postDelayed(() -> {
            // Create an Intent to start the main activity
            Intent mainIntent = new Intent(splash_screen_app_logo.this,get_start_main_screen.class);
            startActivity(mainIntent);

            // Finish the splash activity so it can't be returned to
            finish();
        }, SPLASH_DISPLAY_LENGTH);

    }
}