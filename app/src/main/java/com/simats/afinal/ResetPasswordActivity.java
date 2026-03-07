package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText newPasswordEditText, confirmPasswordEditText;
    private ProgressBar passwordStrengthBar;
    private TextView passwordStrengthValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        newPasswordEditText = findViewById(R.id.newPasswordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        passwordStrengthBar = findViewById(R.id.passwordStrengthBar);
        passwordStrengthValue = findViewById(R.id.passwordStrengthValue);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        newPasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateStrength(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        Button updatePasswordButton = findViewById(R.id.updatePasswordButton);
        updatePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newPassword = newPasswordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                if (TextUtils.isEmpty(newPassword) || TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(ResetPasswordActivity.this, "Both fields are required", Toast.LENGTH_SHORT).show();
                } else if (!newPassword.equals(confirmPassword)) {
                    Toast.makeText(ResetPasswordActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ResetPasswordActivity.this, "Password Updated Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ResetPasswordActivity.this, LoginActivity.class));
                    finish();
                }
            }
        });
    }

    private void calculateStrength(String password) {
        int strength = 0;
        if (password.length() > 0) {
            boolean hasLetters = password.matches(".*[a-zA-Z].*");
            boolean hasDigits = password.matches(".*[0-9].*");
            boolean hasSpecial = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*");

            if (hasLetters && hasDigits && hasSpecial) {
                strength = 90;
            } else if ((hasLetters && hasDigits) || (hasLetters && hasSpecial) || (hasDigits && hasSpecial)) {
                strength = 60;
            } else {
                strength = 35;
            }
        }

        passwordStrengthBar.setProgress(strength);
        passwordStrengthValue.setText(strength + "%");
    }
}