package com.juicle.app.base;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.juicle.app.R;
import com.juicle.app.adapter.SimpleListAdapter;
import com.juicle.app.ui.SettingActivity;

/**
 * Created by juicle on 2016/12/26.
 */

public abstract class BaseViewPagerFragment extends BaseFragment {

    private static final String TAG = "BaseViewPagerFragment";
    protected View mRoot;
    private LinearLayout pager;
    protected ListView listView;
    protected SimpleListAdapter adapter;
    private DrawerLayout drawer;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mRoot == null) {
            View root = inflater.inflate(R.layout.base_viewpage_fragment, null);
            listView = (ListView)root.findViewById(R.id.listview);
            mRoot = root;
            initDrawer(root);
            initExplain(root);
            onSetAdapter(adapter);
        }
        return mRoot;

    }

    private void initDrawer(View view){
        TextView user = (TextView)view.findViewById(R.id.person);
        drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        ListView drawerList = (ListView)drawer.findViewById(R.id.left_drawer);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 1){
                    drawer.closeDrawer(GravityCompat.START);
                }else{
                    Toast.makeText(view.getContext(),"这是一个侧边栏",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initExplain(View view){
        TextView menu = (TextView)view.findViewById(R.id.menu);
        pager = (LinearLayout)getActivity().findViewById(R.id.fragmentpage);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
                //getActivity().overridePendingTransition(R.anim.in_from_down, R.anim.out_to_up);
            }
        });
    }



    protected abstract void onSetAdapter(SimpleListAdapter adapter);


}
