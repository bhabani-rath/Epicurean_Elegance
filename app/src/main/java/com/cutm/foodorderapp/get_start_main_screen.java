package com.cutm.foodorderapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class get_start_main_screen extends AppCompatActivity {
    //Set Intent For LogIn Page Redirection
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        setContentView(R.layout.activity_get_start_main_screen);

        // Find the button by its id
        AppCompatButton button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(get_start_main_screen.this, LogIn_User.class);
                startActivity(intent);
                Toast.makeText(get_start_main_screen.this, "Log In Here With Your Credentials", Toast.LENGTH_SHORT).show();
            }
        });

    }
    //AlertDialog For Exit
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(get_start_main_screen.this);

        builder.setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity(); // Close the activity
                        Toast.makeText(get_start_main_screen.this, "Thanks For Using Our App", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Dismiss the dialog, do nothing
                        Toast.makeText(get_start_main_screen.this, "Thanks For Staying", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Rate Us",new DialogInterface.OnClickListener(){
                    @SuppressLint("QueryPermissionsNeeded")
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData( Uri.parse("mailto:bhabanishankarr21@gmail.com"));
                        // Create a URI with subject and body
                        Uri uri = Uri.parse("mailto:example@example.com" +
                                "?subject=" + Uri.encode("Rating Of The App") +
                                "&body=" + Uri.encode("Write About Our App"));
                        intent.setData(uri);
                        intent.setPackage("com.google.android.gm");
                        if (intent.resolveActivity(getPackageManager())!=null){
                            startActivity(intent);
                            Toast.makeText(get_start_main_screen.this, "Mail Us Your Rating To Us", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(get_start_main_screen.this, "Gmail App Is Not Installed", Toast.LENGTH_SHORT).show();
                        }
                        startActivity(intent);
                    }
                })
                .show();
    }
}