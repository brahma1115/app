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

    public static List<Patient> patients = new ArrayList<>();
    private String currentFilter = "All";
    private String currentSearchQuery = "";

    BottomNavigationView bottomNavigationView;
    LinearLayout patientCardsContainer;
    Button allButton, criticalButton, stableButton;
    ImageView addPatientButton;
    SearchView searchView;

    public static class Patient {
        String patientName, patientId, patientStatus, diagnosis, bed, admission, physician, heartRate, spo2, gender, age;

        public Patient(String patientName, String patientId, String patientStatus, String diagnosis, String bed, String admission, String physician, String heartRate, String spo2, String gender, String age) {
            this.patientName = patientName;
            this.patientId = patientId;
            this.patientStatus = patientStatus;
            this.diagnosis = diagnosis;
            this.bed = bed;
            this.admission = admission;
            this.physician = physician;
            this.heartRate = heartRate;
            this.spo2 = spo2;
            this.gender = gender;
            this.age = age;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);

        if (patients.isEmpty()) {
            // Updated with Indian Names
            patients.add(new Patient("Rajesh Kumar", "P001", "Critical", "Severe ARDS", "ICU-01", "Oct 12, 2023", "Dr. Wilson", "102 bpm", "94%", "Male", "65 y"));
            patients.add(new Patient("Priya Sharma", "P002", "Warning", "Acute COPD", "ICU-02", "Oct 15, 2023", "Dr. Adams", "90 bpm", "96%", "Female", "54 y"));
            patients.add(new Patient("Amit Patel", "P003", "Normal", "Post-Op Recovery", "ICU-03", "Oct 18, 2023", "Dr. Miller", "80 bpm", "98%", "Male", "72 y"));
            patients.add(new Patient("Sneha Reddy", "P004", "Normal", "Mild Pneumonia", "ICU-04", "Oct 20, 2023", "Dr. Clark", "85 bpm", "97%", "Female", "45 y"));
            patients.add(new Patient("Vikram Singh", "P005", "Warning", "COVID-19", "ICU-05", "Oct 22, 2023", "Dr. Lewis", "95 bpm", "95%", "Male", "58 y"));
            patients.add(new Patient("Anjali Gupta", "P006", "Normal", "Observation", "Ward-10", "Oct 24, 2023", "Dr. Brown", "78 bpm", "99%", "Female", "32 y"));
            patients.add(new Patient("Rahul Verma", "P007", "Critical", "Septic Shock", "ICU-06", "Oct 25, 2023", "Dr. White", "120 bpm", "91%", "Male", "60 y"));
            patients.add(new Patient("Sunita Rao", "P008", "Warning", "Heart Failure", "CCU-02", "Oct 26, 2023", "Dr. Davis", "88 bpm", "93%", "Female", "68 y"));
            patients.add(new Patient("Sanjay Iyer", "P009", "Normal", "Routine Pre-Op", "Ward-05", "Oct 27, 2023", "Dr. Martinez", "72 bpm", "98%", "Male", "40 y"));
            patients.add(new Patient("Deepa Nair", "P010", "Critical", "Trauma", "ICU-07", "Oct 28, 2023", "Dr. Thompson", "110 bpm", "92%", "Female", "29 y"));

            patients.add(new Patient("Thomas Chacko", "P011", "Normal", "General Checkup", "Ward-02", "Oct 29, 2023", "Dr. Moore", "70 bpm", "99%", "Male", "50 y"));
            patients.add(new Patient("Kavita Joshi", "P012", "Warning", "Hypertension", "CCU-03", "Oct 30, 2023", "Dr. Taylor", "92 bpm", "95%", "Female", "62 y"));
            patients.add(new Patient("Arjun Deshmukh", "P013", "Critical", "Renal Failure", "ICU-08", "Oct 31, 2023", "Dr. Anderson", "105 bpm", "90%", "Male", "55 y"));
            patients.add(new Patient("Meera Krishnan", "P014", "Normal", "Stable", "Ward-08", "Nov 01, 2023", "Dr. Thomas", "75 bpm", "98%", "Female", "48 y"));
            patients.add(new Patient("Daniel D'Souza", "P015", "Warning", "Asthma", "Ward-04", "Nov 02, 2023", "Dr. Jackson", "88 bpm", "94%", "Male", "35 y"));
            patients.add(new Patient("Lakshmi Devi", "P016", "Critical", "Cardiac Arrest", "ICU-09", "Nov 03, 2023", "Dr. Harris", "130 bpm", "88%", "Female", "70 y"));
            patients.add(new Patient("Manish Malhotra", "P017", "Normal", "Observation", "Ward-06", "Nov 04, 2023", "Dr. Nelson", "82 bpm", "97%", "Male", "42 y"));
            patients.add(new Patient("Swati Prabhu", "P018", "Warning", "Infection", "Ward-01", "Nov 05, 2023", "Dr. King", "98 bpm", "93%", "Female", "52 y"));
            patients.add(new Patient("Gaurav Kapoor", "P019", "Critical", "Pneumothorax", "ICU-10", "Nov 06, 2023", "Dr. Wright", "115 bpm", "89%", "Male", "67 y"));
            patients.add(new Patient("Pooja Hegde", "P020", "Normal", "Recovery", "Ward-03", "Nov 07, 2023", "Dr. Lopez", "76 bpm", "98%", "Female", "44 y"));
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
            TextView detailsTextView = patientCardView.findViewById(R.id.patientDetails);
            TextView bedTextView = patientCardView.findViewById(R.id.patientBed);
            TextView statusTextView = patientCardView.findViewById(R.id.patientStatus);
            TextView conditionTextView = patientCardView.findViewById(R.id.patientCondition);
            ImageView profileImageView = patientCardView.findViewById(R.id.patientIcon);

            nameTextView.setText(patient.patientName);
            detailsTextView.setText("ID: " + patient.patientId + "  •  " + patient.age);
            bedTextView.setText("Bed: " + patient.bed);
            statusTextView.setText("● " + patient.patientStatus);
            conditionTextView.setText(patient.diagnosis);

            if ("Female".equalsIgnoreCase(patient.gender)) {
                profileImageView.setImageResource(R.drawable.female);
            } else {
                profileImageView.setImageResource(R.drawable.male);
            }

            if ("Critical".equalsIgnoreCase(patient.patientStatus)) {
                statusTextView.setTextColor(ContextCompat.getColor(this, R.color.critical_red));
                statusTextView.setBackgroundResource(R.drawable.status_critical_background);
            } else if ("Warning".equalsIgnoreCase(patient.patientStatus)) {
                statusTextView.setTextColor(ContextCompat.getColor(this, R.color.warning_orange));
                statusTextView.setBackgroundResource(R.drawable.status_warning_background);
            } else {
                statusTextView.setTextColor(ContextCompat.getColor(this, R.color.normal_green));
                statusTextView.setBackgroundResource(R.drawable.status_normal_background);
            }

            patientCardView.setOnClickListener(v -> openPatientDetails(patient));
            patientCardsContainer.addView(patientCardView);
        }
    }

    private void openPatientDetails(Patient patient) {
        Intent intent = new Intent(this, PatientDetailsActivity.class);
        intent.putExtra("patientName", patient.patientName);
        intent.putExtra("patientId", "ID: " + patient.patientId + " • " + patient.age + " • " + patient.gender);
        intent.putExtra("patientStatus", patient.patientStatus);
        intent.putExtra("diagnosis", patient.diagnosis);
        intent.putExtra("bed", patient.bed);
        intent.putExtra("admission", patient.admission);
        intent.putExtra("physician", patient.physician);
        intent.putExtra("heartRate", patient.heartRate);
        intent.putExtra("spo2", patient.spo2);
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
