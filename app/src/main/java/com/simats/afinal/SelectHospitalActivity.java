package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SelectHospitalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_hospital);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectHospitalActivity.this, SelectRoleActivity.class));
            }
        });

        CardView hospital1 = findViewById(R.id.hospital1);
        CardView hospital2 = findViewById(R.id.hospital2);
        CardView hospital3 = findViewById(R.id.hospital3);
        CardView hospital4 = findViewById(R.id.hospital4);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectHospitalActivity.this, SelectDepartmentActivity.class));
            }
        };

        hospital1.setOnClickListener(listener);
        hospital2.setOnClickListener(listener);
        hospital3.setOnClickListener(listener);
        hospital4.setOnClickListener(listener);
    }
}