package com.example.livestockmanagement.ui.health;
//To include treatment and vaccination records
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class HealthRecordsActivity extends AppCompatActivity {

    private Spinner recordTypeSpinner, parentFlockSpinner, recordDateSpinner;
    private EditText diseaseTypeEditText, dosageEditText, medicationEditText, noteEditText;
    private Button saveButton;
    private FloatingActionButton fab;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_records);

        initializeViews();
        setupSpinners();
        setupListeners();
    }

    private void initializeViews() {
        recordTypeSpinner = findViewById(R.id.record_type_spinner);
        parentFlockSpinner = findViewById(R.id.parent_flock_spinner);
        recordDateSpinner = findViewById(R.id.record_date_spinner);
        diseaseTypeEditText = findViewById(R.id.disease_type_edittext);
        dosageEditText = findViewById(R.id.dosage_edittext);
        medicationEditText = findViewById(R.id.medication_edittext);
        noteEditText = findViewById(R.id.note_edittext);
        saveButton = findViewById(R.id.save_button);
        fab = findViewById(R.id.fab);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    private void setupSpinners() {
        // Setup Record Type Spinner
        ArrayList<String> recordTypes = new ArrayList<>(Arrays.asList("Treatment", "Vaccination", "Medication", "Other"));
        ArrayAdapter<String> recordTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, recordTypes);
        recordTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        recordTypeSpinner.setAdapter(recordTypeAdapter);

        // Setup Parent Flock Spinner
        ArrayList<String> parentFlocks = new ArrayList<>(Arrays.asList("All Flocks", "Flock 1", "Flock 2", "Flock 3"));
        ArrayAdapter<String> parentFlockAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, parentFlocks);
        parentFlockAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        parentFlockSpinner.setAdapter(parentFlockAdapter);

        // Setup Record Date Spinner
        ArrayList<String> recordDates = new ArrayList<>(Arrays.asList("Today", "Yesterday", "Last Week", "Custom"));
        ArrayAdapter<String> recordDateAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, recordDates);
        recordDateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        recordDateSpinner.setAdapter(recordDateAdapter);
    }

    private void setupListeners() {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveHealthRecord();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle FAB click
                Toast.makeText(HealthRecordsActivity.this, "Add new item clicked", Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            // Handle navigation item selection
            // You'll need to implement this based on your menu items
            return true;
        });
    }

    private void saveHealthRecord() {
        // Implement the logic to save the health record
        // This is where you'd typically save to a database or send to an API
        String recordType = recordTypeSpinner.getSelectedItem().toString();
        String parentFlock = parentFlockSpinner.getSelectedItem().toString();
        String recordDate = recordDateSpinner.getSelectedItem().toString();
        String diseaseType = diseaseTypeEditText.getText().toString();
        String dosage = dosageEditText.getText().toString();
        String medication = medicationEditText.getText().toString();
        String note = noteEditText.getText().toString();

        // For now, just show a toast message
        String message = "Record saved: " + recordType + ", " + parentFlock + ", " + recordDate;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        // Clear the form or navigate back
        clearForm();
    }

    private void clearForm() {
        recordTypeSpinner.setSelection(0);
        parentFlockSpinner.setSelection(0);
        recordDateSpinner.setSelection(0);
        diseaseTypeEditText.setText("");
        dosageEditText.setText("");
        medicationEditText.setText("");
        noteEditText.setText("");
    }
}