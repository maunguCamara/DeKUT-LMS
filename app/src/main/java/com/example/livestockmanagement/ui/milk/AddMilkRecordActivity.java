package com.example.livestockmanagement.ui.milk;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.livestockmanagement.R;

public class AddMilkRecordActivity extends AppCompatActivity {
    private TextView textView;
    private EditText dateEditText;
    private EditText morningEditText;
    private EditText afternoonEditText;
    private EditText eveningEditText;
    private EditText totalEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_milk_record);

        // Initialize views
        textView = findViewById(R.id.textView);
        dateEditText = findViewById(R.id.dateEditText);
        morningEditText = findViewById(R.id.morningEditText);
        afternoonEditText = findViewById(R.id.afternoonEditText);
        eveningEditText = findViewById(R.id.eveningEditText);
        totalEditText = findViewById(R.id.totalEditText);
        saveButton = findViewById(R.id.saveButton);

        // Set up the save button click listener
        saveButton.setOnClickListener(v -> {
            // Get the input values
            String date = dateEditText.getText().toString();
            String morningMilk = morningEditText.getText().toString();
            String afternoonMilk = afternoonEditText.getText().toString();
            String eveningMilk = eveningEditText.getText().toString();
            String totalMilk = totalEditText.getText().toString();

            // For now, just show a Toast with the input values
            Toast.makeText(AddMilkRecordActivity.this,
                    "Date: " + date + "\nMorning: " + morningMilk + "\nAfternoon: " + afternoonMilk + "\nEvening: " + eveningMilk + "\nTotal: " + totalMilk,
                    Toast.LENGTH_LONG).show();

            // TODO: Add logic to save the milk record
        });
    }
}
