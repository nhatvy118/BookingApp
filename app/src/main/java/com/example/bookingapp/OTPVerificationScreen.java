package com.example.bookingapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OTPVerificationScreen extends AppCompatActivity {

    private TextView OTP;
    private Button verifyButton;
    private ImageButton backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgot_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        backbtn = findViewById(R.id.back_button);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        OTP = findViewById(R.id.otp_field);
        String otp = getIntent().getStringExtra("correctOtp");
        String optInput = OTP.getText().toString();
        verifyButton = findViewById(R.id.verify_otp_button);
        Log.d("OTP correct", "onCreate: " + otp);
        Log.d("OTP input", "onCreate: " + optInput);
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = getIntent().getStringExtra("correctOtp");
                String optInput = OTP.getText().toString();
                if (otp.equals(optInput)) {
                    showPasswordDialog();
                }else{
                    Toast.makeText(OTPVerificationScreen.this, "Incorrect OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    private void showPasswordDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Password Recovery");
        SharedPreferences pref = getSharedPreferences("AccountInfo", Context.MODE_PRIVATE);
        String pass = pref.getString("Password", "");
        builder.setMessage("Your password is: " + pass); // Replace ******** with actual password
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                // Handle what to do after OK is clicked
                // For example, navigate to another screen
                // Intent intent = new Intent(OTPVerificationScreen.this, NextActivity.class);
                // startActivity(intent);
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}