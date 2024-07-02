package com.example.bookingapp;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {


    private ImageView airplane;
    private ImageView dotLeft;
    private ImageView dotRight;
    private ImageView ellipseFull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        airplane = findViewById(R.id.airplane);
        dotLeft = findViewById(R.id.dot_left);
        dotRight = findViewById(R.id.dot_right);
        ellipseFull = findViewById(R.id.ellipse_full);

        //Run the animation after the layout is laid out
        airplane.post(new Runnable() {
            @Override
            public void run() {
                animateAirplane();
            }
        });

    }

    private void animateAirplane() {
        // Calculate start and end coordinates for the animation
        float startX = dotLeft.getX() + dotLeft.getWidth() / 2 - airplane.getWidth() / 2;
        float startY = dotLeft.getY() + dotLeft.getHeight() / 2 - airplane.getHeight() / 2;
        float endX = dotRight.getX() + dotRight.getWidth() / 2 - airplane.getWidth() / 2;
        float endY = dotRight.getY() + dotRight.getHeight() / 2 - airplane.getHeight() / 2;

        // Define the path along the ellipse
        Path path = new Path();
        path.moveTo(startX, startY); // Start at dot_left position
        path.quadTo(ellipseFull.getX(), ellipseFull.getY() -100, endX, endY -20); // Define a curve through the ellipse
        RectF oval = new RectF(startX, startY, endX, endY); // Define the bounds of the oval (or circle)
        path.addArc(oval, 55, 45);
        // Create ObjectAnimator with PathInterpolator
        ObjectAnimator animator = ObjectAnimator.ofFloat(airplane, airplane.X, airplane.Y, path);
        animator.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.2f, 1f)); // Customize the interpolator for smooth animation
        animator.setDuration(3000); // Adjust duration as needed
        animator.setRepeatCount(2);   // Repeat once (for a total of 2 times)
        animator.setRepeatMode(ObjectAnimator.RESTART);

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                // Animation started
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                // Animation ended
                // Start new activity here
                startActivity(new Intent(SplashScreen.this, OnBoarding.class));
                finish(); // Finish current activity if needed
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                // Animation canceled
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                // Animation repeated
            }
        });
        // Start the animation
        animator.start();

    }
}