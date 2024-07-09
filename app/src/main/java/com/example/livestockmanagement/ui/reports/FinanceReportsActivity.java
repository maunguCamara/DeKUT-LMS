package com.example.livestockmanagement.ui.reports;


import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.livestockmanagement.R;

public class FinanceReportsActivity extends AppCompatActivity                {


    private CardView financeReportsCardView;
    private CardView milkSaleCardView;
    private CardView animalSaleCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_reports);

        financeReportsCardView =findViewById(R.id.finance_report_card_view);
        milkSaleCardView = findViewById(R.id.milk_sales_card_view);
        animalSaleCardView = findViewById(R.id.animal_sales_card_view);

    }
}
