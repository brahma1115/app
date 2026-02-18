package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class AIPredictiveAnalyticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_predictive_analytics);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        CardView predictedEventCard1 = findViewById(R.id.predictedEventCard1);
        predictedEventCard1.setOnClickListener(v -> openPatientDetails("John Doe", "ICU-01", "Predicted", "High Peak Pressure", "B402", "2024-07-28", "Dr. Smith", "120 bpm", "92%"));

        CardView predictedEventCard2 = findViewById(R.id.predictedEventCard2);
        predictedEventCard2.setOnClickListener(v -> openPatientDetails("Sarah Smith", "ICU-04", "Predicted", "Desaturation < 90%", "B405", "2024-07-28", "Dr. Jones", "90 bpm", "85%"));

        CardView predictedEventCard3 = findViewById(R.id.predictedEventCard3);
        predictedEventCard3.setOnClickListener(v -> openPatientDetails("Mike Johnson", "ICU-02", "Predicted", "Rapid Shallow Breathing", "N101", "2024-07-28", "Dr. Williams", "180 bpm", "95%"));
    }

    private void openPatientDetails(String name, String id, String status, String diagnosis, String bed, String admission, String physician, String heartRate, String spo2) {
        Intent intent = new Intent(this, PatientDetailsActivity.class);
        intent.putExtra("patientName", name);
        intent.putExtra("patientId", id);
        intent.putExtra("patientStatus", status);
        intent.putExtra("diagnosis", diagnosis);
        intent.putExtra("bed", bed);
        intent.putExtra("admission", admission);
        intent.putExtra("physician", physician);
        intent.putExtra("heartRate", heartRate);
        intent.putExtra("spo2", spo2);
        startActivity(intent);
    }
}
