package com.juicle.app.fragment.uifragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.juicle.app.R;
import com.juicle.app.base.BaseFragment;

/**
 * Created by juicle on 2017/1/5.
 */

public class ButtonFragment extends BaseFragment{

    private Button tab1,tab2,tab3,tab4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_button, null);
        initView(view);
        initData();
        return view;
    }

    @Override
    public void initView(View view) {
        tab1 = (Button)view.findViewById(R.id.tab1);
        tab2 = (Button)view.findViewById(R.id.tab2);
        tab3 = (Button)view.findViewById(R.id.tab3);
        tab4 = (Button)view.findViewById(R.id.tab4);
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab3.setOnClickListener(this);
        tab4.setOnClickListener(this);
    }

    @Override
    public void initData() {
        resetState(R.id.tab1);
    }

    @Override
    public void onClick(View v){
        resetState(v.getId());
    }

    private void resetState(int id) {
        tab1.setSelected(false);
        tab2.setSelected(false);
        tab3.setSelected(false);
        tab4.setSelected(false);
        switch (id) {
            case R.id.tab1:
                tab1.setSelected(true);
                break;
            case R.id.tab2:
                tab2.setSelected(true);
                break;
            case R.id.tab3:
                tab3.setSelected(true);
                break;
            case R.id.tab4:
                tab4.setSelected(true);
                break;
        }
    }

}
