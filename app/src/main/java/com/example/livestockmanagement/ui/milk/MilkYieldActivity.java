package com.example.livestockmanagement.ui.milk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.livestockmanagement.R;

public class MilkYieldActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseRecyclerAdapter<MilkRecord, MilkRecordViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milk_yield);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("milk_records")
                .orderByChild("date");

        FirebaseRecyclerOptions<MilkRecord> options =
                new FirebaseRecyclerOptions.Builder<MilkRecord>()
                        .setQuery(query, MilkRecord.class)
                        .build();

        adapter = new FirebaseRecyclerAdapter<MilkRecord, MilkRecordViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MilkRecordViewHolder holder, int position, @NonNull MilkRecord model) {
                holder.setDate(model.getDate());
                holder.setYield(model.getYield());
                holder.setIcon(position % 2 == 0 ? R.drawable.ic_moon : R.drawable.ic_settings);
            }

            @NonNull
            @Override
            public MilkRecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_milk_record, parent, false);
                return new MilkRecordViewHolder(view);
            }
        };

        recyclerView.setAdapter(adapter);

        findViewById(R.id.deleteButton).setOnClickListener(v -> {
            // Implement delete functionality
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public static class MilkRecordViewHolder extends RecyclerView.ViewHolder {
        private final TextView dateView;
        private final TextView yieldView;
        private final ImageView iconView;

        public MilkRecordViewHolder(@NonNull View itemView) {
            super(itemView);
            dateView = itemView.findViewById(R.id.dateTextView);
            yieldView = itemView.findViewById(R.id.yieldTextView);
            iconView = itemView.findViewById(R.id.iconImageView);
        }

        public void setDate(String date) {
            dateView.setText(date);
        }

        public void setYield(String yield) {
            yieldView.setText(yield);
        }

        public void setIcon(int resourceId) {
            iconView.setImageResource(resourceId);
        }
    }

    public static class MilkRecord {
        private String date;
        private String yield;

        public MilkRecord() {
            // Default constructor required for Firebase
        }

        public MilkRecord(String date, String yield) {
            this.date = date;
            this.yield = yield;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getYield() {
            return yield;
        }

        public void setYield(String yield) {
            this.yield = yield;
        }
    }
}