package com.cutm.foodorderapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LogIn_User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        setContentView(R.layout.activity_log_in_user);
        TextView textView = findViewById(R.id.textView9);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn_User.this, Register_User.class);
                startActivity(intent);
                Toast.makeText(LogIn_User.this, "Register With Providing The Information", Toast.LENGTH_SHORT).show();
            }
        });

        Button button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                if (validateForm()) {
                    Intent intent = new Intent(LogIn_User.this, choose_location.class);
                    startActivity(intent);
                    Toast.makeText(LogIn_User.this, "Enter Your Location!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Add validateForm method here
    private boolean validateForm() {
        boolean valid = true;

        EditText emailEditText = findViewById(R.id.editTextTextEmailAddress);
        EditText passwordEditText = findViewById(R.id.editTextTextPassword);

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Enter a valid email address");
            valid = false;
        } else {
            emailEditText.setError(null);
        }

        if (TextUtils.isEmpty(password) || password.length() < 8) {
            passwordEditText.setError("Password must be at least 8 characters");
            valid = false;
        } else {
            passwordEditText.setError(null);
        }

        return valid;
    }

    // AlertDialog For Exit
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LogIn_User.this);

        builder.setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity(); // Close the activity
                        Toast.makeText(LogIn_User.this, "Thanks For Using Our App", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Dismiss the dialog, do nothing
                        Toast.makeText(LogIn_User.this, "Thanks For Staying", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Rate Us", new DialogInterface.OnClickListener() {
                    @SuppressLint("QueryPermissionsNeeded")
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        // Create a URI with subject and body
                        Uri uri = Uri.parse("mailto:bhabanishankarr21@gmail.com" +
                                "?subject=" + Uri.encode("Rating Of The App") +
                                "&body=" + Uri.encode("Write About Our App"));
                        intent.setData(uri);
                        intent.setPackage("com.google.android.gm");
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                            Toast.makeText(LogIn_User.this, "Mail Us Your Rating To Us", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LogIn_User.this, "Gmail App Is Not Installed", Toast.LENGTH_SHORT).show();
                        }
                        startActivity(intent);
                    }
                })
                .show();
    }
    // Add Intent For Choose Location
}
