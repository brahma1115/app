package com.simats.afinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SelectHospitalActivity extends AppCompatActivity {

    private CardView hospitalCard1, hospitalCard2, hospitalCard3, hospitalCard4;
    private TextView hospitalName1, hospitalName2, hospitalName3, hospitalName4;
    private EditText searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_hospital);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        searchView = findViewById(R.id.searchView);
        hospitalCard1 = findViewById(R.id.hospital1);
        hospitalCard2 = findViewById(R.id.hospital2);
        hospitalCard3 = findViewById(R.id.hospital3);
        hospitalCard4 = findViewById(R.id.hospital4);

        hospitalName1 = findViewById(R.id.hospital1_name);
        hospitalName2 = findViewById(R.id.hospital2_name);
        hospitalName3 = findViewById(R.id.hospital3_name);
        hospitalName4 = findViewById(R.id.hospital4_name);

        // Search logic
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterHospitals(s.toString().toLowerCase());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        View.OnClickListener listener = v -> {
            String hospitalName = "";
            if (v.getId() == R.id.hospital1) hospitalName = hospitalName1.getText().toString();
            else if (v.getId() == R.id.hospital2) hospitalName = hospitalName2.getText().toString();
            else if (v.getId() == R.id.hospital3) hospitalName = hospitalName3.getText().toString();
            else if (v.getId() == R.id.hospital4) hospitalName = hospitalName4.getText().toString();

            SharedPreferences sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("hospital", hospitalName);
            editor.apply();

            startActivity(new Intent(SelectHospitalActivity.this, SelectDepartmentActivity.class));
        };

        hospitalCard1.setOnClickListener(listener);
        hospitalCard2.setOnClickListener(listener);
        hospitalCard3.setOnClickListener(listener);
        hospitalCard4.setOnClickListener(listener);
    }

    private void filterHospitals(String query) {
        if (query.isEmpty()) {
            hospitalCard1.setVisibility(View.VISIBLE);
            hospitalCard2.setVisibility(View.VISIBLE);
            hospitalCard3.setVisibility(View.VISIBLE);
            hospitalCard4.setVisibility(View.VISIBLE);
            return;
        }

        hospitalCard1.setVisibility(hospitalName1.getText().toString().toLowerCase().contains(query) ? View.VISIBLE : View.GONE);
        hospitalCard2.setVisibility(hospitalName2.getText().toString().toLowerCase().contains(query) ? View.VISIBLE : View.GONE);
        hospitalCard3.setVisibility(hospitalName3.getText().toString().toLowerCase().contains(query) ? View.VISIBLE : View.GONE);
        hospitalCard4.setVisibility(hospitalName4.getText().toString().toLowerCase().contains(query) ? View.VISIBLE : View.GONE);
    }
}
