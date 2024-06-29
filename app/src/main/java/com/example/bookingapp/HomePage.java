package com.example.bookingapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class HomePage extends AppCompatActivity {

    private int selectTab = 1; //have 4 tab
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        final LinearLayout homeLayout = findViewById(R.id.homeLayout);
        final LinearLayout bookingLayout = findViewById(R.id.bookingLayout);
        final LinearLayout notificationLayout = findViewById(R.id.notificationLayout);
        final LinearLayout profileLayout = findViewById(R.id.profileLayout);

        final ImageView nav1 = findViewById(R.id.bottombar1);
        final ImageView nav2 = findViewById(R.id.bottombar2);
        final ImageView nav3 = findViewById(R.id.bottombar3);
        final ImageView nav4 = findViewById(R.id.bottombar4);

        final TextView text1 = findViewById(R.id.home);
        final TextView text2 = findViewById(R.id.booking);
        final TextView text3 = findViewById(R.id.notification);
        final TextView text4 = findViewById(R.id.profile);

        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).
                replace(R.id.fragment_container, new HomePageFragment(),null).commit();
        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectTab != 1) {
                    selectTab = 1;

                    text2.setVisibility(View.GONE);
                    text3.setVisibility(View.GONE);
                    text4.setVisibility(View.GONE);

                    nav2.setImageResource(R.drawable.bottombar2);
                    nav3.setImageResource(R.drawable.bottombar3);
                    nav4.setImageResource(R.drawable.bottombar4);

                    bookingLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notificationLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    text1.setVisibility(View.VISIBLE);
                    nav1.setImageResource(R.drawable.bottombar1);
                    homeLayout.setBackgroundResource(R.drawable.round_back_home);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1f, 1f, 1f, Animation.RELATIVE_TO_SELF ,0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(300);
                    scaleAnimation.setFillAfter(true);
                    homeLayout.startAnimation(scaleAnimation);
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).
                            replace(R.id.fragment_container, new HomePageFragment(),null).commit();
                }
            }

        });

        bookingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectTab != 2) {
                    selectTab = 2;

                    text1.setVisibility(View.GONE);
                    text3.setVisibility(View.GONE);
                    text4.setVisibility(View.GONE);

                    nav1.setImageResource(R.drawable.bottombar1);
                    nav3.setImageResource(R.drawable.bottombar3);
                    nav4.setImageResource(R.drawable.bottombar4);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notificationLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    text2.setVisibility(View.VISIBLE);
                    nav2.setImageResource(R.drawable.bottombar2);
                    bookingLayout.setBackgroundResource(R.drawable.round_back_home);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1f, 1f, 1f, Animation.RELATIVE_TO_SELF ,0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(300);
                    scaleAnimation.setFillAfter(true);
                    bookingLayout.startAnimation(scaleAnimation);
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true).
                            replace(R.id.fragment_container, new BookingFragment(),null).commit();
                }
            }
        });

        notificationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectTab != 3) {
                    selectTab = 3;

                    text1.setVisibility(View.GONE);
                    text2.setVisibility(View.GONE);
                    text4.setVisibility(View.GONE);

                    nav1.setImageResource(R.drawable.bottombar1);
                    nav2.setImageResource(R.drawable.bottombar2);
                    nav4.setImageResource(R.drawable.bottombar4);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    bookingLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    text3.setVisibility(View.VISIBLE);
                    nav3.setImageResource(R.drawable.bottombar3);
                    notificationLayout.setBackgroundResource(R.drawable.round_back_home);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1f, 1f, 1f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(300);
                    scaleAnimation.setFillAfter(true);
                    notificationLayout.startAnimation(scaleAnimation);
                }
            }
        });

        profileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectTab != 4) {
                    selectTab = 4;
                }

                    text1.setVisibility(View.GONE);
                    text2.setVisibility(View.GONE);
                    text3.setVisibility(View.GONE);

                    nav1.setImageResource(R.drawable.bottombar1);
                    nav2.setImageResource(R.drawable.bottombar2);
                    nav3.setImageResource(R.drawable.bottombar3);

                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    bookingLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    notificationLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    text4.setVisibility(View.VISIBLE);
                    nav4.setImageResource(R.drawable.bottombar4);
                    profileLayout.setBackgroundResource(R.drawable.round_back_home);

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1f, 1f, 1f, Animation.RELATIVE_TO_SELF ,0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
                    scaleAnimation.setDuration(300);
                    scaleAnimation.setFillAfter(true);
                    profileLayout.startAnimation(scaleAnimation);
                    pref = getSharedPreferences("AccountInfo", Context.MODE_PRIVATE);
                    String firstName = pref.getString("FirstName", "");
                    String lastName = pref.getString("LastName", "");
                    String uri = pref.getString("Image", "");
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                        .replace(R.id.fragment_container, profileFragment.newInstance(firstName + " " + lastName,uri), null)
                        .commit();
            }
        });
    }
}

