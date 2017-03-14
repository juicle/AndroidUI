package com.juicle.app.Entity;

import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by juicle on 2016/12/27.
 */

public abstract class SimpleListEntity {
    protected LinearLayout layout;
    protected ArrayList<String> lists;

    public LinearLayout getLayout(){
        return this.layout;
    }

    public void setLayout(LinearLayout layout){
        this.layout = layout;
    }
}
