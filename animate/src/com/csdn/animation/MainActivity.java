package com.csdn.animation;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.csdn.animation.base.BaseActivity;
import com.csdn.animation.ui.FrameAnimation;
import com.csdn.animation.ui.PropertyAnimation;
import com.csdn.animation.ui.TweenAnimation;

public class MainActivity extends BaseActivity {

    private android.widget.Button bt1;
    private android.widget.Button bt2;
    private android.widget.Button bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.bt3 = (Button) findViewById(R.id.bt3);
        this.bt2 = (Button) findViewById(R.id.bt2);
        this.bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt1) {

            startActivity(FrameAnimation.class);
        } else if (v.getId() == R.id.bt2) {
            startActivity(TweenAnimation.class);
        } else if (v.getId() == R.id.bt3) {
            startActivity(PropertyAnimation.class);
        }

    }
}