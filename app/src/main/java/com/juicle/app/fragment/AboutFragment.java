package com.juicle.app.fragment;

import android.widget.FrameLayout;
import android.widget.TextView;

import com.juicle.app.R;
import com.juicle.app.adapter.SimpleListAdapter;
import com.juicle.app.base.BaseViewPagerFragment;

/**
 * Created by juicle on 2016/12/23.
 */

public class AboutFragment extends BaseViewPagerFragment {
    @Override
    protected void onSetAdapter(SimpleListAdapter adapter) {
        FrameLayout actionBar = (FrameLayout)mRoot.findViewById(R.id.general_actionbar);
        TextView tvTitle = (TextView) actionBar.findViewById(R.id.title);
        tvTitle.setText("关于");
    }
}
