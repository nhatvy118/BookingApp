package com.example.bookingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    int sliderAllImages[] = {R.drawable.ob1, R.drawable.ob2};
    int sliderText[] = {R.string.ob1_description, R.string.ob1_description};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return sliderText.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_screen, container, false);
        ImageView sliderImage = (ImageView) view.findViewById(R.id.slideImage);
        TextView sliderText = (TextView) view.findViewById(R.id.sliderText);
        sliderImage.setImageResource(sliderAllImages[position]);
        sliderText.setText(this.sliderText[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}


