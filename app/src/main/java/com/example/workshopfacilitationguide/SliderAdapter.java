package com.example.workshopfacilitationguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    //Arrays
    int[] image = {
            R.drawable.empathy_logo,
            R.drawable.create_logo,
            R.drawable.startup_logo
    };

    int[] heading = {
            R.string.first_slide_title,
            R.string.second_slide_title,
            R.string.third_slide_title
    };

    int[] slide_desc = {
            R.string.first_slide_desc,
            R.string.second_slide_desc,
            R.string.third_slide_desc,
    };

    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);


        ImageView slide_image = view.findViewById(R.id.image);
        TextView slide_heading = view.findViewById(R.id.heading);
        TextView slide_description = view.findViewById(R.id.slide_desc);

        slide_image.setImageResource(image[position]);
        slide_heading.setText(heading[position]);
        slide_description.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
