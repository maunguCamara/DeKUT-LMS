package com.example.livestockmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.livestockmanagement.databinding.ActivityMainBinding;
import com.example.livestockmanagement.ui.cattle.CowListActivity;
import com.example.livestockmanagement.ui.feeding.FeedingActivity;
import com.example.livestockmanagement.ui.health.HealthRecordsActivity;
import com.example.livestockmanagement.ui.milk.MilkRecordsActivity;
import com.example.livestockmanagement.ui.reports.FinanceReportsActivity;
import com.example.livestockmanagement.ui.tasks.TasksActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private CardView cattleCardView;
    private CardView milkCardView;
    private CardView healthCardView;
    private CardView feedingCardView;
    private CardView reportsCardView;
    private CardView summaryCardView;
    private TextView textViewPregnant;
    private TextView textViewLactating;
    private TextView textViewTotal;
    private ImageView cowIcon;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.topBar;
        setSupportActionBar(toolbar);


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        drawerLayout = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_cattle, R.id.nav_milk, R.id.nav_health, R.id.nav_feeding, R.id.nav_breeding)
                .setOpenableLayout(drawerLayout)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        cowIcon = binding.cattleIcon;
        textViewLactating = binding.textViewLactating;
        textViewPregnant = binding.textViewPregnant;
        textViewTotal = binding.textViewTotal;
        cattleCardView = binding.cattleCardView;
        milkCardView = binding.milkCardView;
        healthCardView = binding.healthCardView;
        feedingCardView = binding.feedingCardView;
        reportsCardView = binding.financeReportCardView;
        summaryCardView = binding.summaryCardView;



/*
        cattleCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CowListActivity.class);
                startActivity(intent);
            }
        });

        milkCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MilkRecordsActivity.class);
                startActivity(intent);
            }
        });

        healthCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HealthRecordsActivity.class);
                startActivity(intent);
            }
        });

        feedingCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FeedingActivity.class);
                startActivity(intent);
            }
        });


        reportsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FinanceReportsActivity.class);
                startActivity(intent);
            }
        });

 */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
