package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AlertsOverviewActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts_overview);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlertsOverviewActivity.this, HomeActivity.class));
                finish();
            }
        });

        Button viewAllAlertsButton = findViewById(R.id.viewAllAlertsButton);
        viewAllAlertsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AlertsOverviewActivity.this, ViewAlertsActivity.class));
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_alerts);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_alerts) {
                    return true;
                } else if (itemId == R.id.navigation_home) {
                    startActivity(new Intent(AlertsOverviewActivity.this, HomeActivity.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_patients) {
                    startActivity(new Intent(AlertsOverviewActivity.this, PatientsActivity.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_monitor) {
                    startActivity(new Intent(AlertsOverviewActivity.this, MonitorActivity.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_settings) {
                    startActivity(new Intent(AlertsOverviewActivity.this, SettingsActivity.class));
                    finish();
                    return true;
                }
                return false;
            }
        });
    }
}