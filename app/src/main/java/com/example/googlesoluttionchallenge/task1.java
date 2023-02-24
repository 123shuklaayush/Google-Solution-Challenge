package com.example.googlesoluttionchallenge;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Calendar;

import android.widget.Button;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;

public class task1 extends AppCompatActivity {

    EditText areaNameEditText, lastTimeWateredEditText;
    Button addButton;
    LinearLayout listLayout;
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);
        areaNameEditText = findViewById(R.id.area_name_edit_text);
        lastTimeWateredEditText = findViewById(R.id.last_time_watered_edit_text);
        addButton = findViewById(R.id.button);
        listLayout = findViewById(R.id.listLayout);
        scrollView = findViewById(R.id.scrollView);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String areaName = areaNameEditText.getText().toString();
                String lastTimeWatered = lastTimeWateredEditText.getText().toString();

                if (!areaName.isEmpty() && !lastTimeWatered.isEmpty()) {
                    addTask(areaName, lastTimeWatered);
                    areaNameEditText.setText("");
                    lastTimeWateredEditText.setText("");
                }
            }
        });
        lastTimeWateredEditText = findViewById(R.id.last_time_watered_edit_text);
        lastTimeWateredEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a Calendar instance to set the DatePickerDialog's date to the current date
                final Calendar calendar = Calendar.getInstance();

                // Create a DatePickerDialog instance and set its date and listener
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        task1.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                // Set the chosen date to the EditText field
                                lastTimeWateredEditText.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        },
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                );

                // Show the DatePickerDialog
                datePickerDialog.show();
            }
        });
    }
    private void addTask(String areaName, String lastTimeWatered) {
        // Create a new LinearLayout to hold the task information
        LinearLayout taskLayout = new LinearLayout(this);
        taskLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 0, 24);
        taskLayout.setLayoutParams(layoutParams);

        // Set the background color and border for the task
        GradientDrawable border = new GradientDrawable();
        border.setColor(Color.WHITE);
        border.setStroke(2, Color.BLACK);
        taskLayout.setBackground(border);

        // Create TextViews to display the task information
        TextView areaNameTextView = new TextView(this);
        areaNameTextView.setText("Area Name: " + areaName);
        areaNameTextView.setTextSize(16);
        areaNameTextView.setPadding(16, 16, 16, 0);
        taskLayout.addView(areaNameTextView);

        TextView lastTimeWateredTextView = new TextView(this);
        lastTimeWateredTextView.setText("Last Time Watered: " + lastTimeWatered);
        lastTimeWateredTextView.setTextSize(16);
        lastTimeWateredTextView.setPadding(16, 8, 16, 16);
        taskLayout.addView(lastTimeWateredTextView);

        // Add the task to the list
        listLayout.addView(taskLayout);

        // Scroll to the bottom of the list
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}