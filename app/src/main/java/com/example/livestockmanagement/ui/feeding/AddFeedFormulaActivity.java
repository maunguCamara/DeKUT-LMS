package com.example.livestockmanagement.ui.feeding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.livestockmanagement.MainActivity;
import com.example.livestockmanagement.R;
import com.example.livestockmanagement.ui.health.HealthRecordsActivity;
import com.example.livestockmanagement.ui.reports.FinanceReportsActivity;
import com.example.livestockmanagement.ui.tasks.TasksActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CreateFeedFormulaActivity extends AppCompatActivity {

    private EditText feedNameEditText;
    private EditText ingredientNameEditText;
    private EditText ingredientQuantityEditText;
    private Spinner ingredientUnitSpinner;
    private Spinner animalTypeSpinner;
    private EditText nutritionalInfoEditText;
    private EditText noteEditText;
    private Button addIngredientButton;
    private Button removeIngredientButton;
    private Button saveChangesButton;
    private LinearLayout ingredientsContainer;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_feed_formula);

        initializeViews();
        setupSpinners();
        setupListeners();
    }

    private void initializeViews() {
        feedNameEditText = findViewById(R.id.feed_name_edit_text);
        ingredientNameEditText = findViewById(R.id.ingredient_name_edit_text);
        ingredientQuantityEditText = findViewById(R.id.ingredient_quantity_edit_text);
        ingredientUnitSpinner = findViewById(R.id.ingredient_unit_spinner);
        animalTypeSpinner = findViewById(R.id.animal_type_spinner);
        nutritionalInfoEditText = findViewById(R.id.nutritional_info_edit_text);
        noteEditText = findViewById(R.id.note_edit_text);
        addIngredientButton = findViewById(R.id.add_ingredient_button);
        removeIngredientButton = findViewById(R.id.remove_ingredient_button);
        saveChangesButton = findViewById(R.id.save_changes_button);
        ingredientsContainer = findViewById(R.id.ingredients_container);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    private void setupSpinners() {
        ArrayAdapter<CharSequence> unitAdapter = ArrayAdapter.createFromResource(this,
                R.array.ingredient_units, android.R.layout.simple_spinner_item);
        unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ingredientUnitSpinner.setAdapter(unitAdapter);

        ArrayAdapter<CharSequence> animalAdapter = ArrayAdapter.createFromResource(this,
                R.array.animal_types, android.R.layout.simple_spinner_item);
        animalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        animalTypeSpinner.setAdapter(animalAdapter);
    }

    private void setupListeners() {
        addIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addIngredient();
            }
        });

        removeIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeIngredient();
            }
        });

        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveChanges();
            }
        });

        // TODO OnclickListeners for the bottom nav

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Intent intent = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    intent = new Intent(HealthRecordsActivity.this, MainActivity.class);
                    break;
                case R.id.navigation_tasks:
                    intent = new Intent(HealthRecordsActivity.this, TasksActivity.class);
                    break;
                case R.id.navigation_reports:
                    intent = new Intent(HealthRecordsActivity.this, FinanceReportsActivity.class);
                    break;

            }
            if (intent != null) {
                startActivity(intent);
                return true;
            }
            return false;
        });
    }

    private void addIngredient() {
        // Implement logic to add ingredient to the list
    }

    private void removeIngredient() {
        // Implement logic to remove the last ingredient from the list
    }

    private void saveChanges() {
        // Implement logic to save the feed formula
    }
}
