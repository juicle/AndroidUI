package com.juicle.app.fragment.uifragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import com.juicle.app.R;
import com.juicle.app.base.BaseFragment;
import com.juicle.app.widget.IconView;


/**
 * Created by juicle on 2017/1/5.
 */

public class FontFragment extends BaseFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_font, null);
        initView(view);
        return view;
    }

    @Override
    public void initView(View view) {
        GridLayout iconViewContainer = (GridLayout)view.findViewById(R.id.iconcontainer);
        String[] iconArray = getResources().getStringArray(R.array.iconview_arrays);
        for(String icon : iconArray){
            IconView iconView = new IconView(getContext());
            iconView.setText(icon);
            iconView.setPadding(25,25,25,25);
            iconView.setTextSize(getResources().getDimension(R.dimen.f12));
            iconView.setTextColor(getResources().getColor(R.color.colorPrimary));
            iconViewContainer.addView(iconView);
        }
    }
}
