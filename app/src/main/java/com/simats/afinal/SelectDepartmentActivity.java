package com.simats.afinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SelectDepartmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_department);

        findViewById(R.id.backButton).setOnClickListener(v -> finish());

        View.OnClickListener listener = v -> {
            String department = "";
            if (v.getId() == R.id.icuCard) department = "ICU";
            else if (v.getId() == R.id.nicuCard) department = "NICU";
            else if (v.getId() == R.id.picuCard) department = "PICU";
            else if (v.getId() == R.id.ccuCard) department = "CCU";
            else if (v.getId() == R.id.erCard) department = "Emergency Room";
            else if (v.getId() == R.id.wardCard) department = "General Ward";

            SharedPreferences sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("department", department);
            editor.apply();

            Intent intent = new Intent(SelectDepartmentActivity.this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        };

        findViewById(R.id.icuCard).setOnClickListener(listener);
        findViewById(R.id.nicuCard).setOnClickListener(listener);
        findViewById(R.id.picuCard).setOnClickListener(listener);
        findViewById(R.id.ccuCard).setOnClickListener(listener);
        findViewById(R.id.erCard).setOnClickListener(listener);
        findViewById(R.id.wardCard).setOnClickListener(listener);
    }
}