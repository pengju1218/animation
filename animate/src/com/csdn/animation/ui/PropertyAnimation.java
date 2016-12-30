package com.csdn.animation.ui;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.csdn.animation.R;
import com.csdn.animation.base.BaseActivity;

public class PropertyAnimation extends BaseActivity {

    private int width;
    private int height;
    private ImageView img_babi;
    private Button btnone;
    private Button btntwo;
    private Button btnthree;
    private Button btnfour;
    private LinearLayout ly_root;

    private Button objone;
    private Button objtwo;
    private Button objthree;
    private Button objfour;
    private Button objfive;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_main);
        this.ly_root = (LinearLayout) findViewById(R.id.ly_root);
        this.objfive = (Button) findViewById(R.id.obj_five);
        this.objfour = (Button) findViewById(R.id.obj_four);
        this.objthree = (Button) findViewById(R.id.obj_three);
        this.objtwo = (Button) findViewById(R.id.obj_two);
        this.objone = (Button) findViewById(R.id.obj_one);
        this.img_babi = (ImageView) findViewById(R.id.img_babi);
        this.btnfour = (Button) findViewById(R.id.btn_four);
        this.btnthree = (Button) findViewById(R.id.btn_three);
        this.btntwo = (Button) findViewById(R.id.btn_two);
        this.btnone = (Button) findViewById(R.id.btn_one);

        btnone.setOnClickListener(this);
        btntwo.setOnClickListener(this);
        btnfour.setOnClickListener(this);
        btnthree.setOnClickListener(this);


        objone.setOnClickListener(this);
        objtwo.setOnClickListener(this);
        objthree.setOnClickListener(this);
        objfour.setOnClickListener(this);
        objfive.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_one) {
            lineAnimator();
        } else if (v.getId() == R.id.btn_two) {
            scaleAnimator();
        } else if (v.getId() == R.id.btn_three) {
            raAnimator();
        } else if (v.getId() == R.id.btn_four) {
            circleAnimator();
        } else {
            objAnimation(v.getId());
        }
    }


    //定义一个修改ImageView位置的方法
    private void moveView(View view, int rawX, int rawY) {
        int left = rawX - img_babi.getWidth() / 2;
        int top = rawY - img_babi.getHeight();
        int width = left + view.getWidth();
        int height = top + view.getHeight();
        view.layout(left, top, width, height);
    }


    //定义属性动画的方法：

    //按轨迹方程来运动
    private void lineAnimator() {
        width = ly_root.getWidth();
        height = ly_root.getHeight();
        ValueAnimator xValue = ValueAnimator.ofInt(height, 0, height / 4, height / 2, height / 4 * 3, height);
        xValue.setDuration(3000L);
        xValue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 轨迹方程 x = width / 2
                int y = (Integer) animation.getAnimatedValue();
                int x = width / 2;
                moveView(img_babi, x, y);
            }
        });
        xValue.setInterpolator(new LinearInterpolator());
        xValue.start();
    }

    //缩放效果
    private void scaleAnimator() {
        final float scale = 0.5f;
        AnimatorSet scaleSet = new AnimatorSet();
        ValueAnimator valueAnimatorSmall = ValueAnimator.ofFloat(1.0f, scale);
        valueAnimatorSmall.setDuration(500);

        ValueAnimator valueAnimatorLarge = ValueAnimator.ofFloat(scale, 1.0f);
        valueAnimatorLarge.setDuration(500);

        valueAnimatorSmall.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float scale = (Float) animation.getAnimatedValue();
                img_babi.setScaleX(scale);
                img_babi.setScaleY(scale);
            }
        });
        valueAnimatorLarge.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float scale = (Float) animation.getAnimatedValue();
                img_babi.setScaleX(scale);
                img_babi.setScaleY(scale);
            }
        });

        scaleSet.play(valueAnimatorLarge).after(valueAnimatorSmall);
        scaleSet.start();

        //其实可以一个就搞定的
//        ValueAnimator vValue = ValueAnimator.ofFloat(1.0f, 0.6f, 1.2f, 1.0f, 0.6f, 1.2f, 1.0f);
//        vValue.setDuration(1000L);
//        vValue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float scale = (Float) animation.getAnimatedValue();
//                img_babi.setScaleX(scale);
//                img_babi.setScaleY(scale);
//            }
//        });
//        vValue.setInterpolator(new LinearInterpolator());
//        vValue.start();
    }


    //旋转的同时透明度变化
    private void raAnimator() {
        ValueAnimator rValue = ValueAnimator.ofInt(0, 360);
        rValue.setDuration(1000L);
        rValue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int rotateValue = (Integer) animation.getAnimatedValue();
                img_babi.setRotation(rotateValue);
                float fractionValue = animation.getAnimatedFraction();
                img_babi.setAlpha(fractionValue);
            }
        });
        rValue.setInterpolator(new DecelerateInterpolator());
        rValue.start();
    }

    //圆形旋转
    protected void circleAnimator() {
        width = ly_root.getWidth();
        height = ly_root.getHeight();
        final int R = width / 4;
        ValueAnimator tValue = ValueAnimator.ofFloat(0,
                (float) (2.0f * Math.PI));
        tValue.setDuration(1000);
        tValue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // 圆的参数方程 x = R * sin(t) y = R * cos(t)
                float t = (Float) animation.getAnimatedValue();
                int x = (int) (R * Math.sin(t) + width / 2);
                int y = (int) (R * Math.cos(t) + height / 2);
                moveView(img_babi, x, y);
            }
        });
        tValue.setInterpolator(new DecelerateInterpolator());
        tValue.start();
    }

    private ObjectAnimator animator1;
    private ObjectAnimator animator2;
    private ObjectAnimator animator3;
    private ObjectAnimator animator4;
    private AnimatorSet animSet;

    public void objAnimation(int id) {
        animator1 = ObjectAnimator.ofFloat(img_babi, "alpha", 1f, 0f, 1f, 0f, 1f);
        animator2 = ObjectAnimator.ofFloat(img_babi, "rotation", 0f, 360f, 0f);
        animator3 = ObjectAnimator.ofFloat(img_babi, "scaleX", 2f, 4f, 1f, 0.5f, 1f);
        animator4 = ObjectAnimator.ofFloat(img_babi, "translationY", 10, -100, 700);


        switch (id) {
            case R.id.obj_one:
                animator1.setDuration(3000l);
                animator1.start();
                break;
            case R.id.obj_two:
                animator2.setDuration(3000l);
                animator2.start();
                break;
            case R.id.obj_three:
                animator3.setDuration(3000l);
                animator3.start();
                break;
            case R.id.obj_four:
                animator4.setDuration(3000l);
                animator4.start();
                break;
            case R.id.obj_five:
                //将前面的动画集合到一起~
                animSet = new AnimatorSet();
                animSet.play(animator4).with(animator3).with(animator2).after(animator1);
                animSet.setDuration(5000l);
                animSet.start();
                break;
        }
    }
}