package com.juicle.app.base;

import android.app.Application;
import android.graphics.Typeface;

/**
 * Created by juicle on 2017/1/10.
 */

public class BaseApplication extends Application {

    private static BaseApplication instance;
    public static synchronized BaseApplication getInstance() {
        return instance;
    }
   

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
