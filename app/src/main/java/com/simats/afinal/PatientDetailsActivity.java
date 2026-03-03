package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class PatientDetailsActivity extends AppCompatActivity {

    private static final int EDIT_PATIENT_REQUEST = 2;
    private TextView patientNameTextView, patientIdTextView, patientStatusTextView, diagnosisValue, bedValue, admissionValue, physicianValue, heartRateValue, spo2Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        // Initialize TextViews
        patientNameTextView = findViewById(R.id.patientName);
        patientIdTextView = findViewById(R.id.patientId);
        patientStatusTextView = findViewById(R.id.patientStatus);
        diagnosisValue = findViewById(R.id.diagnosisValue);
        bedValue = findViewById(R.id.bedValue);
        admissionValue = findViewById(R.id.admissionValue);
        physicianValue = findViewById(R.id.physicianValue);
        heartRateValue = findViewById(R.id.heartRateValue);
        spo2Value = findViewById(R.id.spo2Value);

        // Load initial data
        updateUI(getIntent());

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        ImageView editButton = findViewById(R.id.editButton);
        editButton.setOnClickListener(v -> {
            Intent intent = new Intent(PatientDetailsActivity.this, AddPatientActivity.class);
            intent.putExtra("patientName", patientNameTextView.getText().toString());
            intent.putExtra("patientId", patientIdTextView.getText().toString());
            intent.putExtra("patientStatus", patientStatusTextView.getText().toString());
            intent.putExtra("diagnosis", diagnosisValue.getText().toString());
            intent.putExtra("bed", bedValue.getText().toString());
            intent.putExtra("admission", admissionValue.getText().toString());
            intent.putExtra("physician", physicianValue.getText().toString());
            intent.putExtra("isEditing", true);
            startActivityForResult(intent, EDIT_PATIENT_REQUEST);
        });

        // AI-Powered Assessment Card click listener
        CardView aiAssessmentCard = findViewById(R.id.aiAssessmentCard);
        aiAssessmentCard.setOnClickListener(v -> {
            Intent intent = new Intent(PatientDetailsActivity.this, AiRiskAssessmentActivity.class);
            startActivity(intent);
        });

        // Ventilator Status Card click listener - Navigating to Monitor Bed
        CardView ventilatorStatusCard = findViewById(R.id.ventilatorStatusCard);
        ventilatorStatusCard.setOnClickListener(v -> {
            Intent intent = new Intent(PatientDetailsActivity.this, MonitorBedActivity.class);
            intent.putExtra("patientName", patientNameTextView.getText().toString());
            intent.putExtra("bedId", bedValue.getText().toString());
            // passing ventilator specific details as well
            intent.putExtra("peep", "8.0");
            intent.putExtra("fio2", "60%");
            intent.putExtra("rr", "24");
            intent.putExtra("mode", "AC/VC");
            startActivity(intent);
        });

        Button viewVitalsButton = findViewById(R.id.viewVitalsButton);
        viewVitalsButton.setOnClickListener(v -> {
            Intent intent = new Intent(PatientDetailsActivity.this, VitalsHistoryActivity.class);
            startActivity(intent);
        });

        Button ventilatorSettingsButton = findViewById(R.id.ventilatorSettingsButton);
        ventilatorSettingsButton.setOnClickListener(v -> {
            Intent intent = new Intent(PatientDetailsActivity.this, VentilatorSettingsActivity.class);
            startActivity(intent);
        });

        CardView aiAnomalyCard = findViewById(R.id.ai_anomaly_card);
        aiAnomalyCard.setOnClickListener(v -> {
            Intent intent = new Intent(PatientDetailsActivity.this, AnomalyDetectionActivity.class);
            startActivity(intent);
        });

        CardView patientHistoryCard = findViewById(R.id.patient_history_card);
        patientHistoryCard.setOnClickListener(v -> {
            Intent intent = new Intent(PatientDetailsActivity.this, PatientHistoryActivity.class);
            startActivity(intent);
        });

        CardView reportsAndNotesCard = findViewById(R.id.reports_and_notes_card);
        reportsAndNotesCard.setOnClickListener(v -> {
            Intent intent = new Intent(PatientDetailsActivity.this, ReportsAndDocumentsActivity.class);
            startActivity(intent);
        });
    }

    private void updateUI(Intent intent) {
        if (intent != null) {
            patientNameTextView.setText(intent.getStringExtra("patientName"));
            patientIdTextView.setText(intent.getStringExtra("patientId"));
            patientStatusTextView.setText(intent.getStringExtra("patientStatus"));
            diagnosisValue.setText(intent.getStringExtra("diagnosis"));
            bedValue.setText(intent.getStringExtra("bed"));
            admissionValue.setText(intent.getStringExtra("admission"));
            physicianValue.setText(intent.getStringExtra("physician"));
            
            String hr = intent.getStringExtra("heartRate");
            String s2 = intent.getStringExtra("spo2");
            if (hr != null) heartRateValue.setText(hr);
            if (s2 != null) spo2Value.setText(s2);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EDIT_PATIENT_REQUEST && resultCode == RESULT_OK && data != null) {
            updateUI(data);
        }
    }
}
