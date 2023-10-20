package com.cutm.foodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class choose_location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.status_bar_color));
        setContentView(R.layout.activity_choose_location);
        Button button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choose_location.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(choose_location.this, "Welcome!To Our Home Page", Toast.LENGTH_SHORT).show();
            }
        });
        // Find the Spinner by its ID
        Spinner spinner = findViewById(R.id.List_Loc);
        String[] items = {
                "Choose Location","Angul", "Balangir", "Balasore", "Bargarh", "Barbil", "Bhadrak", "Bhawanipatna",
                "Bhubaneswar", "Brahmapur", "Byasanagar", "Cuttack", "Dhenkanal", "Ganjam",
                "Jagatsinghpur", "Jajpur", "Jeypore", "Jharsuguda", "Kamakhyanagar", "Kantabanji",
                "Kendrapara", "Kendujhar", "Kesinga", "Khordha", "Koraput", "Kuchinda",
                "Malkangiri", "Nabarangpur", "Nilagiri", "Padampur", "Paradeep", "Paradip",
                "Parlakhemundi", "Phulabani", "Puri", "Rajgangpur", "Rayagada", "Rourkela",
                "Sambalpur", "Sonepur", "Sunabeda", "Talcher", "Titlagarh"
        };


        // Create a list of locations
        List<String> locations = new ArrayList<>();
        // Add more locations as needed

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.custom_spinner_dropdown_item, items);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Set an item selected listener for the spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle the selected item here
                String selectedLocation = (String) parent.getItemAtPosition(position);
                // Perform any actions based on the selected location
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do something when nothing is selected
            }
        });
    }
}