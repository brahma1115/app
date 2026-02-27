package com.simats.afinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SelectHospitalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_hospital);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        View.OnClickListener listener = v -> {
            String hospitalName = "";
            if (v.getId() == R.id.hospital1) hospitalName = "St. Jude Medical Center";
            else if (v.getId() == R.id.hospital2) hospitalName = "General Hospital";
            else if (v.getId() == R.id.hospital3) hospitalName = "City Medical Center";
            else if (v.getId() == R.id.hospital4) hospitalName = "Community Health Clinic";

            SharedPreferences sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("hospital", hospitalName);
            editor.apply();

            startActivity(new Intent(SelectHospitalActivity.this, SelectDepartmentActivity.class));
        };

        findViewById(R.id.hospital1).setOnClickListener(listener);
        findViewById(R.id.hospital2).setOnClickListener(listener);
        findViewById(R.id.hospital3).setOnClickListener(listener);
        findViewById(R.id.hospital4).setOnClickListener(listener);
    }
}