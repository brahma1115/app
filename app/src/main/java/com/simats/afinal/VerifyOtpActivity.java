package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class VerifyOtpActivity extends AppCompatActivity {

    private EditText otp1, otp2, otp3, otp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VerifyOtpActivity.this, ForgotPasswordActivity.class));
            }
        });

        otp1 = findViewById(R.id.otp1);
        otp2 = findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);

        otp1.addTextChangedListener(new OtpTextWatcher(otp2));
        otp2.addTextChangedListener(new OtpTextWatcher(otp3));
        otp3.addTextChangedListener(new OtpTextWatcher(otp4));
        otp4.addTextChangedListener(new OtpTextWatcher(null));
    }

    private class OtpTextWatcher implements TextWatcher {
        private View nextView;

        OtpTextWatcher(View nextView) {
            this.nextView = nextView;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() == 1) {
                if (nextView != null) {
                    nextView.requestFocus();
                } else {
                    // Last OTP digit entered
                    startActivity(new Intent(VerifyOtpActivity.this, ResetPasswordActivity.class));
                }
            }
        }

        @Override
        public void afterTextChanged(Editable s) {}
    }
}