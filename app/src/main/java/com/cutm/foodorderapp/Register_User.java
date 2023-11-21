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

import com.cutm.foodorderapp.Database.DatabaseHelper;
import com.cutm.foodorderapp.Database.User;

public class Register_User extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        setContentView(R.layout.activity_register_user);

        // Initialize DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        TextView textView = findViewById(R.id.textView_log_redirect);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_User.this, LogIn_User.class);
                startActivity(intent);
                Toast.makeText(Register_User.this, "LogIn With Your Credentials", Toast.LENGTH_SHORT).show();
            }
        });

        Button registerButton = findViewById(R.id.button4);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateForm()) {
                    // Proceed with registration logic
                    String name = getNameFromEditText();
                    String email = getEmailFromEditText();
                    String password = getPasswordFromEditText();

                    // Create a new user
                    User newUser = new User(name, email, password);

                    // Add the user to the database
                    databaseHelper.addUser(newUser);

                    // Start the LogIn_User activity
                    Intent intent = new Intent(Register_User.this, LogIn_User.class);
                    startActivity(intent);
                    Toast.makeText(Register_User.this, "Registration successful! Log in with your credentials.", Toast.LENGTH_SHORT).show();

                    // Finish the current activity
                    finish();
                }
            }
        });
    }

    private boolean validateForm() {
        EditText nameEditText = findViewById(R.id.edittext_register);
        EditText emailEditText = findViewById(R.id.edittext_register1);
        EditText passwordEditText = findViewById(R.id.edittext_register2);

        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        boolean valid = true;

        if (TextUtils.isEmpty(name)) {
            nameEditText.setError("Name is required");
            valid = false;
        } else {
            nameEditText.setError(null);
        }

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

    //AlertDialog For Exit
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Register_User.this);

        builder.setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finishAffinity(); // Close the activity
                        Toast.makeText(Register_User.this, "Thanks For Using Our App", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Dismiss the dialog, do nothing
                        Toast.makeText(Register_User.this, "Thanks For Staying", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Rate Us", new DialogInterface.OnClickListener() {
                    @SuppressLint("QueryPermissionsNeeded")
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("mailto:bhabanishankarr21@gmail.com"));
                        Uri uri = Uri.parse("mailto:example@example.com" +
                                "?subject=" + Uri.encode("Rating Of The App") +
                                "&body=" + Uri.encode("Write About Our App"));
                        intent.setData(uri);
                        intent.setPackage("com.google.android.gm");
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                            Toast.makeText(Register_User.this, "Mail Us Your Rating To Us", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Register_User.this, "Gmail App Is Not Installed", Toast.LENGTH_SHORT).show();
                        }
                        startActivity(intent);
                    }
                })
                .show();
    }

    private String getNameFromEditText() {
        EditText nameEditText = findViewById(R.id.edittext_register);
        return nameEditText.getText().toString();
    }

    private String getEmailFromEditText() {
        EditText emailEditText = findViewById(R.id.edittext_register1);
        return emailEditText.getText().toString();
    }

    private String getPasswordFromEditText() {
        EditText passwordEditText = findViewById(R.id.edittext_register2);
        return passwordEditText.getText().toString();
    }
}
