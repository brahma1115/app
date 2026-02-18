package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MonitorActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CardView patientCard1, patientCard2, patientCard3, patientCard4, patientCard5, patientCard6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MonitorActivity.this, HomeActivity.class));
                finish();
            }
        });

        patientCard1 = findViewById(R.id.patientCard1);
        patientCard2 = findViewById(R.id.patientCard2);
        patientCard3 = findViewById(R.id.patientCard3);
        patientCard4 = findViewById(R.id.patientCard4);
        patientCard5 = findViewById(R.id.patientCard5);
        patientCard6 = findViewById(R.id.patientCard6);

        patientCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMonitorBed("ICU-01", "24", "5.0", "450", "18", "40", "1:2.0");
            }
        });

        patientCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMonitorBed("ICU-02", "26", "5.2", "380", "24", "50", "1:1.8");
            }
        });

        patientCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMonitorBed("ICU-03", "22", "4.8", "290", "32", "80", "1:2.2");
            }
        });

        patientCard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMonitorBed("ICU-04", "25", "5.1", "460", "16", "35", "1:2.0");
            }
        });

        patientCard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMonitorBed("ICU-05", "23", "4.9", "420", "20", "45", "1:1.9");
            }
        });

        patientCard6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMonitorBed("ICU-06", "27", "5.3", "390", "22", "55", "1:1.7");
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_monitor);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_monitor) {
                    return true;
                } else if (itemId == R.id.navigation_home) {
                    startActivity(new Intent(MonitorActivity.this, HomeActivity.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_patients) {
                    startActivity(new Intent(MonitorActivity.this, PatientsActivity.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_alerts) {
                    startActivity(new Intent(MonitorActivity.this, AlertsOverviewActivity.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_settings) {
                    startActivity(new Intent(MonitorActivity.this, SettingsActivity.class));
                    finish();
                    return true;
                }
                return false;
            }
        });
    }

    private void openMonitorBed(String bedId, String ppeak, String peep, String vte, String rr, String fio2, String ie) {
        Intent intent = new Intent(this, MonitorBedActivity.class);
        intent.putExtra("bedId", bedId);
        intent.putExtra("ppeak", ppeak);
        intent.putExtra("peep", peep);
        intent.putExtra("vte", vte);
        intent.putExtra("rr", rr);
        intent.putExtra("fio2", fio2);
        intent.putExtra("ie", ie);
        startActivity(intent);
    }
}