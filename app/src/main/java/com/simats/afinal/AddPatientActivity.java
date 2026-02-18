package com.simats.afinal;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class AddPatientActivity extends AppCompatActivity {

    private TextInputEditText dobEditText;
    private TextInputEditText admissionDateEditText;
    private TextInputEditText fullNameEditText;
    private TextInputEditText patientIdEditText;
    private AutoCompleteTextView genderSpinner;
    private TextInputEditText weightEditText;
    private TextInputEditText diagnosisEditText;
    private TextInputEditText bedEditText;
    private AutoCompleteTextView physicianSpinner;
    private Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        physicianSpinner = findViewById(R.id.physicianSpinner);
        String[] physicians = {"Dr. Sarah Wilson", "Dr. James Chen", "Dr. Emily Ross"};
        ArrayAdapter<String> physicianAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, physicians);
        physicianSpinner.setAdapter(physicianAdapter);

        genderSpinner = findViewById(R.id.genderSpinner);
        String[] genders = {"Male", "Female", "Other"};
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, genders);
        genderSpinner.setAdapter(genderAdapter);

        dobEditText = findViewById(R.id.dobEditText);
        admissionDateEditText = findViewById(R.id.admissionDateEditText);
        fullNameEditText = findViewById(R.id.fullNameEditText);
        patientIdEditText = findViewById(R.id.patientIdEditText);
        weightEditText = findViewById(R.id.weightEditText);
        diagnosisEditText = findViewById(R.id.diagnosisEditText);
        bedEditText = findViewById(R.id.bedEditText);
        saveButton = findViewById(R.id.saveButton);

        TextInputLayout dobLayout = findViewById(R.id.dobLayout);
        dobLayout.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(dobEditText);
            }
        });

        TextInputLayout admissionDateLayout = findViewById(R.id.admissionDateLayout);
        admissionDateLayout.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(admissionDateEditText);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fullNameEditText.getText().toString();
                String id = patientIdEditText.getText().toString();
                String dob = dobEditText.getText().toString();
                String gender = genderSpinner.getText().toString();
                String weight = weightEditText.getText().toString();
                String diagnosis = diagnosisEditText.getText().toString();
                String admissionDate = admissionDateEditText.getText().toString();
                String bed = bedEditText.getText().toString();
                String physician = physicianSpinner.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("patientName", name);
                resultIntent.putExtra("patientId", id);
                resultIntent.putExtra("dob", dob);
                resultIntent.putExtra("gender", gender);
                resultIntent.putExtra("weight", weight);
                resultIntent.putExtra("diagnosis", diagnosis);
                resultIntent.putExtra("admission", admissionDate);
                resultIntent.putExtra("bed", bed);
                resultIntent.putExtra("physician", physician);
                resultIntent.putExtra("patientStatus", "Stable"); 
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("patientName")) {
            String patientName = intent.getStringExtra("patientName");
            String patientId = intent.getStringExtra("patientId");
            String diagnosis = intent.getStringExtra("diagnosis");
            String bed = intent.getStringExtra("bed");
            String admission = intent.getStringExtra("admission");
            String physician = intent.getStringExtra("physician");

            fullNameEditText.setText(patientName);
            patientIdEditText.setText(patientId);
            diagnosisEditText.setText(diagnosis);
            bedEditText.setText(bed);
            admissionDateEditText.setText(admission);
            physicianSpinner.setText(physician, false);
        }
    }

    private void showDatePickerDialog(final TextInputEditText dateEditText) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        dateEditText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }
}