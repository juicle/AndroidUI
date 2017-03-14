package com.juicle.app.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.juicle.app.R;
import com.juicle.app.util.DisplayUtil;

/**
 * Created by juicle on 2017/1/13.
 */

public class BaseRadioButton extends LinearLayout implements View.OnClickListener {

    private int selectIndex;
    private String selectText;
    private String[] radioTextList;
    private int radioTextColor;
    private int radioTextSize;
    private int radioImageColor;
    private int radioImageSize;
    private String[] radioIcon;
    private boolean isCheck;
    private int mNum;
    private float radioMargin;
    private float groupMargin;
    private Object mTagIconView = new Object();
    private Context mContext;
    private View mContentView;
    private LinearLayout mContainer;
    private static int DEFAULT_SELECTED_INDEX = 0;
    private static final int RADIO_TEXT_COLOR = R.color.colorPrimary;
    private static final float RADIO_TEXT_SIZE = R.dimen.text_size_16;
    private static final int RADIO_IMAGE_COLOR = R.color.colorPrimary;
    private static final float RADIO_IMAGE_SIZE = R.dimen.text_size_16;
    private static final float DEFAULT_MARGIN = R.dimen.space_10;
    private static final boolean IS_CHECK = false;


    public BaseRadioButton(Context context) {
        super(context);
    }

    public BaseRadioButton(Context context, AttributeSet attrs){
        super(context, attrs);
        mContext = context;
        mContentView = inflate(context, R.layout.radiobutton, this);
        mContainer = (LinearLayout)mContentView.findViewById(R.id.container);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.BaseRadioButton);
        int n = a.getIndexCount();
        for(int i = 0; i < n; i++){
            int attr = a.getIndex(i);
            switch (attr){
                case R.styleable.BaseRadioButton_selectIndex:
                    selectIndex = a.getInt(attr, DEFAULT_SELECTED_INDEX);
                    break;
                case R.styleable.BaseRadioButton_radioText:
                    radioTextList = mContext.getResources().getStringArray(a.getResourceId(attr, 0));
                    break;
                case R.styleable.BaseRadioButton_radioTextColor:
                    radioTextColor = a.getColor(attr, RADIO_TEXT_COLOR);
                    break;
                case R.styleable.BaseRadioButton_radioTextSize:
                    radioTextSize = DisplayUtil.px2sp(context, a.getDimensionPixelSize(attr, DisplayUtil.sp2px(context, RADIO_TEXT_SIZE)));
                    break;
                case R.styleable.BaseRadioButton_radioImageColor:
                    radioImageColor = a.getColor(attr, RADIO_IMAGE_COLOR);
                    break;
                case R.styleable.BaseRadioButton_radioImageSize:
                    radioImageSize = DisplayUtil.px2sp(context, a.getDimensionPixelSize(attr, DisplayUtil.sp2px(context, RADIO_IMAGE_SIZE)));
                    break;
                case R.styleable.BaseRadioButton_radioMargin:
                    radioMargin = a.getDimension(attr, DEFAULT_MARGIN);
                    break;
                case R.styleable.BaseRadioButton_radioIcon:
                    radioIcon = mContext.getResources().getStringArray(a.getResourceId(attr, 0));
                    break;
                case R.styleable.BaseRadioButton_groupMargin:
                    groupMargin = a.getDimension(attr, DEFAULT_MARGIN);
                    break;
                case R.styleable.BaseRadioButton_isCheck:
                    isCheck = a.getBoolean(attr, IS_CHECK);
                    break;
            }
        }
        a.recycle();

        getRadioCount();

        for(int i = 0; i < mNum; i++){
            LinearLayout ll = new LinearLayout(mContext);
            ll.setOrientation(HORIZONTAL);
            ll.setTag(i);
            ll.setOnClickListener(this);
            IconView radioImage = new IconView(mContext);
            radioImage.setTag(mTagIconView);
            radioImage.setText(radioIcon[0]);
            radioImage.setTextColor(radioImageColor);
            radioImage.setTextSize(radioImageSize);
            TextView radioText = new TextView(mContext);
            radioText.setPadding((int) radioMargin, 0, (int) groupMargin, 0);
            radioText.setText(radioTextList[i]);
            radioText.setTextColor(radioTextColor);
            radioText.setTextSize(radioTextSize);
            ll.addView(radioImage);
            ll.addView(radioText);
            mContainer.addView(ll);
        }
        setSelectedIndex(selectIndex);
    }

    @Override
    public void onClick(View view) {
        Integer index = (Integer)view.getTag();
        if(index != null){
            refreshView(index);
         }else{
            throw new IllegalArgumentException("need to set a tag to LinearLayout element");
         }
    }

    public void getRadioCount(){
       mNum = radioTextList.length;
    }

    public int getSelectIndex(){
       return selectIndex;
    }

    public String getSelectText(){
        return selectText;
    }

    public void setSelectedIndex(int selectedIndex){
        if(selectedIndex >= 0 && selectedIndex < mNum){
           refreshView(selectedIndex);
        }
    }

    private void refreshView(int selectedIndex){
        selectIndex = selectedIndex;
        selectText = radioTextList[selectedIndex];
        IconView radioImage = null;
        LinearLayout clickedLL = null;
        if(isCheck){
            clickedLL = (LinearLayout)this.findViewWithTag(selectedIndex);
            radioImage = (IconView)clickedLL.findViewWithTag(mTagIconView);
            radioImage.setText(radioIcon[1]);
        }else{
            for(int i = 0; i < mNum; i++){
                clickedLL = (LinearLayout)this.findViewWithTag(i);
                radioImage = (IconView)clickedLL.findViewWithTag(mTagIconView);
                if(i == selectedIndex){
                    radioImage.setText(radioIcon[1]);
                }else{
                    radioImage.setText(radioIcon[0]);
                }
            }
        }

    }

}
