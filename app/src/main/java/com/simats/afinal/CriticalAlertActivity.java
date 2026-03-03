package com.simats.afinal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CriticalAlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_critical_alert);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        // Get patient data from Intent
        String patientName = getIntent().getStringExtra("patientName");
        String bedId = getIntent().getStringExtra("bedId");
        String alertType = getIntent().getStringExtra("alertType");

        TextView alertTitleTv = findViewById(R.id.alertTitle);
        TextView alertDescriptionTv = findViewById(R.id.alertDescription);

        if (alertType != null) {
            alertTitleTv.setText(alertType.toUpperCase());
        }

        if (patientName != null && bedId != null) {
            alertDescriptionTv.setText("Patient: " + patientName + " (" + bedId + ")\nAirway obstruction or kinked tube suspected.");
        }

        Button silenceButton = findViewById(R.id.silenceButton);
        silenceButton.setOnClickListener(v -> {
            Toast.makeText(this, "Alarm Silenced for 2 min", Toast.LENGTH_SHORT).show();
        });

        Button escalateButton = findViewById(R.id.escalateButton);
        escalateButton.setOnClickListener(v -> {
            Toast.makeText(this, "Escalating / Calling Code...", Toast.LENGTH_LONG).show();
        });
    }
}
