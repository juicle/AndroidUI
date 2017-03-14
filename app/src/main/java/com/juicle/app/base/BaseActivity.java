package com.juicle.app.base;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.juicle.app.AppManager;
import com.juicle.app.R;
import com.juicle.app.interf.BaseViewInterface;
import com.juicle.app.widget.StatusBarWrapper;


public class BaseActivity extends AppCompatActivity  implements View.OnClickListener, BaseViewInterface {

    protected ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        onBeforeSetContentLayout();
        mActionBar = getSupportActionBar();

        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        new StatusBarWrapper(this);
        init(savedInstanceState);
        initView();
        initData();
        if (hasActionBar()) {
            initActionBar(mActionBar);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.in_from_left,R.anim.out_to_right);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }

    protected int getLayoutId() {
        return 0;
    }

    protected void onBeforeSetContentLayout() {
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    public void setActionBarTitle(String title) {
        mActionBar.setTitle(title);
    }

    protected void initActionBar(ActionBar actionBar) {
        if (actionBar == null)
            return;
        if (hasBackButton()) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeButtonEnabled(true);
        } else {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE);
            actionBar.setDisplayUseLogoEnabled(false);
            int titleRes = getActionBarTitle();
            if (titleRes != 0) {
                actionBar.setTitle(titleRes);
            }
        }
    }

    protected int getActionBarTitle() {
        return R.string.app_name;
    }

    protected boolean hasBackButton() {
        return false;
    }

    protected boolean hasActionBar() {
        return getSupportActionBar() != null;
    }

    protected void init(Bundle savedInstanceState) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
