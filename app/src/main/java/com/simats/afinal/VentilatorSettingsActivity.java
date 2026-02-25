package com.simats.afinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class VentilatorSettingsActivity extends AppCompatActivity {

    private TextView tidalVolumeValue, respRateValue, peepValue, fio2Value;
    private Button btnAcVc, btnSimv, btnPsv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventilator_settings);

        ImageView backButton = findViewById(R.id.backButton_ventilator_settings);
        backButton.setOnClickListener(v -> finish());

        tidalVolumeValue = findViewById(R.id.tidal_volume_value);
        respRateValue = findViewById(R.id.resp_rate_value);
        peepValue = findViewById(R.id.peep_value);
        fio2Value = findViewById(R.id.fio2_value);

        // Ventilation Mode Buttons
        btnAcVc = findViewById(R.id.btn_ac_vc);
        btnSimv = findViewById(R.id.btn_simv);
        btnPsv = findViewById(R.id.btn_psv);

        View.OnClickListener modeListener = v -> {
            setModeButtonState(btnAcVc, false);
            setModeButtonState(btnSimv, false);
            setModeButtonState(btnPsv, false);
            setModeButtonState((Button) v, true);
            Toast.makeText(VentilatorSettingsActivity.this, ((Button) v).getText().toString() + " selected", Toast.LENGTH_SHORT).show();
        };

        btnAcVc.setOnClickListener(modeListener);
        btnSimv.setOnClickListener(modeListener);
        btnPsv.setOnClickListener(modeListener);

        // Set initial state
        setModeButtonState(btnAcVc, true);

        // Plus/Minus Buttons
        findViewById(R.id.tidal_volume_minus).setOnClickListener(v -> updateValue(tidalVolumeValue, -10));
        findViewById(R.id.tidal_volume_plus).setOnClickListener(v -> updateValue(tidalVolumeValue, 10));

        findViewById(R.id.resp_rate_minus).setOnClickListener(v -> updateValue(respRateValue, -1));
        findViewById(R.id.resp_rate_plus).setOnClickListener(v -> updateValue(respRateValue, 1));

        findViewById(R.id.peep_minus).setOnClickListener(v -> updateValue(peepValue, -1));
        findViewById(R.id.peep_plus).setOnClickListener(v -> updateValue(peepValue, 1));

        findViewById(R.id.fio2_minus).setOnClickListener(v -> updateValue(fio2Value, -1));
        findViewById(R.id.fio2_plus).setOnClickListener(v -> updateValue(fio2Value, 1));

        // Apply Settings Button
        Button applySettingsButton = findViewById(R.id.apply_settings_button);
        applySettingsButton.setOnClickListener(v -> {
            // Handle apply settings click here
            Toast.makeText(VentilatorSettingsActivity.this, "New settings applied", Toast.LENGTH_SHORT).show();
        });
    }

    private void updateValue(TextView textView, int change) {
        int currentValue = Integer.parseInt(textView.getText().toString());
        textView.setText(String.valueOf(currentValue + change));
    }

    private void setModeButtonState(Button button, boolean isSelected) {
        if (isSelected) {
            button.setBackgroundResource(R.drawable.btn_mode_selected);
            button.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        } else {
            button.setBackgroundResource(R.drawable.btn_mode_unselected);
            button.setTextColor(ContextCompat.getColor(this, android.R.color.black));
        }
    }
}
