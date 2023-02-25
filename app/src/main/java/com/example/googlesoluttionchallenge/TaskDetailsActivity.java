package com.example.googlesoluttionchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class TaskDetailsActivity extends AppCompatActivity {
    private TextView areaNameTextView, lastTimeWateredTextView;
    private Button giveNowButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        // Initialize the views
        areaNameTextView = findViewById(R.id.area_name_text_view);
        lastTimeWateredTextView = findViewById(R.id.last_watered_text_view);
        giveNowButton = findViewById(R.id.give_now_button);


        // Get the area name and last time watered from the intent extras
        String areaName = getIntent().getStringExtra("areaName");
        String lastTimeWatered = getIntent().getStringExtra("lastTimeWatered");

        // Set the area name and last time watered to the text views
        areaNameTextView.setText(areaName);
        lastTimeWateredTextView.setText(lastTimeWatered);

        // Set a click listener on the Give Now button
        giveNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Add code to perform action when Give Now button is clicked
            }
        });
    }
}