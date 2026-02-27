package com.simats.afinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        findViewById(R.id.backButton).setOnClickListener(v -> finish());

        Spinner roleSpinner = findViewById(R.id.roleSpinner);
        String[] roles = {"Select your role", "Doctor / Physician", "Nurse", "Respiratory Therapist", "Administrator"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_layout, roles) {
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    tv.setTextColor(getResources().getColor(R.color.grey));
                } else {
                    tv.setTextColor(getResources().getColor(R.color.black));
                }
                return view;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(adapter);

        CheckBox termsCheckBox = findViewById(R.id.termsCheckBox);
        Button createAccountButton = findViewById(R.id.createAccountButton);

        termsCheckBox.setText(Html.fromHtml("I agree to the <a href=\"#\">Terms of Service</a> and <a href=\"#\">Privacy Policy</a>"));
        termsCheckBox.setMovementMethod(LinkMovementMethod.getInstance());

        termsCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            createAccountButton.setEnabled(isChecked);
        });

        createAccountButton.setOnClickListener(v -> {
            EditText fullNameEditText = findViewById(R.id.fullNameEditText);
            String fullName = fullNameEditText.getText().toString();

            if (fullName.isEmpty() || roleSpinner.getSelectedItemPosition() == 0) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Save Initial Data
                SharedPreferences sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("fullName", fullName);
                editor.apply();

                Intent intent = new Intent(SignupActivity.this, SelectRoleActivity.class);
                startActivity(intent);
            }
        });

        TextView loginTextView = findViewById(R.id.loginTextView);
        loginTextView.setOnClickListener(v -> {
            Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}
