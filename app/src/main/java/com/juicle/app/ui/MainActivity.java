package com.juicle.app.ui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.juicle.app.R;
import com.juicle.app.widget.IconView;
import com.juicle.app.widget.MyFragmentTabHost;
import com.juicle.app.widget.StatusBarWrapper;

public class MainActivity extends AppCompatActivity {

    MyFragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ininView();
    }

    public void ininView(){
        initTabs();

        initDrawer();


        new StatusBarWrapper(this);

        if (android.os.Build.VERSION.SDK_INT > 10) {
            mTabHost.getTabWidget().setShowDividers(0);
        }
        mTabHost.setCurrentTab(0);

    }

    private void initTabs(){
        mTabHost = (MyFragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        MainTab[] tabs = MainTab.values();
        int size = tabs.length;
        for(int i =0; i < size; i++){
            MainTab mainTab = tabs[i];
            TabHost.TabSpec tab = mTabHost.newTabSpec(mainTab.getResName() + this.toString());
            View indicator = View.inflate(this, R.layout.tab_item, null);
            IconView icon = (IconView) indicator.findViewById(R.id.iconview);
            TextView title = (TextView) indicator.findViewById(R.id.textview);
            icon.setText(mainTab.getResIcon());
            title.setText(mainTab.getResName());
            tab.setIndicator(indicator);
            mTabHost.addTab(tab, mainTab.getClz(), null);
        }
    }


    private void initDrawer(){
        String[] titleArray = {"这是一个侧栏","关闭"};
        ListView mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_item, titleArray));
    }





}
