package com.example.demo.tabexample.tabhost;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.demo.R;
import com.example.demo.tabexample.activitygroup.GroupActivitySub1;
import com.example.demo.tabexample.activitygroup.GroupActivitySub2;
import com.example.demo.tabexample.activitygroup.GroupActivitySub3;

/**
 * 
 * @author tianmaosheng
 * @since 2015-3-23
 */
public class TabHostActivity extends ActivityGroup {
    
    TabHost _tabHost;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tabhost_activity);
    
        initView();
    }
    
    public void initView() {
        _tabHost = (TabHost) findViewById(R.id.main_tabhost);
        _tabHost.setup(getLocalActivityManager()); // 必须要执行的。。。
        AddTabHost(GroupActivitySub1.class, 0, R.string.tab1, R.drawable.main_tabitem_tab1);
        AddTabHost(GroupActivitySub2.class, 0, R.string.tab2, R.drawable.main_tabitem_tab2);
        AddTabHost(GroupActivitySub3.class, 0, R.string.tab3, R.drawable.main_tabitem_tab3);
    }
    
    private void AddTabHost(Class<?> cls,int tabIndex, int title, int icon) {
        View localWidgetView = LayoutInflater.from(_tabHost.getContext())
                .inflate(R.layout.tabhost_item,_tabHost.getTabWidget(),false);
        
        ((ImageView) localWidgetView
                .findViewById(R.id.imageview_main_activity_tab))
                .setImageResource(icon);
        
        ((TextView) localWidgetView
                .findViewById(R.id.textview_main_activity_tab)).setText(title);
    
        Intent intent = new Intent(this, cls);
        intent.setAction(Intent.ACTION_MAIN);
        _tabHost.addTab(_tabHost.newTabSpec(getResources().getString(R.string.tab1))
                .setIndicator(localWidgetView).setContent(intent));
    }
    
}
