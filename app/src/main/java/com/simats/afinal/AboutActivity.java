package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_settings);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_settings) {
                    // Already on the settings related screen
                    return true;
                } else if (itemId == R.id.navigation_home) {
                    startActivity(new Intent(AboutActivity.this, HomeActivity.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_patients) {
                    startActivity(new Intent(AboutActivity.this, PatientsActivity.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_monitor) {
                    startActivity(new Intent(AboutActivity.this, MonitorActivity.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_alerts) {
                    startActivity(new Intent(AboutActivity.this, AlertsOverviewActivity.class));
                    finish();
                    return true;
                }
                return false;
            }
        });
    }
}