package com.juicle.app.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.juicle.app.R;
import com.juicle.app.base.BaseApplication;

/**
 * Created by juicle on 2016/12/22.
 */

public class IconView extends TextView {

    private String iconStyle;
    private int mTextColor;
    private int mTextSize;

    private Rect mBound;
    private Paint mPaint;

    public IconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public IconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public IconView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context){
        Typeface iconTypeFace = Typeface.createFromAsset(context.getAssets(), "fontawesome-webfont.ttf");
        setTypeface(iconTypeFace);
    }



}
