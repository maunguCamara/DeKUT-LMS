package com.example.livestockmanagement.ui.cattle;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.livestockmanagement.R;

public class CowDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        TextView nameTextView = findViewById(R.id.cow_name);
        TextView tagTextView = findViewById(R.id.tag);
        TextView ageTextView = findViewById(R.id.text_age);
        TextView genderTextView = findViewById(R.id.text_gender);
        TextView breedTextView = findViewById(R.id.text_breed);
        TextView statusTextView = findViewById(R.id.text_status);
        TextView purposeTextView = findViewById(R.id.text_purpose);
        TextView weightTextView = findViewById(R.id.text_weight);
        //TextView milkProductionTextView = findViewById(R.id.milk_production);

        Cow cow = (Cow) getIntent().getSerializableExtra("cow");

        if (cow != null) {
            nameTextView.setText(getString(R.string.cow_name, cow.getName()));
            tagTextView.setText(getString(R.string.text_tag, cow.getTagNumber()));
            ageTextView.setText(getString(R.string.text_age, cow.getAge()));
            genderTextView.setText(getString(R.string.text_gender, cow.getGender()));
            breedTextView.setText(getString(R.string.text_breed, cow.getBreed()));
            purposeTextView.setText(getString(R.string.text_purpose, cow.getPurpose()));
            weightTextView.setText(getString(R.string.text_weight, cow.getWeight()));
            //milkProductionTextView.setText(getString(R.string.milk_production, cow.getMilkProductionPerDay()));
        }
    }
}