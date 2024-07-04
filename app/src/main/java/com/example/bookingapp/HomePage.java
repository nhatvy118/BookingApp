package com.example.bookingapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookingapp.Fragment.BookingFragment;
import com.example.bookingapp.Fragment.HomePageFragment;
import com.example.bookingapp.Fragment.ProfileFragment;

public class HomePage extends AppCompatActivity{

    private int selectTab = 1; //have 4 tab
    private SharedPreferences pref;
    private LinearLayout homeLayout;
    private LinearLayout bookingLayout;
    private LinearLayout notificationLayout;
    private LinearLayout profileLayout;
    private ImageView nav1;
    private ImageView nav2;
    private ImageView nav3;
    private ImageView nav4;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);
        homeLayout = findViewById(R.id.homeLayout);
        bookingLayout = findViewById(R.id.bookingLayout);
        notificationLayout = findViewById(R.id.notificationLayout);
        profileLayout = findViewById(R.id.profileLayout);

        nav1 = findViewById(R.id.bottombar1);
        nav2 = findViewById(R.id.bottombar2);
        nav3 = findViewById(R.id.bottombar3);
        nav4 = findViewById(R.id.bottombar4);

        text1 = findViewById(R.id.home);
        text2 = findViewById(R.id.booking);
        text3 = findViewById(R.id.notification);
        text4 = findViewById(R.id.profile);

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
                            replace(R.id.fragment_container, new HomePageFragment(),null).
                            addToBackStack(null).commit();
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
                            replace(R.id.fragment_container, new BookingFragment(),null).
                            addToBackStack(null).commit();
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
                        .replace(R.id.fragment_container, ProfileFragment.newInstance(firstName + " " + lastName,uri), null)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    public void navigateToBookingFragment(){
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
    }
    public void navigateToHome(){
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

    }
}
