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

public class SettingsActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    CardView profileSettingsCard, notificationsCard, securityCard, appearanceCard, helpCard, aboutCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, HomeActivity.class);
                startActivity(intent);
                finish(); // Finish current activity to avoid stacking
            }
        });

        profileSettingsCard = findViewById(R.id.profile_settings_card);
        profileSettingsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, ProfileSettingsActivity.class);
                startActivity(intent);
            }
        });

        notificationsCard = findViewById(R.id.notificationsCard);
        notificationsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, AlertSettingsActivity.class);
                startActivity(intent);
            }
        });

        securityCard = findViewById(R.id.securityCard);
        securityCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, SecurityPrivacyActivity.class);
                startActivity(intent);
            }
        });

        appearanceCard = findViewById(R.id.appearanceCard);
        appearanceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, AppearanceActivity.class);
                startActivity(intent);
            }
        });

        helpCard = findViewById(R.id.helpCard);
        helpCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, HelpSupportActivity.class);
                startActivity(intent);
            }
        });

        aboutCard = findViewById(R.id.aboutCard);
        aboutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_settings);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_settings) {
                    return true;
                } else if (itemId == R.id.navigation_home) {
                    startActivity(new Intent(SettingsActivity.this, HomeActivity.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_patients) {
                    startActivity(new Intent(SettingsActivity.this, PatientsActivity.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_monitor) {
                    startActivity(new Intent(SettingsActivity.this, MonitorActivity.class));
                    finish();
                    return true;
                } else if (itemId == R.id.navigation_alerts) {
                    startActivity(new Intent(SettingsActivity.this, AlertsOverviewActivity.class));
                    finish();
                    return true;
                }
                return false;
            }
        });
    }
}