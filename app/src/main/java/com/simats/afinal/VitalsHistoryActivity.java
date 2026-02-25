package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class VitalsHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitals_history);

        ImageView backButton = findViewById(R.id.backButton_vitals_history);
        backButton.setOnClickListener(v -> {
            finish();
        });

        Button btn4h = findViewById(R.id.btn_4h);
        Button btn12h = findViewById(R.id.btn_12h);
        Button btn24h = findViewById(R.id.btn_24h);
        Button btn7d = findViewById(R.id.btn_7d);

        View.OnClickListener timeRangeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle time range button clicks here
            }
        };

        btn4h.setOnClickListener(timeRangeListener);
        btn12h.setOnClickListener(timeRangeListener);
        btn24h.setOnClickListener(timeRangeListener);
        btn7d.setOnClickListener(timeRangeListener);
    }
}
