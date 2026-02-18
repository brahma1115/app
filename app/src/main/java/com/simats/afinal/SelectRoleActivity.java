package com.simats.afinal;

import android.content.Intent;
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

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectRoleActivity.this, SelectHospitalActivity.class));
            }
        };

        doctorCard.setOnClickListener(listener);
        nurseCard.setOnClickListener(listener);
        therapistCard.setOnClickListener(listener);
        adminCard.setOnClickListener(listener);
    }
}