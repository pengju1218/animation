package com.csdn.animation.ui;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.csdn.animation.R;
import com.csdn.animation.base.BaseActivity;

public class FrameAnimation extends BaseActivity {


    private android.widget.ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_main);
        this.img = (ImageView) findViewById(R.id.img);
        img.setBackgroundResource(R.drawable.drawable_animation);
        AnimationDrawable animationDrawable = (AnimationDrawable) img.getBackground();
        animationDrawable.start();

    }

    @Override
    public void onClick(View v) {


    }
}