package com.simats.afinal;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class PatientsActivity extends AppCompatActivity {

    private static final int ADD_PATIENT_REQUEST = 1;

    // Static list to hold patient data
    public static List<Patient> patients = new ArrayList<>();
    private String currentFilter = "All";
    private String currentSearchQuery = "";

    BottomNavigationView bottomNavigationView;
    LinearLayout patientCardsContainer;
    Button allButton, criticalButton, stableButton;
    ImageView addPatientButton;
    SearchView searchView;

    // Patient Model Class (Inner class)
    public static class Patient {
        String patientName, patientId, patientStatus, diagnosis, bed, admission, physician, heartRate, spo2;

        public Patient(String patientName, String patientId, String patientStatus, String diagnosis, String bed, String admission, String physician, String heartRate, String spo2) {
            this.patientName = patientName;
            this.patientId = patientId;
            this.patientStatus = patientStatus;
            this.diagnosis = diagnosis;
            this.bed = bed;
            this.admission = admission;
            this.physician = physician;
            this.heartRate = heartRate;
            this.spo2 = spo2;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);

        // Initialize static list with default patients only once
        if (patients.isEmpty()) {
            patients.add(new Patient("John Doe", "ID: P001 • 65y", "Critical", "ARDS", "ICU-01", "Oct 12, 2023", "Dr. Wilson", "102 bpm", "94%"));
            patients.add(new Patient("Jane Smith", "ID: P002 • 54y", "Warning", "COPD", "ICU-02", "Oct 15, 2023", "Dr. Adams", "90 bpm", "96%"));
            patients.add(new Patient("Robert Johnson", "ID: P003 • 72y", "Normal", "Post-Op", "ICU-03", "Oct 18, 2023", "Dr. Miller", "80 bpm", "98%"));
            patients.add(new Patient("Emily Davis", "ID: P004 • 45y", "Normal", "Pneumonia", "ICU-04", "Oct 20, 2023", "Dr. Clark", "85 bpm", "97%"));
            patients.add(new Patient("Michael Brown", "ID: P005 • 58y", "Warning", "COVID-19", "ICU-05", "Oct 22, 2023", "Dr. Lewis", "95 bpm", "95%"));
        }

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_patients);
        patientCardsContainer = findViewById(R.id.patient_cards_container);
        allButton = findViewById(R.id.allButton);
        criticalButton = findViewById(R.id.criticalButton);
        stableButton = findViewById(R.id.stableButton);
        addPatientButton = findViewById(R.id.addPatientButton);
        searchView = findViewById(R.id.searchView);

        addPatientButton.setOnClickListener(v -> {
            Intent intent = new Intent(PatientsActivity.this, AddPatientActivity.class);
            startActivityForResult(intent, ADD_PATIENT_REQUEST);
        });

        allButton.setOnClickListener(v -> {
            currentFilter = "All";
            applyFilters();
            updateButtonBackgrounds(allButton);
        });

        criticalButton.setOnClickListener(v -> {
            currentFilter = "Critical";
            applyFilters();
            updateButtonBackgrounds(criticalButton);
        });

        stableButton.setOnClickListener(v -> {
            currentFilter = "Stable";
            applyFilters();
            updateButtonBackgrounds(stableButton);
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                currentSearchQuery = query.toLowerCase();
                applyFilters();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                currentSearchQuery = newText.toLowerCase();
                applyFilters();
                return true;
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_patients) {
                return true;
            } else if (itemId == R.id.navigation_home) {
                startActivity(new Intent(PatientsActivity.this, HomeActivity.class));
                finish();
                return true;
            } else if (itemId == R.id.navigation_monitor) {
                startActivity(new Intent(PatientsActivity.this, MonitorActivity.class));
                finish();
                return true;
            } else if (itemId == R.id.navigation_alerts) {
                startActivity(new Intent(PatientsActivity.this, AlertsOverviewActivity.class));
                finish();
                return true;
            } else if (itemId == R.id.navigation_settings) {
                startActivity(new Intent(PatientsActivity.this, SettingsActivity.class));
                finish();
                return true;
            }
            return false;
        });

        applyFilters();
        updateButtonBackgrounds(allButton);
    }

    private void displayPatients(List<Patient> patientsToDisplay) {
        patientCardsContainer.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(this);
        for (Patient patient : patientsToDisplay) {
            View patientCardView = inflater.inflate(R.layout.patient_card_item, patientCardsContainer, false);

            TextView nameTextView = patientCardView.findViewById(R.id.patientName);
            TextView idTextView = patientCardView.findViewById(R.id.patientDetails);
            TextView diagnosisTextView = patientCardView.findViewById(R.id.patientCondition);
            TextView bedTextView = patientCardView.findViewById(R.id.patientBed);
            TextView statusTextView = patientCardView.findViewById(R.id.patientStatus);

            nameTextView.setText(patient.patientName);
            idTextView.setText(patient.patientId);
            diagnosisTextView.setText(patient.diagnosis);
            bedTextView.setText("Bed: " + patient.bed);
            statusTextView.setText(patient.patientStatus);

            Drawable statusDrawable;
            int statusColor;

            if ("Critical".equalsIgnoreCase(patient.patientStatus)) {
                statusDrawable = ContextCompat.getDrawable(this, R.drawable.dot_critical);
                statusColor = ContextCompat.getColor(this, R.color.critical_red);
                statusTextView.setBackgroundResource(R.drawable.status_critical_background);
            } else if ("Warning".equalsIgnoreCase(patient.patientStatus)) {
                statusDrawable = ContextCompat.getDrawable(this, R.drawable.dot_warning);
                statusColor = ContextCompat.getColor(this, R.color.warning_orange);
                statusTextView.setBackgroundResource(R.drawable.status_warning_background);
            } else { // Normal or Stable
                statusDrawable = ContextCompat.getDrawable(this, R.drawable.dot_normal);
                statusColor = ContextCompat.getColor(this, R.color.normal_green);
                statusTextView.setBackgroundResource(R.drawable.status_normal_background);
            }

            if(statusDrawable != null) {
                DrawableCompat.setTint(statusDrawable, statusColor);
                statusTextView.setCompoundDrawablesWithIntrinsicBounds(statusDrawable, null, null, null);
            }
            statusTextView.setTextColor(statusColor);

            patientCardView.setOnClickListener(v -> openPatientDetails(patient.patientName, patient.patientId, patient.patientStatus, patient.diagnosis, patient.bed, patient.admission, patient.physician, patient.heartRate, patient.spo2));
            patientCardsContainer.addView(patientCardView);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_PATIENT_REQUEST && resultCode == RESULT_OK && data != null) {
            String patientName = data.getStringExtra("patientName");
            String patientId = data.getStringExtra("patientId");
            String diagnosis = data.getStringExtra("diagnosis");
            String bed = data.getStringExtra("bed");
            String admission = data.getStringExtra("admission");
            String physician = data.getStringExtra("physician");
            String patientStatus = data.getStringExtra("patientStatus");

            Patient newPatient = new Patient(patientName, patientId, patientStatus, diagnosis, bed, admission, physician, "N/A", "N/A");
            patients.add(newPatient);

            applyFilters();

            Toast.makeText(this, "Patient " + patientName + " saved", Toast.LENGTH_SHORT).show();
        }
    }

    private void openPatientDetails(String name, String id, String status, String diagnosis, String bed, String admission, String physician, String heartRate, String spo2) {
        Intent intent = new Intent(this, PatientDetailsActivity.class);
        intent.putExtra("patientName", name);
        intent.putExtra("patientId", id);
        intent.putExtra("patientStatus", status);
        intent.putExtra("diagnosis", diagnosis);
        intent.putExtra("bed", bed);
        intent.putExtra("admission", admission);
        intent.putExtra("physician", physician);
        intent.putExtra("heartRate", heartRate);
        intent.putExtra("spo2", spo2);
        startActivity(intent);
    }

    private void applyFilters() {
        List<Patient> filteredAndSearchedPatients = new ArrayList<>();
        for (Patient patient : patients) {
            boolean matchesFilter = "All".equalsIgnoreCase(currentFilter) ||
                    ("Stable".equalsIgnoreCase(currentFilter) && ("Stable".equalsIgnoreCase(patient.patientStatus) || "Normal".equalsIgnoreCase(patient.patientStatus))) ||
                    patient.patientStatus.equalsIgnoreCase(currentFilter);

            boolean matchesSearch = currentSearchQuery.isEmpty() ||
                                  patient.patientName.toLowerCase().contains(currentSearchQuery) ||
                                  patient.patientId.toLowerCase().contains(currentSearchQuery);

            if (matchesFilter && matchesSearch) {
                filteredAndSearchedPatients.add(patient);
            }
        }
        displayPatients(filteredAndSearchedPatients);
    }

    private void updateButtonBackgrounds(Button selectedButton) {
        allButton.setBackgroundResource(R.drawable.filter_button_unselected_background);
        allButton.setTextColor(getResources().getColor(android.R.color.black));
        criticalButton.setBackgroundResource(R.drawable.filter_button_unselected_background);
        criticalButton.setTextColor(getResources().getColor(android.R.color.black));
        stableButton.setBackgroundResource(R.drawable.filter_button_unselected_background);
        stableButton.setTextColor(getResources().getColor(android.R.color.black));

        selectedButton.setBackgroundResource(R.drawable.filter_button_selected_background);
        selectedButton.setTextColor(getResources().getColor(android.R.color.white));
    }
}
