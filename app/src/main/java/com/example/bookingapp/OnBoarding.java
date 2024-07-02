package com.example.bookingapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.bookingapp.Adapter.ViewPagerAdapter;

public class OnBoarding extends AppCompatActivity {
    ViewPager sliderViewPager;
    LinearLayout dotIndicator;
    ViewPagerAdapter viewPagerAdapter;
    Button btnBack,btnSkip,btnNext;

    TextView[] dots;

    ViewPager.OnPageChangeListener viewPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setDotIndicator(position);
            if (position > 0){
                btnBack.setVisibility(View.VISIBLE);
            }else{
                btnBack.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_navigate);

        btnBack = findViewById(R.id.backBtn);
        btnSkip = findViewById(R.id.skipBtn);
        btnNext = findViewById(R.id.nextBtn);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getItem(0) > 0){
                    sliderViewPager.setCurrentItem(getItem(-1), true);
                }
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getItem(0) < 1){
                    sliderViewPager.setCurrentItem(getItem(1), true);
                }else{
                    Intent intent = new Intent(OnBoarding.this, GetStarted.class);
                    startActivity(intent);
                }
            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnBoarding.this, GetStarted.class);
                startActivity(intent);
                finish();
            }
        });
        sliderViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        dotIndicator = (LinearLayout) findViewById(R.id.dotIndicator);
        viewPagerAdapter = new ViewPagerAdapter(this);
        sliderViewPager.setAdapter(viewPagerAdapter);
        setDotIndicator(0);
        sliderViewPager.addOnPageChangeListener(viewPageChangeListener);

    }

    public void setDotIndicator(int position) {
        dots = new TextView[3];
        dotIndicator.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;", Html.FROM_HTML_MODE_LEGACY));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.grey, getApplicationContext().getTheme()));
            dotIndicator.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.black, getApplicationContext().getTheme()));
    }

    private int getItem(int i){
        return sliderViewPager.getCurrentItem() + i;
    }
}