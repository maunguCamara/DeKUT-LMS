package com.example.livestockmanagement.ui.feeding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FeedingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ration_wizard);

        LinearLayout contentLayout = findViewById(R.id.contentLayout);

        // Populate Daily Needs
        String[] dailyNeeds = {"Dry Matter, kg", "Protein (g/day)", "Energy (kcal/day)"};
        String[] dailyNeedValues = {"14.36", "1666.23", "35905.40"};
        for (int i = 0; i < dailyNeeds.length; i++) {
            View itemView = LayoutInflater.from(this).inflate(R.layout.item_daily_need, contentLayout, false);
            TextView nameTextView = itemView.findViewById(R.id.needName);
            TextView valueTextView = itemView.findViewById(R.id.needValue);
            nameTextView.setText(dailyNeeds[i]);
            valueTextView.setText(dailyNeedValues[i]);
            contentLayout.addView(itemView);
        }

        // Populate Parameters
        String[] parameters = {"Body Weight (kg)", "Milk Yield (kg/day)", "Milk Fat", "Lactation Day"};
        String[] parameterValues = {"500", "15", "2.4", "150"};
        for (int i = 0; i < parameters.length; i++) {
            View itemView = LayoutInflater.from(this).inflate(R.layout.item_parameter, contentLayout, false);
            TextView nameTextView = itemView.findViewById(R.id.paramName);
            TextView valueTextView = itemView.findViewById(R.id.paramValue);
            nameTextView.setText(parameters[i]);
            valueTextView.setText(parameterValues[i]);
            contentLayout.addView(itemView);
        }

        findViewById(R.id.backButton).setOnClickListener(v -> finish());
    }
}
