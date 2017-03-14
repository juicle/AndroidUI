package com.juicle.app.ui;

import com.juicle.app.R;
import com.juicle.app.fragment.AboutFragment;
import com.juicle.app.fragment.DeviceFragment;
import com.juicle.app.fragment.UiFragment;

/**
 * Created by juicle on 2016/12/23.
 */

public enum MainTab {
    UI(0, "组件", R.string.android, UiFragment.class),
    DEVICE(1, "设备", R.string.cog, DeviceFragment.class),
    ABOUT(2, "关于", R.string.user, AboutFragment.class);

    private int idx;
    private String resName;
    private int resIcon;
    private Class<?> clz;

    private MainTab(int idx, String resName, int resIcon, Class<?> clz){
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }
}
