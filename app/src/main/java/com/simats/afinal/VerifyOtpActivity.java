package com.simats.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class VerifyOtpActivity extends AppCompatActivity {

    private EditText otp1, otp2, otp3, otp4, otp5, otp6;
    private TextView resendCodeTextView;
    private Button verifyButton;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

        ImageView backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());

        otp1 = findViewById(R.id.otp1);
        otp2 = findViewById(R.id.otp2);
        otp3 = findViewById(R.id.otp3);
        otp4 = findViewById(R.id.otp4);
        otp5 = findViewById(R.id.otp5);
        otp6 = findViewById(R.id.otp6);
        resendCodeTextView = findViewById(R.id.resendCodeTextView);
        verifyButton = findViewById(R.id.verifyButton);

        // OTP Auto-focus logic
        otp1.addTextChangedListener(new OtpTextWatcher(otp2));
        otp2.addTextChangedListener(new OtpTextWatcher(otp3));
        otp3.addTextChangedListener(new OtpTextWatcher(otp4));
        otp4.addTextChangedListener(new OtpTextWatcher(otp5));
        otp5.addTextChangedListener(new OtpTextWatcher(otp6));
        otp6.addTextChangedListener(new OtpTextWatcher(null));

        startTimer();

        verifyButton.setOnClickListener(v -> {
            String otp = otp1.getText().toString() + otp2.getText().toString() + 
                         otp3.getText().toString() + otp4.getText().toString() + 
                         otp5.getText().toString() + otp6.getText().toString();
            
            if (otp.length() < 6) {
                Toast.makeText(this, "Please enter full 6-digit OTP", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(VerifyOtpActivity.this, ResetPasswordActivity.class));
            }
        });

        resendCodeTextView.setOnClickListener(v -> {
            if (resendCodeTextView.getText().toString().equals("Resend Code")) {
                Toast.makeText(this, "OTP Resent!", Toast.LENGTH_SHORT).show();
                startTimer();
            }
        });
    }

    private void startTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        countDownTimer = new CountDownTimer(59000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                resendCodeTextView.setText(String.format(Locale.getDefault(), "Resend code in 00:%02d", seconds));
                resendCodeTextView.setClickable(false);
                resendCodeTextView.setTextColor(getResources().getColor(android.R.color.darker_gray));
            }

            @Override
            public void onFinish() {
                resendCodeTextView.setText("Resend Code");
                resendCodeTextView.setClickable(true);
                resendCodeTextView.setTextColor(getResources().getColor(R.color.purple_500));
            }
        }.start();
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
            if (s.length() == 1 && nextView != null) {
                nextView.requestFocus();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {}
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
