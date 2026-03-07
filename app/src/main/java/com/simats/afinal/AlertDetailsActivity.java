package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AlertDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_details);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        // Get data from Intent
        String patientName = getIntent().getStringExtra("patientName");
        String bedId = getIntent().getStringExtra("bedId");
        String alertType = getIntent().getStringExtra("alertType");
        String time = getIntent().getStringExtra("time");

        // Find views
        TextView alertTitleTv = findViewById(R.id.alertTitle);
        TextView patientInfoTv = findViewById(R.id.patientInfo);
        TextView triggeredTimeTv = findViewById(R.id.triggeredTime);
        TextView currentValueTv = findViewById(R.id.currentValue);
        TextView limitValueTv = findViewById(R.id.limitValue);
        TextView probableCauseTv = findViewById(R.id.probableCauseText);
        TextView suggestedActionTv = findViewById(R.id.suggestedActionText);
        TextView viewFullAiDetails = findViewById(R.id.viewFullAiDetails);

        // Update UI with dynamic data if available
        if (patientName != null && bedId != null) {
            patientInfoTv.setText("Patient: " + patientName + " (" + bedId + ")");
        }
        if (alertType != null) {
            alertTitleTv.setText(alertType);
        }
        if (time != null) {
            triggeredTimeTv.setText("Triggered: " + time + " (15m ago)");
        }

        // View Full AI Details Click Listener
        viewFullAiDetails.setOnClickListener(v -> {
            Intent intent = new Intent(AlertDetailsActivity.this, SmartAlarmAIActivity.class);
            intent.putExtra("patientName", patientName);
            intent.putExtra("bedId", bedId);
            startActivity(intent);
        });

        // Custom details for different alerts
        if ("Irregular Rhythm".equals(alertType)) {
            currentValueTv.setText("110 bpm");
            limitValueTv.setText("100 bpm");
            probableCauseTv.setText("Potential arrhythmia detected. Patient may be experiencing discomfort.");
            suggestedActionTv.setText("• Check ECG monitor\n• Assess patient vitals\n• Notify cardiologist if persistent");
        }

        Button acknowledgeButton = findViewById(R.id.acknowledgeButton);
        acknowledgeButton.setOnClickListener(v -> {
            Toast.makeText(this, "Alert Acknowledged", Toast.LENGTH_SHORT).show();
        });

        Button escalateButton = findViewById(R.id.escalateButton);
        escalateButton.setOnClickListener(v -> {
            Intent intent = new Intent(AlertDetailsActivity.this, EscalateAlertActivity.class);
            intent.putExtra("patientName", patientName);
            intent.putExtra("bedId", bedId);
            intent.putExtra("alertType", alertType);
            startActivity(intent);
        });
    }
}
