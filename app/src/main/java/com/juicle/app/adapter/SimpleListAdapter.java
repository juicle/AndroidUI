package com.juicle.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.juicle.app.R;


/**
 * Created by juicle on 2016/12/27.
 */

public class SimpleListAdapter extends BaseAdapter {

    protected String[] mList;
    private int mResource;
    protected Context mContext;

    public SimpleListAdapter(Context context){
        this.mContext = context;
    }

    public SimpleListAdapter(String[] lists, int resource, Context context){
        this.mList = lists;
        this.mContext = context;
        this.mResource = resource;
    }

    @Override
    public int getCount() {
        return mList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        RelativeLayout ll = (RelativeLayout) LayoutInflater.from(mContext).inflate(mResource, null);
        TextView textView = (TextView)ll.findViewById(R.id.title);
        textView.setText(mList[i]);
        return ll;
    }



}
