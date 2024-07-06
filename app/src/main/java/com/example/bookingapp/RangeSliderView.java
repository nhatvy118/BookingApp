package com.example.bookingapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class RangeSliderView extends View {

    private static OnRangeChangeListener onRangeChangeListener;
    public static void registerOnRangeChangeListener(Filters context) {
        onRangeChangeListener = (OnRangeChangeListener) context;
    }
    private static final int CIRCLE_RADIUS = 20;
    private static final int LINE_HEIGHT = 10;
    private static final int PADDING = CIRCLE_RADIUS;

    private Paint linePaint;
    private Paint circlePaint;
    private Paint rangePaint;

    private float startX;
    private float endX;

    private final int minValue = 0;
    private final int maxValue = 300;
    private int currentMin;
    private int currentMax;

    public RangeSliderView(Context context) {
        super(context);
        init();
    }

    public RangeSliderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RangeSliderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        startX = currentMin;
        endX = currentMax;
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.parseColor("#B7DFDB"));
        linePaint.setStrokeWidth(LINE_HEIGHT);

        rangePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rangePaint.setColor(Color.parseColor("#089083"));
        rangePaint.setStrokeWidth(LINE_HEIGHT);

        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(Color.parseColor("#01635D"));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        startX = PADDING;
        endX = w - PADDING;
        updateCirclePositionsFromValues(); // Update positions when the size changes
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float centerY = getHeight() / 2f;
        float lineTop = centerY - LINE_HEIGHT / 2f;
        float lineBottom = centerY + LINE_HEIGHT / 2f;

        canvas.drawLine(PADDING, centerY, getWidth() - PADDING, centerY, linePaint);

        if (startX != endX) {
            canvas.drawRect(startX, lineTop, endX, lineBottom, rangePaint);
        }

        canvas.drawCircle(startX, centerY, CIRCLE_RADIUS, circlePaint);
        canvas.drawCircle(endX, centerY, CIRCLE_RADIUS, circlePaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (isTouchInCircle(x, startX)) {
                    startX = x;
                } else if (isTouchInCircle(x, endX)) {
                    endX = x;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (isTouchInCircle(x, startX) && x < endX && x > PADDING) {
                    startX = x;
                } else if (isTouchInCircle(x, endX) && x > startX && x < getWidth() - PADDING) {
                    endX = x;
                }
                break;
            case MotionEvent.ACTION_UP:
                if (startX < PADDING) {
                    startX = PADDING;
                } else if (startX > endX) {
                    startX = endX;
                }
                if (endX > getWidth() - PADDING) {
                    endX = getWidth() - PADDING;
                } else if (endX < startX) {
                    endX = startX;
                }
                break;
        }

        updateValuesFromCirclePositions(); // Update values from circle positions
        invalidate();
        return true;
    }

    private boolean isTouchInCircle(float x, float circleCenterX) {
        return x >= circleCenterX - CIRCLE_RADIUS && x <= circleCenterX + CIRCLE_RADIUS;
    }

    private void updateCirclePositionsFromValues() {
        if (getWidth() > 0) {
            float rangeWidth = getWidth() - 2 * PADDING;
            startX = PADDING + ((float) (getCurrentMin() - minValue) / (maxValue - minValue)) * rangeWidth;
            endX = PADDING + ((float) (getCurrentMax() - minValue) / (maxValue - minValue)) * rangeWidth;
            invalidate();
        }
    }

    private void updateValuesFromCirclePositions() {
        float rangeWidth = getWidth() - 2 * PADDING;
        currentMin = Math.round((float) ((startX - PADDING)/rangeWidth)*maxValue);
        currentMax = Math.round((float) ((endX - PADDING)/rangeWidth)*maxValue);
        onRangeChangeListener.onRangeChange(currentMin,currentMax);
    }

    // Function to set position from value
    public float getPositionFromValue(int value) {
        float rangeWidth = getWidth() - 2 * PADDING;
        return PADDING + ((float) (value - minValue) / (maxValue)) * rangeWidth;
    }

    public void setStartValue(int value) {
        Log.d("TAG", "setStartValue: " + value);
        startX = getPositionFromValue(value);
        currentMin = value;
        updateCirclePositionsFromValues();
        Log.d("TAG", "setStartValue: " + startX);
        invalidate();
    }

    public void setEndValue(int value) {
        Log.d("TAG", "setEndValue: " + value);
        endX = getPositionFromValue(value);
        currentMax = value;
        updateCirclePositionsFromValues();
        Log.d("TAG", "setEndValue: " + endX);
        invalidate();
    }

    // Updated functions to get the current min and max values
    public int getCurrentMin() {
        return currentMin;
//        float rangeWidth = getWidth() - 2 * PADDING;
//        return Math.round((float) ((startX - PADDING)/rangeWidth)*maxValue);
    }

    public int getCurrentMax() {
        return currentMax;
//        float rangeWidth = getWidth() - 2 * PADDING;
//        return Math.round((float) ((endX - PADDING)/rangeWidth)*maxValue);
    }
}
