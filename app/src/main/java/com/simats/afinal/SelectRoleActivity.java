package com.simats.afinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SelectRoleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_role);

        CardView doctorCard = findViewById(R.id.doctorCard);
        CardView nurseCard = findViewById(R.id.nurseCard);
        CardView therapistCard = findViewById(R.id.therapistCard);
        CardView adminCard = findViewById(R.id.adminCard);

        View.OnClickListener listener = v -> {
            String role = "";
            if (v.getId() == R.id.doctorCard) role = "Doctor / Physician";
            else if (v.getId() == R.id.nurseCard) role = "Nurse";
            else if (v.getId() == R.id.therapistCard) role = "Respiratory Therapist";
            else if (v.getId() == R.id.adminCard) role = "Administrator";

            SharedPreferences sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("role", role);
            editor.apply();

            startActivity(new Intent(SelectRoleActivity.this, SelectHospitalActivity.class));
        };

        doctorCard.setOnClickListener(listener);
        nurseCard.setOnClickListener(listener);
        therapistCard.setOnClickListener(listener);
        adminCard.setOnClickListener(listener);
    }
}