package com.example.bookingapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
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

import com.google.android.material.textfield.TextInputEditText;

public class SignInScreen extends AppCompatActivity {

    private ImageButton backBtn;
    private Button logInBtn;
    private TextInputEditText acc, pass;
    private SharedPreferences pref;
    private TextView forgotPass;

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in_screen);
        backBtn = findViewById(R.id.backbtn);
        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(SignInScreen.this, WelcomeScreen.class);
            startActivity(intent);
            finish();
        });
        logInBtn = findViewById(R.id.logIn);
        forgotPass = findViewById(R.id.forgotPass);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pref = getSharedPreferences("AccountInfo", Context.MODE_PRIVATE);
                String passWord = pref.getString("Password", "");
                String email = pref.getString("Email", "");
                pass = findViewById(R.id.pass_word);
                acc = findViewById(R.id.account_email);
                if (pass.getText().toString().equals(passWord) && acc.getText().toString().equals(email)) {
                Intent intent = new Intent(SignInScreen.this, HomePage.class);
                startActivity(intent);
                finish();
                }
                else {
                    Toast.makeText(SignInScreen.this, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acc = findViewById(R.id.account_email);
                String email = acc.getText().toString();
                SharedPreferences pref = getSharedPreferences("AccountInfo", Context.MODE_PRIVATE);
                String savedEmail = pref.getString("Email", "");
                String phoneNumber = pref.getString("PhoneNumber", ""); // Assuming you have saved the phone number during sign-up

                if (email.equals(savedEmail)) {
                    // Generate OTP
                    String otp = generateOtp(); // Implement this method to generate a random OTP
                    sendOtpToPhoneNumber(phoneNumber, otp); // Implement this method to send OTP via SMS


                    Intent intent = new Intent(SignInScreen.this, OTPVerificationScreen.class);
                    intent.putExtra("correctOtp", otp);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignInScreen.this, "Email not found", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private String generateOtp() {
        // Generate a random 6-digit OTP
        int randomOtp = (int)(Math.random() * 900000) + 100000;
        return String.valueOf(randomOtp);
    }

    private void sendOtpToPhoneNumber(String phoneNumber, String otp) {
        String phonenumber = phoneNumber;
        String OTP = otp;
        try {
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage(phonenumber,null,OTP,null,null);
            Toast.makeText(getApplicationContext(),"OTP Sent",Toast.LENGTH_LONG).show();
            Log.d("TAG",OTP);
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Please allow SMS",Toast.LENGTH_LONG).show();
        }
    }

}