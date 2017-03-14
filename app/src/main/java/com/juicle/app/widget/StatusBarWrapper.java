package com.juicle.app.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;

import com.juicle.app.R;


/**
 * Created by juicle on 2016/12/27.
 */

public class StatusBarWrapper {
    private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
    private View mStatusBarView;

    public StatusBarWrapper(AppCompatActivity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setupStatusBarView(activity);
        }
    }

    @TargetApi(19)
    private void setupStatusBarView(AppCompatActivity activity) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        winParams.flags |= bits;
        win.setAttributes(winParams);

        mStatusBarView = new View(activity);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, getStatusBarHeight(activity));
        params.gravity = Gravity.TOP;
        mStatusBarView.setLayoutParams(params);
        mStatusBarView.setBackgroundResource(R.color.colorPrimary);
        mStatusBarView.setVisibility(View.VISIBLE);
        ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0).setFitsSystemWindows(true);
        ((ViewGroup) win.getDecorView()).addView(mStatusBarView);
    }

    public void setBackgroundResource(int resId) {
        if(mStatusBarView != null) {
            mStatusBarView.setBackgroundResource(resId);
        }
    }

    public int getStatusBarHeight(Activity activity) {
        Resources res = activity.getResources();
        int result = 0;
        int resourceId = res.getIdentifier(STATUS_BAR_HEIGHT_RES_NAME, "dimen", "android");
        if (resourceId > 0) {
            result = res.getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
