package com.simats.afinal;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PatientHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_history);

        findViewById(R.id.backButton_patient_history).setOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.patient_history_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<PatientHistoryItem> historyList = new ArrayList<>();
        historyList.add(new PatientHistoryItem("14:30 Today", "High Pressure Alert", "Peak pressure exceeded 40 cmH2O", R.drawable.ic_warning, R.drawable.timeline_dot_red));
        historyList.add(new PatientHistoryItem("12:00 Today", "Settings Adjusted", "FiO2 increased to 60% by Dr. Wilson", R.drawable.img_3, R.drawable.timeline_dot_blue));
        historyList.add(new PatientHistoryItem("08:00 Today", "Morning Rounds", "Patient stable, sedation reduced.", R.drawable.img_25, R.drawable.timeline_dot_grey));
        historyList.add(new PatientHistoryItem("22:15 Yesterday", "SpO2 Drop", "SpO2 dropped to 88% for 2 mins", R.drawable.ic_warning, R.drawable.timeline_dot_red));
        historyList.add(new PatientHistoryItem("18:00 Yesterday", "Intubation", "Patient intubated due to respiratory failure", R.drawable.img_26, R.drawable.timeline_dot_purple));

        PatientHistoryAdapter adapter = new PatientHistoryAdapter(this, historyList);
        recyclerView.setAdapter(adapter);
    }
}
