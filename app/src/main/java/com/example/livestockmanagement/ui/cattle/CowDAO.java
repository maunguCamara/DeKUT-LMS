package com.example.livestockmanagement.ui.cattle;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CowDAO{
private static DatabaseReference databaseReference;


public CowDAO() {
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    databaseReference = firebaseDatabase.getReference().child("cows");
}

//Update cow health status in the database
public static void updateCowHealthStatus(String cattleNumber, com.example.livestockmanagement.ui.cattle.Cow.HealthStatus newHealthStatus) {
    DatabaseReference cowRef = databaseReference.child(cattleNumber);
    try {
        cowRef.child("healthStatus").setValue(newHealthStatus.name());
    } catch (Exception e) {
        System.out.println("An error occurred while updating cow health status: " + e.getMessage());
    }

}
public static void uploadCowDetails(String cowName, String tagNumber, String breed, String purpose, String weight, String age){}
public static void updateCowWeight(String tagNumber, String age){}
public static void updateCowAge(String tagNumber, String age){}



}