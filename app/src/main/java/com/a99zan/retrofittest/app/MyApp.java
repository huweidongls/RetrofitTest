package com.a99zan.retrofittest.app;

import android.app.Application;
import android.content.Context;

import com.zhpan.idea.utils.Utils;

/**
 * Created by 99zan on 2018/4/4.
 */

public class MyApp extends Application {
    private static MyApp app;
    public static Context getAppContext() {
        return app;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        app=this;
    }
}
