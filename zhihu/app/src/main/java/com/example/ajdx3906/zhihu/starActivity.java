package com.example.ajdx3906.zhihu;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by AJDX3906 on 2017/2/22.
 */

public class starActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
    }
}

