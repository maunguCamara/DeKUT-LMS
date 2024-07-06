package com.example.livestockmanagement.ui.cattle;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.livestockmanagement.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
public class CowListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CowAdapter cowAdapter;
    private List<Cow> cowList;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cowList = new ArrayList<>();
        cowAdapter = new CowAdapter(cowList);
        recyclerView.setAdapter(cowAdapter);

        db = FirebaseFirestore.getInstance();

        //fetchRecyclerData();
        fetchAndDisplayCows();
    }

//    private void fetchRecyclerData() {
//        db.collection("cows")
//                .get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        if (!queryDocumentSnapshots.isEmpty()) {
//                            cowList.clear();  // Clear the list before adding new data
//                            for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
//                                Cow cow = documentSnapshot.toObject(Cow.class);
//                                cowList.add(cow);
//                            }
//                            cowAdapter.notifyDataSetChanged();
//                        }
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(CowListActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
    private void fetchAndDisplayCows() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference cowsRef = database.getReference("cows");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Cow> cowList = new ArrayList<>();
        CowAdapter adapter = new CowAdapter(cowList);
        recyclerView.setAdapter(adapter);

        cowsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cowList.clear();
                for (DataSnapshot cowSnapshot : dataSnapshot.getChildren()) {
                    Cow cow = cowSnapshot.getValue(Cow.class);
                    if (cow != null) {
                        cowList.add(cow);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Firebase", "Error fetching cows: " + databaseError.getMessage());
                Toast.makeText(CowListActivity.this, "Error fetching cows", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

