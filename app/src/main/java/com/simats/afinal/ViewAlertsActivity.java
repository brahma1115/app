package com.simats.afinal;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ViewAlertsActivity extends AppCompatActivity implements View.OnClickListener {

    Button activeButton, historyButton, escalatedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_alerts);

        activeButton = findViewById(R.id.activeButton);
        historyButton = findViewById(R.id.historyButton);
        escalatedButton = findViewById(R.id.escalatedButton);

        activeButton.setOnClickListener(this);
        historyButton.setOnClickListener(this);
        escalatedButton.setOnClickListener(this);

        // Initially, 'Active' should be selected
        updateButtonStyles(activeButton);
    }

    @Override
    public void onClick(View v) {
        // The view that was clicked is passed as 'v'
        // We can cast it to a Button and pass it to our style method.
        updateButtonStyles((Button) v);
    }

    private void updateButtonStyles(Button selectedButton) {
        // Reset all buttons to the default, non-selected state
        activeButton.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
        activeButton.setTextColor(ContextCompat.getColor(this, android.R.color.black));
        historyButton.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
        historyButton.setTextColor(ContextCompat.getColor(this, android.R.color.black));
        escalatedButton.setBackgroundTintList(ColorStateList.valueOf(Color.TRANSPARENT));
        escalatedButton.setTextColor(ContextCompat.getColor(this, android.R.color.black));

        // Set the selected button to the highlighted state
        selectedButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#007BFF")));
        selectedButton.setTextColor(ContextCompat.getColor(this, android.R.color.white));
    }
}