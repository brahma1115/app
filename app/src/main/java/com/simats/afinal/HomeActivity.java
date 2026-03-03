package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
        TextView userInitials = findViewById(R.id.userInitials);
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
        userInitials.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, ProfileActivity.class)));

        View.OnClickListener patientsListener = v -> startActivity(new Intent(HomeActivity.this, PatientsActivity.class));
        activePatientsCard.setOnClickListener(patientsListener);
        patientsCard.setOnClickListener(patientsListener);

        View.OnClickListener monitorListener = v -> startActivity(new Intent(HomeActivity.this, MonitorActivity.class));
        activeVentsCard.setOnClickListener(monitorListener);
        monitorCard.setOnClickListener(monitorListener);

        View.OnClickListener alertsListener = v -> startActivity(new Intent(HomeActivity.this, AlertsOverviewActivity.class));
        activeAlertsCard.setOnClickListener(alertsListener);
        alertsCard.setOnClickListener(alertsListener);

        predictiveAlertsCard.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, AIPredictiveAnalyticsActivity.class)));
        falseAlarmCard.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, SmartAlarmAIActivity.class)));
        highRiskCard.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, AiRiskAssessmentActivity.class)));
        aiAssistantCard.setOnClickListener(v -> startActivity(new Intent(HomeActivity.this, AiAssistantActivity.class)));

        // Recent alert listeners
        CardView recentAlertCard1 = findViewById(R.id.recentAlertCard1); // Critical: Rajesh Kumar
        recentAlertCard1.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CriticalAlertActivity.class);
            intent.putExtra("patientName", "Rajesh Kumar");
            intent.putExtra("bedId", "ICU-04");
            intent.putExtra("alertType", "High Pressure");
            startActivity(intent);
        });

        CardView recentAlertCard2 = findViewById(R.id.recentAlertCard2); // Warning: Priya Sharma
        recentAlertCard2.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, AlertDetailsActivity.class);
            intent.putExtra("patientName", "Priya Sharma");
            intent.putExtra("bedId", "ICU-02");
            intent.putExtra("alertType", "High Respiratory Rate");
            intent.putExtra("time", "10:42 AM");
            startActivity(intent);
        });

        CardView recentAlertCard3 = findViewById(R.id.recentAlertCard3); // Critical: Arjun Deshmukh
        recentAlertCard3.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, CriticalAlertActivity.class);
            intent.putExtra("patientName", "Arjun Deshmukh");
            intent.putExtra("bedId", "NICU-01");
            intent.putExtra("alertType", "High Pressure");
            startActivity(intent);
        });

        CardView recentAlertCard4 = findViewById(R.id.recentAlertCard4); // Warning: Sneha Reddy
        recentAlertCard4.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, AlertDetailsActivity.class);
            intent.putExtra("patientName", "Sneha Reddy");
            intent.putExtra("bedId", "PICU-03");
            intent.putExtra("alertType", "Irregular Rhythm");
            intent.putExtra("time", "10:42 AM");
            startActivity(intent);
        });


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
                startActivity(new Intent(HomeActivity.this, AlertsOverviewActivity.class));
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
}
