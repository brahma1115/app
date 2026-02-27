package com.simats.afinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView backButton = findViewById(R.id.backButton_profile);
        backButton.setOnClickListener(v -> finish());

        // Load user details from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
        String fullName = sharedPreferences.getString("fullName", "Dr. Alex River");
        String role = sharedPreferences.getString("role", "Medical Practitioner");
        String hospital = sharedPreferences.getString("hospital", "St. Jude Medical Center");
        String department = sharedPreferences.getString("department", "General Ward");

        // Set the values to the TextViews
        TextView fullNameTextView = findViewById(R.id.profile_name);
        TextView roleTextView = findViewById(R.id.profile_role);
        TextView currentRoleValue = findViewById(R.id.role_value);
        TextView hospitalTextView = findViewById(R.id.hospital_value);
        TextView departmentTextView = findViewById(R.id.department_value);

        fullNameTextView.setText(fullName);
        roleTextView.setText(role);
        currentRoleValue.setText(role);
        hospitalTextView.setText(hospital);
        departmentTextView.setText(department);

        Button signOutButton = findViewById(R.id.signOutButton);
        signOutButton.setOnClickListener(v -> {
            // Clear SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();

            // Navigate to Login screen
            Toast.makeText(ProfileActivity.this, "Signing out...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }
}
