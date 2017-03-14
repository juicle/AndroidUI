package com.juicle.app.ui;

import android.view.View;
import android.widget.TextView;

import com.juicle.app.R;
import com.juicle.app.base.BaseActivity;

/**
 * Created by juicle on 2017/1/3.
 */

public class SettingActivity extends BaseActivity{

    private TextView close;

    @Override
    public void initView() {
        close = (TextView)findViewById(R.id.close);
        close.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.setting_layout;
    }


    @Override
    public void onClick(View view) {
        finish();
    }

}
