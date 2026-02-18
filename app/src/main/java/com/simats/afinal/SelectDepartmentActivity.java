package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SelectDepartmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_department);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectDepartmentActivity.this, SelectHospitalActivity.class));
            }
        });

        CardView icuCard = findViewById(R.id.icuCard);
        CardView nicuCard = findViewById(R.id.nicuCard);
        CardView picuCard = findViewById(R.id.picuCard);
        CardView ccuCard = findViewById(R.id.ccuCard);
        CardView erCard = findViewById(R.id.erCard);
        CardView wardCard = findViewById(R.id.wardCard);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectDepartmentActivity.this, HomeActivity.class));
            }
        };

        icuCard.setOnClickListener(listener);
        nicuCard.setOnClickListener(listener);
        picuCard.setOnClickListener(listener);
        ccuCard.setOnClickListener(listener);
        erCard.setOnClickListener(listener);
        wardCard.setOnClickListener(listener);
    }
}