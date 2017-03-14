package com.juicle.app.ui;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import com.juicle.app.R;
import com.juicle.app.base.BaseActivity;
import com.juicle.app.base.BaseFragment;
import com.juicle.app.fragment.uifragment.ButtonFragment;
import com.juicle.app.fragment.uifragment.FontFragment;
import com.juicle.app.fragment.uifragment.FormFragment;

/**
 * Created by juicle on 2017/1/4.
 */

public class DetailActivity extends BaseActivity {

    public static final int DISPLAY_FONTS = 0;
    public static final int DISPLAY_BUTTON = 1;
    public static final int DISPLAY_FORM = 2;
    public static final int DISPLAY_SEARCHBAR = 3;
    public static final int DISPLAY_LIST = 4;
    public static final int DISPLAY_TAB = 5;
    public static final int DISPLAY_DIALOG = 6;
    public static final int DISPLAY_TOAST = 7;
    public static final int DISPLAY_LOADING = 8;
    public static final int DISPLAY_POPUPWINDOW = 9;
    public static final int DISPLAY_PICKER = 10;
    public static final int DISPLAY_FLASH = 11;
    public static final int DISPLAY_IMGER = 12;
    public static final int DISPLAY_PULLREFRESH = 13;
    public static final int DISPLAY_NOLIMITSCROLL = 14;
    public static final int DISPLAY_LAZYLOAD = 15;
    public static final int DISPLAY_PROGRESSBAR = 16;
    public static final int DISPLAY_CLAENDER = 17;

    public static final String KEY_DISPLAY_TYPE = "KEY_DISPLAY_TYPE";

    @Override
    protected int getLayoutId(){
        return R.layout.detail_layout;
    }

    @Override
    protected void init(Bundle savedInstanceState){
        super.init(savedInstanceState);
        int displayType = getIntent().getIntExtra(KEY_DISPLAY_TYPE,DISPLAY_FONTS);
        BaseFragment fragment = null;
        String[] listArray = getResources().getStringArray(R.array.ui_arrays);
        String actionBarTitle = "";
        switch (displayType){
            case DISPLAY_FONTS:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            case DISPLAY_BUTTON:
                actionBarTitle = listArray[displayType];
                fragment = new ButtonFragment();
                break;
            case DISPLAY_FORM:
                actionBarTitle = listArray[displayType];
                fragment = new FormFragment();
                break;
            case DISPLAY_SEARCHBAR:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            case DISPLAY_LIST:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            case DISPLAY_TAB:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            case DISPLAY_DIALOG:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            case DISPLAY_TOAST:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            case DISPLAY_LOADING:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            case DISPLAY_POPUPWINDOW:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            case DISPLAY_PICKER:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            case DISPLAY_FLASH:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            case DISPLAY_IMGER:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            case DISPLAY_PULLREFRESH:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            case DISPLAY_NOLIMITSCROLL:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            case DISPLAY_LAZYLOAD:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            case DISPLAY_PROGRESSBAR:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            case DISPLAY_CLAENDER:
                actionBarTitle = listArray[displayType];
                fragment = new FontFragment();
                break;
            default:
                break;

        }
        setActionBarTitle(actionBarTitle);
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.container, fragment);
        trans.commitAllowingStateLoss();
    }

    @Override
    public void initView(){

    }

    @Override
    public void initData() {
    }

    @Override
    protected boolean hasBackButton() {
        return true;
    }
}
