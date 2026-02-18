package com.simats.afinal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileSettingsActivity extends AppCompatActivity {

    private EditText fullName, emailAddress, phoneNumber, department, employeeId;
    private Button saveChangesButton;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);

        fullName = findViewById(R.id.full_name_edit_text);
        emailAddress = findViewById(R.id.email_address_edit_text);
        phoneNumber = findViewById(R.id.phone_number_edit_text);
        department = findViewById(R.id.department_edit_text);
        employeeId = findViewById(R.id.employee_id_edit_text);
        saveChangesButton = findViewById(R.id.saveChangesButton);
        backButton = findViewById(R.id.backButton);

        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Save changes logic here
                Toast.makeText(ProfileSettingsActivity.this, "Changes saved!", Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
