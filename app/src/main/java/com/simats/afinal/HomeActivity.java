package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Find all the views
        ImageView notificationButton = findViewById(R.id.notificationButton);
        CardView activePatientsCard = findViewById(R.id.activePatientsCard);
        CardView patientsCard = findViewById(R.id.patientsCard);
        CardView activeVentsCard = findViewById(R.id.activeVentsCard);
        CardView monitorCard = findViewById(R.id.monitorCard);
        CardView activeAlertsCard = findViewById(R.id.activeAlertsCard);
        CardView alertsCard = findViewById(R.id.alertsCard);
        CardView predictiveAlertsCard = findViewById(R.id.predictiveAlertsCard);
        CardView falseAlarmCard = findViewById(R.id.falseAlarmCard);
        CardView highRiskCard = findViewById(R.id.highRiskCard);
        CardView aiAssistantCard = findViewById(R.id.aiAssistantCard);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set up listeners
        notificationButton.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, NotificationsActivity.class)));

        View.OnClickListener patientsListener = v -> startActivity(new Intent(HomeActivity.this, PatientsActivity.class));
        activePatientsCard.setOnClickListener(patientsListener);
        patientsCard.setOnClickListener(patientsListener);

        View.OnClickListener monitorListener = v -> startActivity(new Intent(HomeActivity.this, MonitorActivity.class));
        activeVentsCard.setOnClickListener(monitorListener);
        monitorCard.setOnClickListener(monitorListener);

        View.OnClickListener alertsListener = v -> startActivity(new Intent(HomeActivity.this, ViewAlertsActivity.class));
        activeAlertsCard.setOnClickListener(alertsListener);
        alertsCard.setOnClickListener(alertsListener);

        predictiveAlertsCard.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, AIPredictiveAnalyticsActivity.class)));
        falseAlarmCard.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, SmartAlarmAIActivity.class)));
        highRiskCard.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, AiRiskAssessmentActivity.class)));
        aiAssistantCard.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, AiAssistantActivity.class)));

        // Other listeners for recent alerts...
        CardView recentAlertCard1 = findViewById(R.id.recentAlertCard1);
        recentAlertCard1.setOnClickListener(v -> openPatientDetails("John Doe", "ICU-04", "Critical", "High Pressure", "B402", "2024-07-28", "Dr. Smith", "120 bpm", "92%"));

        CardView recentAlertCard2 = findViewById(R.id.recentAlertCard2);
        recentAlertCard2.setOnClickListener(v -> openPatientDetails("Jane Smith", "ICU-02", "Warning", "Low SpO2", "B405", "2024-07-28", "Dr. Jones", "90 bpm", "85%"));

        CardView recentAlertCard3 = findViewById(R.id.recentAlertCard3);
        recentAlertCard3.setOnClickListener(v -> openPatientDetails("Robert Johnson", "NICU-01", "Critical", "High Heart Rate", "N101", "2024-07-28", "Dr. Williams", "180 bpm", "95%"));

        CardView recentAlertCard4 = findViewById(R.id.recentAlertCard4);
        recentAlertCard4.setOnClickListener(v -> openPatientDetails("Emily Davis", "PICU-03", "Warning", "Irregular Rhythm", "P202", "2024-07-28", "Dr. Brown", "110 bpm", "93%"));


        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                return true;
            } else if (itemId == R.id.navigation_patients) {
                startActivity(new Intent(HomeActivity.this, PatientsActivity.class));
                finish();
                return true;
            } else if (itemId == R.id.navigation_monitor) {
                startActivity(new Intent(HomeActivity.this, MonitorActivity.class));
                finish();
                return true;
            } else if (itemId == R.id.navigation_alerts) {
                startActivity(new Intent(HomeActivity.this, ViewAlertsActivity.class));
                finish();
                return true;
            } else if (itemId == R.id.navigation_settings) {
                startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
                finish();
                return true;
            }
            return false;
        });
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
