package com.example.livestockmanagement.ui.cattle;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.livestockmanagement.R;

import java.util.List;

public class CowListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CowAdapter cowAdapter;
    private CowDAO cowDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cowDao = new CowDAO(this);

        fetchAndDisplayCows();
    }

    private void fetchAndDisplayCows() {
        List<Cow> cowList = cowDao.getAllCows();
        if (cowList.isEmpty()) {
            Toast.makeText(this, "No cows found", Toast.LENGTH_SHORT).show();
        }
        cowAdapter = new CowAdapter(cowList);
        recyclerView.setAdapter(cowAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cowDao.close();
    }
}
