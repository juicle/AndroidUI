package com.juicle.app;

import com.juicle.app.base.BaseApplication;

/**
 * Created by juicle on 2017/1/10.
 */

public class AppContext extends BaseApplication {

    private static AppContext instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    private void init() {}
}
