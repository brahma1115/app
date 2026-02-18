package com.simats.afinal;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class AppearanceActivity extends AppCompatActivity {

    CardView lightModeCard, darkModeCard, systemDefaultCard;
    ImageView lightModeCheck, darkModeCheck, systemDefaultCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appearance);

        ImageView backButton = findViewById(R.id.backButton);
        lightModeCard = findViewById(R.id.lightModeCard);
        darkModeCard = findViewById(R.id.darkModeCard);
        systemDefaultCard = findViewById(R.id.systemDefaultCard);
        darkModeCheck = findViewById(R.id.darkModeCheck);
        systemDefaultCheck = findViewById(R.id.systemDefaultCheck);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        lightModeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCheck(lightModeCheck);
            }
        });

        darkModeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCheck(darkModeCheck);
            }
        });

        systemDefaultCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCheck(systemDefaultCheck);
            }
        });
    }

    private void updateCheck(ImageView selectedCheck) {
        lightModeCheck.setVisibility(View.GONE);
        darkModeCheck.setVisibility(View.GONE);
        systemDefaultCheck.setVisibility(View.GONE);
        selectedCheck.setVisibility(View.VISIBLE);
    }
}