package com.juicle.app.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.juicle.app.R;
import com.juicle.app.adapter.SimpleListAdapter;
import com.juicle.app.base.BaseViewPagerFragment;
import com.juicle.app.ui.DetailActivity;

/**
 * Created by juicle on 2016/12/23.
 */

public class UiFragment extends BaseViewPagerFragment implements AdapterView.OnItemClickListener {

    private LayoutInflater inflater;

    @Override
    protected void onSetAdapter(SimpleListAdapter adapter) {
        FrameLayout actionBar = (FrameLayout)mRoot.findViewById(R.id.general_actionbar);
        TextView tvTitle = (TextView) actionBar.findViewById(R.id.title);
        tvTitle.setText("组件");

        String[] uiLists = getResources().getStringArray(R.array.ui_arrays);
        adapter = new SimpleListAdapter(uiLists, R.layout.list_item, this.getContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("KEY_DISPLAY_TYPE", i);
        getActivity().startActivity(intent);
        getActivity().overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);
    }
}

