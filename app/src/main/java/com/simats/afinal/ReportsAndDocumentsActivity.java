package com.simats.afinal;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReportsAndDocumentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports_and_documents);

        findViewById(R.id.backButton_reports_and_documents).setOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.reports_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Report> reportList = new ArrayList<>();
        reportList.add(new Report("Daily Progress Note", "Oct 14, 2023  •  1.2 MB"));
        reportList.add(new Report("Ventilator Event Log", "Oct 14, 2023  •  850 KB"));
        reportList.add(new Report("Lab Results Summary", "Oct 13, 2023  •  2.4 MB"));
        reportList.add(new Report("Admission Report", "Oct 12, 2023  •  3.1 MB"));

        ReportsAndDocumentsAdapter adapter = new ReportsAndDocumentsAdapter(this, reportList);
        recyclerView.setAdapter(adapter);
    }
}
