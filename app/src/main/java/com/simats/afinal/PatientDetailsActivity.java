package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PatientDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView editButton = findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientDetailsActivity.this, AddPatientActivity.class);
                intent.putExtra("patientName", getIntent().getStringExtra("patientName"));
                intent.putExtra("patientId", getIntent().getStringExtra("patientId"));
                intent.putExtra("patientStatus", getIntent().getStringExtra("patientStatus"));
                intent.putExtra("diagnosis", getIntent().getStringExtra("diagnosis"));
                intent.putExtra("bed", getIntent().getStringExtra("bed"));
                intent.putExtra("admission", getIntent().getStringExtra("admission"));
                intent.putExtra("physician", getIntent().getStringExtra("physician"));
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String patientName = intent.getStringExtra("patientName");
        String patientId = intent.getStringExtra("patientId");
        String patientStatus = intent.getStringExtra("patientStatus");
        String diagnosis = intent.getStringExtra("diagnosis");
        String bed = intent.getStringExtra("bed");
        String admission = intent.getStringExtra("admission");
        String physician = intent.getStringExtra("physician");
        String heartRate = intent.getStringExtra("heartRate");
        String spo2 = intent.getStringExtra("spo2");

        TextView patientNameTextView = findViewById(R.id.patientName);
        TextView patientIdTextView = findViewById(R.id.patientId);
        TextView patientStatusTextView = findViewById(R.id.patientStatus);
        TextView diagnosisValue = findViewById(R.id.diagnosisValue);
        TextView bedValue = findViewById(R.id.bedValue);
        TextView admissionValue = findViewById(R.id.admissionValue);
        TextView physicianValue = findViewById(R.id.physicianValue);
        TextView heartRateValue = findViewById(R.id.heartRateValue);
        TextView spo2Value = findViewById(R.id.spo2Value);

        patientNameTextView.setText(patientName);
        patientIdTextView.setText(patientId);
        patientStatusTextView.setText(patientStatus);
        diagnosisValue.setText(diagnosis);
        bedValue.setText(bed);
        admissionValue.setText(admission);
        physicianValue.setText(physician);
        heartRateValue.setText(heartRate);
        spo2Value.setText(spo2);
    }
}