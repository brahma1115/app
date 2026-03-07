package com.simats.afinal;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EscalateAlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escalate_alert);

        // Back Button
        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        // Get data from Intent
        String patientName = getIntent().getStringExtra("patientName");
        String bedId = getIntent().getStringExtra("bedId");
        String alertType = getIntent().getStringExtra("alertType");

        TextView headerText = findViewById(R.id.escalationHeaderText);

        // Update header with dynamic patient details
        if (patientName != null && bedId != null && alertType != null) {
            headerText.setText("Escalating: " + alertType + " (" + bedId + ")");
        } else if (bedId != null) {
            headerText.setText("Escalating: Alert (Bed " + bedId + ")");
        }

        // Chat Listeners
        findViewById(R.id.chatDrSunita).setOnClickListener(v -> 
            Toast.makeText(this, "Opening chat with Dr. Sunita Verma", Toast.LENGTH_SHORT).show());
        findViewById(R.id.chatNurseLakshmi).setOnClickListener(v -> 
            Toast.makeText(this, "Opening chat with Nurse Lakshmi", Toast.LENGTH_SHORT).show());
        findViewById(R.id.chatRajesh).setOnClickListener(v -> 
            Toast.makeText(this, "Opening chat with Rajesh Sharma", Toast.LENGTH_SHORT).show());

        // Call Listeners
        findViewById(R.id.callDrSunita).setOnClickListener(v -> 
            Toast.makeText(this, "Calling Dr. Sunita Verma...", Toast.LENGTH_SHORT).show());
        findViewById(R.id.callNurseLakshmi).setOnClickListener(v -> 
            Toast.makeText(this, "Calling Nurse Lakshmi...", Toast.LENGTH_SHORT).show());
        findViewById(R.id.callRajesh).setOnClickListener(v -> 
            Toast.makeText(this, "Calling Rajesh Sharma...", Toast.LENGTH_SHORT).show());
    }
}
