package com.juicle.app.fragment.uifragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.juicle.app.R;
import com.juicle.app.base.BaseFragment;
import com.juicle.app.widget.BaseRadioButton;

/**
 * Created by juicle on 2017/1/10.
 */

public class FormFragment extends BaseFragment {

    BaseRadioButton radio;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, null);
        initView(view);
        initData();
        return view;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData(){}
}
