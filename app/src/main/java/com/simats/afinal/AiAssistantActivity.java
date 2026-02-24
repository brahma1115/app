package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class AiAssistantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_assistant);

        ImageView backButton = findViewById(R.id.backButton_ai_assistant);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(AiAssistantActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
