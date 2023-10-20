package com.cutm.foodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

/** @noinspection ALL*/
public class splash_screen_main extends AppCompatActivity {

    // Set the duration of the splash screen
    private static final int SPLASH_DISPLAY_LENGTH = 1500; // 1.5 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the status bar color
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.status_bar_color));

        setContentView(R.layout.activity_splash_screen_main);

        // Use a Handler to delay the start of the next activity
        new Handler().postDelayed(() -> {
            // Create an Intent to start the main activity
            Intent mainIntent = new Intent(splash_screen_main.this,get_start_main_screen.class);
            startActivity(mainIntent);

            // Finish the splash activity so it can't be returned to
            finish();
        }, SPLASH_DISPLAY_LENGTH);
    }

}
