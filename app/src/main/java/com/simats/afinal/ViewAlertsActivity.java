package com.simats.afinal;

import android.content.Intent;
import android.graphics.Color;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ViewAlertsActivity extends AppCompatActivity implements View.OnClickListener {

    Button allButton, criticalButton, warningButton;
    LinearLayout alertsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_alerts);

        allButton = findViewById(R.id.allButton);
        criticalButton = findViewById(R.id.criticalButton);
        warningButton = findViewById(R.id.warningButton);
        alertsContainer = findViewById(R.id.alertsContainer);

        allButton.setOnClickListener(this);
        criticalButton.setOnClickListener(this);
        warningButton.setOnClickListener(this);

        // Alert Card Click Listeners
        findViewById(R.id.alertCard1).setOnClickListener(v -> openCriticalAlert("Rajesh Kumar", "ICU-01", "High Pressure"));
        findViewById(R.id.alertCard3).setOnClickListener(v -> openCriticalAlert("Sneha Reddy", "ICU-04", "Low SpO2"));
        findViewById(R.id.alertCard5).setOnClickListener(v -> openCriticalAlert("Anjali Gupta", "ICU-06", "Low Pulse"));

        findViewById(R.id.alertCard2).setOnClickListener(v -> openAlertDetails("Priya Sharma", "ICU-02", "High RR", "15m ago"));
        findViewById(R.id.alertCard4).setOnClickListener(v -> openAlertDetails("Vikram Singh", "ICU-05", "High Temp", "45m ago"));
        findViewById(R.id.alertCard6).setOnClickListener(v -> openAlertDetails("Rahul Verma", "ICU-07", "Apnea Alert", "2h ago"));

        // Initial state
        updateFilter("All", allButton);
    }

    private void openCriticalAlert(String name, String bed, String type) {
        Intent intent = new Intent(this, CriticalAlertActivity.class);
        intent.putExtra("patientName", name);
        intent.putExtra("bedId", bed);
        intent.putExtra("alertType", type);
        startActivity(intent);
    }

    private void openAlertDetails(String name, String bed, String type, String time) {
        Intent intent = new Intent(this, AlertDetailsActivity.class);
        intent.putExtra("patientName", name);
        intent.putExtra("bedId", bed);
        intent.putExtra("alertType", type);
        intent.putExtra("time", time);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.allButton) {
            updateFilter("All", allButton);
        } else if (v.getId() == R.id.criticalButton) {
            updateFilter("Critical", criticalButton);
        } else if (v.getId() == R.id.warningButton) {
            updateFilter("Warning", warningButton);
        }
    }

    private void updateFilter(String filter, Button selectedButton) {
        allButton.setBackgroundResource(R.drawable.filter_button_unselected_background);
        allButton.setTextColor(Color.BLACK);
        criticalButton.setBackgroundResource(R.drawable.filter_button_unselected_background);
        criticalButton.setTextColor(Color.BLACK);
        warningButton.setBackgroundResource(R.drawable.filter_button_unselected_background);
        warningButton.setTextColor(Color.BLACK);

        selectedButton.setBackgroundResource(R.drawable.filter_button_selected_background);
        selectedButton.setTextColor(Color.WHITE);

        for (int i = 0; i < alertsContainer.getChildCount(); i++) {
            View card = alertsContainer.getChildAt(i);
            if (card instanceof CardView) {
                String tag = (String) card.getTag();
                if ("All".equals(filter) || filter.equals(tag)) {
                    card.setVisibility(View.VISIBLE);
                } else {
                    card.setVisibility(View.GONE);
                }
            }
        }
    }
}
