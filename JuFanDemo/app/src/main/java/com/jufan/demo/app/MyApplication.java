package com.jufan.demo.app;

import android.app.Application;

import org.xutils.x;

/**
 * Created by admin on 2016/3/11.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Xutils3初始化
        x.Ext.init(this);
        // 设置是否输出debug
        x.Ext.setDebug(true);
    }


}
