package com.simats.afinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AnomalyDetectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anomaly_detection);

        ImageView backButton = findViewById(R.id.backButton_anomaly_detection);
        backButton.setOnClickListener(v -> finish());

        Button markAsReviewedButton = findViewById(R.id.mark_as_reviewed_button);
        markAsReviewedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AnomalyDetectionActivity.this, "Marked all as reviewed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
