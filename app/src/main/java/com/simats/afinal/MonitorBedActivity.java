package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MonitorBedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_bed);

        ImageView backButton = findViewById(R.id.backButton);
        TextView monitorBedTitle = findViewById(R.id.monitorBedTitle);
        TextView ppeakValue = findViewById(R.id.ppeakValue);
        TextView peepValue = findViewById(R.id.peepValue);
        TextView vteValue = findViewById(R.id.vteValue);
        TextView rrValue = findViewById(R.id.rrValue);
        TextView fio2Value = findViewById(R.id.fio2Value);
        TextView ieValue = findViewById(R.id.ieValue);

        String bedId = getIntent().getStringExtra("bedId");
        String ppeak = getIntent().getStringExtra("ppeak");
        String peep = getIntent().getStringExtra("peep");
        String vte = getIntent().getStringExtra("vte");
        String rr = getIntent().getStringExtra("rr");
        String fio2 = getIntent().getStringExtra("fio2");
        String ie = getIntent().getStringExtra("ie");

        if (bedId != null) {
            monitorBedTitle.setText("Monitor: Bed " + bedId);
        }
        if (ppeak != null) {
            ppeakValue.setText(ppeak);
        }
        if (peep != null) {
            peepValue.setText(peep);
        }
        if (vte != null) {
            vteValue.setText(vte);
        }
        if (rr != null) {
            rrValue.setText(rr);
        }
        if (fio2 != null) {
            fio2Value.setText(fio2);
        }
        if (ie != null) {
            ieValue.setText(ie);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_monitor);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_monitor) {
                    // Already on the monitor related screen
                    return true;
                } else if (itemId == R.id.navigation_home) {
                    startActivity(new Intent(MonitorBedActivity.this, HomeActivity.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_patients) {
                    startActivity(new Intent(MonitorBedActivity.this, PatientsActivity.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_alerts) {
                    startActivity(new Intent(MonitorBedActivity.this, AlertsOverviewActivity.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_settings) {
                    startActivity(new Intent(MonitorBedActivity.this, SettingsActivity.class));
                    finish();
                    return true;
                }
                return false;
            }
        });
    }
}