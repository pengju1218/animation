package com.csdn.animation.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/12/30.
 */

public abstract class BaseActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //实现无标题栏（但有系统自带的任务栏）：
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public void startActivity(Class a) {
        Intent intent = new Intent(BaseActivity.this, a);
        startActivity(intent);
    }
}
