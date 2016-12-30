package com.csdn.animation.ui;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.csdn.animation.R;
import com.csdn.animation.base.BaseActivity;

public class TweenAnimation extends BaseActivity {

    private int currAngle;
    private android.widget.ImageView piechart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tween_main);
        this.piechart = (ImageView) findViewById(R.id.img);
       /* Animation alpha = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        piechart.startAnimation(alpha);


        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        piechart.startAnimation(rotate);


        Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        piechart.startAnimation(scale);*/


        Animation translate = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
        translate.setDuration(2000);
        piechart.startAnimation(translate);









     /*   //动画集
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(alpha);
        set.addAnimation(rotate);

        //设置动画时间 (作用到每个动画)
        set.setDuration(1000);
        piechart.startAnimation(set);
*/






    }

    @Override
    public void onClick(View v) {


    }


    public void positive(View v) {
        Animation anim = new RotateAnimation(currAngle, currAngle + 180, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        /** 匀速插值器 */
        LinearInterpolator lir = new LinearInterpolator();
        anim.setInterpolator(lir);
        anim.setDuration(1000);
        /** 动画完成后不恢复原状 */
        anim.setFillAfter(true);
        currAngle += 180;
        if (currAngle > 360) {
            currAngle = currAngle - 360;
        }
        piechart.startAnimation(anim);
    }

    public void negative(View v) {
        Animation anim = new RotateAnimation(currAngle, currAngle - 180, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        /** 匀速插值器 */
        LinearInterpolator lir = new LinearInterpolator();
        anim.setInterpolator(lir);
        anim.setDuration(1000);
        /** 动画完成后不恢复原状 */
        anim.setFillAfter(true);
        currAngle -= 180;
        if (currAngle < -360) {
            currAngle = currAngle + 360;
        }
        piechart.startAnimation(anim);
    }











    public void set(View v){
/*
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        //设置动画时间
        alphaAnimation.setDuration(3000);
        piechart.startAnimation(alphaAnimation);


        RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f);
        rotateAnimation.setDuration(1000);
        piechart.startAnimation(rotateAnimation);



        //初始化
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f, 1.0f,0.1f,1.0f);
        //设置动画时间
        scaleAnimation.setDuration(500);
        piechart.startAnimation(scaleAnimation);*/

        //初始化
        TranslateAnimation translateAnimation = new TranslateAnimation(0.1f, 100.0f,0.1f,100.0f);
        //设置动画时间
        translateAnimation.setDuration(1000);
        piechart.startAnimation(translateAnimation);




/*

        TranslateAnimation   translateAnimation = new TranslateAnimation(0.1f, 100.0f,0.1f,100.0f);
        //初始化 Alpha动画
        AlphaAnimation  alphaAnimation = new AlphaAnimation(0.1f, 1.0f);

        //动画集
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(translateAnimation);
        set.addAnimation(alphaAnimation);

        //设置动画时间 (作用到每个动画)
        set.setDuration(1000);
        piechart.startAnimation(set);

        */
    }















}